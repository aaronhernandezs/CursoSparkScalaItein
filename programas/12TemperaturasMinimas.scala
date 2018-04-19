package paquete

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import scala.math.min

/**programa para encontrar temperaturas minimas por estacion**/
object TemperaturaMin {
  
  def parseLine(line:String)= {
    val TIPSalto = line.split(",")
    val IDestacion = TIPSalto(0)
    val TIPentra = TIPSalto(2)
    val temperatura = TIPSalto(3).toFloat * 0.1f * (9.0f / 5.0f) + 32.0f
    (IDestacion, TIPentra, temperatura)
  }
  def celsius (temp : Double)  = {
    (temp -32) / 1.800
  }
    /** creacion de funcion para procesar */
  def main(args: Array[String]) {
   
    // configuramos nuestro log para que solo nos muestre los errores
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    // creamos nuestro contexto spark.
    val sc = new SparkContext("local[*]", "TempMin")
    
    // se lee cada  linea de nuestro archivo csv
    val lines = sc.textFile("../1800.csv")
    
    // convertimos  (IDestacion, TIPentra, temperatura) a tuplas
    val parsedLines = lines.map(parseLine)
    
    // se filtran la columna 2 donde sea igual a "TMIN"
    val minTemps = parsedLines.filter(x => x._2 == "TMIN")
    
    // se convierte IDsestacion y temperatura en flotante
    val stationTemps = minTemps.map(x => (x._1, x._3.toFloat))
    
    // reducimos IDestacion conservando la temperatura minima
    val minTempsByStation = stationTemps.reduceByKey( (x,y) => min(x,y))
    
    // se da formato y se imprimen los resultados
    val results = minTempsByStation.collect()
    
    for (result <- results.sorted) {
       val estation = result._1
       val temp = result._2
       val formatTemp = f"$temp%.2f F"
       val cel = celsius(temp)
       println(f"El estado con ID $estation tiene una temperatura minima: $formatTemp , en grados celsius: $cel%.2f") 
    }
      
  }
}