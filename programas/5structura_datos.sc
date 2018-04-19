package DiaUno.SparkScala

object structura_datos {

  
  // tuplas o listas ordenadas de datos son comunmente utilizados en spark
  // lsitas inmutables
  // A menudo se los considera campos de bases de datos o columnas.
  // util para pasar filas enteras de datos.
  
  val stand = ("producto", "modelo", "serie")
                                                  
  println(stand)
  
  // haciendo referencia a campos individuales
  println(stand._1)
  println(stand._2)
  println(stand._3)
 // s epuede crear una llave vaalor con ->
 val picardsShip = "Producto" -> "Modelo"
 println(picardsShip._2)
 
 // puedes tener varios tipos de valores en la tupla
 val aBunchOfStuff = ("Kirk", 1964, true)
 
 
 
 // Lists
 // Como una tupla, pero es un objeto de colección real que tiene más funcionalidad.
 // no puede tener valores de diferente tipo

 val mylista = List("usuario", "nombre", "apellidos", "direccion")
                                                 
 
 // puedes accesar a la lsita de la siguiente manera,que valor se espera?
 println(mylista(1))
 
 // el uso de head y tail, el head te muestra el primer valor y tail delsegundo en adelante
 println(mylista.head)
 println(mylista.tail)
 
 
 // Iterating though a list
 for (datos <- mylista) {
 	println(datos)
 	}
 
 // se aplica una funcion  map()
val backwardShips = mylista.map( (ship: String) => {ship.reverse})
                                                  
 for (ship <- backwardShips) {println(ship)}
                                                  
                                                  
                                                  
   // reduce() pueden combinar todos los valores de una lista con una funcion
val numberList = List(1, 2, 3, 4, 5)
val sum = numberList.reduce( (x: Int, y: Int) => x + y)
println(sum)

// filter() puedes remover lo que no quieras que este.

val iHateFives = numberList.filter( (x: Int) => x != 5)
val iHateThrees = numberList.filter(_ != 3)

// concatenando listas
val moreNumbers = List(6, 7, 8)
val lotsOfNumbers = numberList ++ moreNumbers

// Mas listas
val reversed = numberList.reverse
val sorted = reversed.sorted
val lotsOfDuplicates = numberList ++ numberList
val distinctValues = lotsOfDuplicates.distinct
val maxValue = numberList.max
val total = numberList.sum
val hasThree = iHateThrees.contains(3)

// Maps
//Útil para búsquedas de clave / valor en claves distintas

val shipMap = Map("Kirk" -> "Enterprise", "Picard" -> "Enterprise-D", "Sisko" -> "Deep Space Nine", "Janeway" -> "Voyager")
println(shipMap("Janeway"))
 
//Tratar con claves faltantes
println(shipMap.contains("Archer"))

val archersShip = util.Try(shipMap("Archer")) getOrElse "No existe"
println(archersShip)

}