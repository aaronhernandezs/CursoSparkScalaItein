package DiaUno.SparkScala

object condicionales {

//flujos de control  a apartir de condicionales
//las sentencias usadas para el control de flujos son IF, IF ELSE, do, do while
  
//sentencias if

  if (10 > 100) println("En que planeta vives?, es imposible!") else println("El 100 es mayor al 10 por 10 veces su tamaño")
   
   
   //otra forma de escribir el mismo if de arriba
  if (10 > 100) {
  	println("En que planeta vives?, es imposible!")
  } else {
  	println("El 100 es mayor al 10 por 10 veces su tamaño")
  }
  
  
  //usando Match, en otros lenguajes es conocido como case, dependiendo del valor de una variable, se seleccionara el caso.
  
  
  //
  val number = 2
  number match {
  	case 1 => println("numero uno")
  	case 2 => println("nuemero dos")
  	case 3 => println("numero tres")
  	case _ => println("numero ingresado fuera de los parametros")
 	}
 	//tambien se puede realizar match con valores caracter
 	//selecciona entre noche o dia
 	val carc = "noche"
 	carc match {
 		case "noche" => println("es de noche cuando se oculta el sol")
		case "dia" => println("el sol nos ilumina")

		case _ => println("quizas te equivocaste seleccionando los parametros")
 	}
}