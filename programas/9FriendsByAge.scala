package paquete

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

/**obteniendo el promedio de amigos en redes sociales por edad */
object AmigosEdad {
  
  /** Es creada una funcion el cual nos va a permitir dividir la edad y el numero de amigos */
  def parseLine(line: String) = {
      // las divisiones son por comas
      val fields = line.split(",")
      // se extrae la edad y el nuemro de amigos 
      val age = fields(2).toInt
      val numFriends = fields(3).toInt
      // se crea una tupla para nuestro resultado
      ( age, numFriends)
  }
  
  //desarrollamos una funcion, donde se realizaran las operaciones
  def main(args: Array[String]) {
   
    // configuramos el log para que solo nos muestre los errores
    Logger.getLogger("org").setLevel(Level.ERROR)
        
    // creamos nuestro sparkContext para ejecutar localmente
    val sc = new SparkContext("local[*]", "AmigosEdad")//local[*], el numero de cores a usar en tu cluster, ,"" nombre de la aplicacion
  
    // caragamos nuestro archivo csv a una variable lines.
    val lines = sc.textFile("../fakefriends.csv")
    
    //usamos nuestra funcion parseLine para dividir las edades del numero de amigos
    val rdd = lines.map(parseLine)
    
// Mucho por aquí ...
    // Estamos comenzando con un RDD de forma (age, numFriends) donde la edad es la LLAVE y numFriends es el VALOR
    // Utilizamos mapValues ​​para convertir cada valor de numFriends en una tupla de (numFriends, 1)
    // Luego usamos reduceByKey para resumir el total numFriends y el total de instancias para cada edad, por
    // sumando todos los valores numFriends y 1's respectivamente.
    val totalsByAge = rdd.mapValues(x => (x, 1)).reduceByKey( (x,y) => (x._1 + y._1, x._2 + y._2))
 

// Entonces ahora tenemos tuplas de (age, (totalFriends, totalInstances))
    // Para calcular el promedio, dividimos total Friends / totalInstances para cada edad.
    val averagesByAge = totalsByAge.mapValues(x => x._1 / x._2)
   
    val ordenado = averagesByAge.map(x =>( x._2, x._1))
    val ord = ordenado.collect()
    ord.sorted.foreach(println)
    // 
//Recoja los resultados del RDD (Esto inicia el cálculo del DAG y realmente ejecuta el trabajo)
   val results = averagesByAge.collect()
    
    // finalmente se ordenan los resultados .
    results.sorted.foreach(println)
  }
    
}
  