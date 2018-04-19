package paquete

object TiposVariables {


/*exiten dos tipos de asignacion de variables
*var y val
*el uso de val se asigna su valor y ya no es posible cambiarla,
* a esto se le llama variables inmutables o mejor conocido como variables constantes*/

    val var_inmutable: String = "Hola! "
  println(var_inmutable)
  
/*el uso de var se asigna su valor a partir de otra varaible, en este caso el valor de la variable puede cambiar*/
  var welcome: String = var_inmutable
  welcome = var_inmutable + " bienvenido a scala"
  println(welcome)  //output Hola!  bienvenido a scala
  
  
  
  // Tipos de datos:
  val numberOne : Int = 1													//valores enteros solo se adminten numeros
  val truth : Boolean = true											//valores boleanos solo es aceptado: true o falso
  val letterA : Char = 'a'												//valores caracter solo se acepta  un caracter
  val pi : Double = 3.14159265										//Valores Doble(con punto decimal) almacena 64 bits
  val piSinglePrecision : Float = 3.14159265f			//valores de tipo flotante almacena 32 bits
  val bigNumber : Long = 1234567890l							//valores long almacenas numeros muy grandes
  val smallNumber : Byte = 127										//valores Byte almacena valores pequeños
  

  println("tipos de datos en scala: " +"numeros enteros:"+ numberOne +"valores boleanos"+ truth +"valores caracter"+ letterA + pi + bigNumber)
  
  // estilos de impresion
  println(f"Pi is about $piSinglePrecision%.3f")  //sin importar cuantas decimales tengas, puedes restringuirlo
  println(f"Zero padding on the left: $numberOne%05d") //apareceran 5 ceros a la izquierda
                                                  
  // sustitucion de varaibles
  println(s"I can use the s prefix to use variables like $numberOne $truth $letterA")
  // Substituting expressions (with curly brackets):
  println(s"el uso de prefijos no solo se limita a variables; puedes incluir expresiones, como por ejemplo ${10+9}") //el uso de pre
                                                 
  // Usando expresiones regulares
  val theUltimateAnswer: String = "el 4 año tiene un numero de dias, 365"
  val pattern = """.* ([\D]+).*""".r
  val pattern(answerString) = theUltimateAnswer
  val answer = answerString.toInt
  println(answer)
  
  // Uso de boleanos  > < &
  //= asignar un valor
  //== comparacion
  val isGreater = 1 > 2
  val isLesser = 1 < 2
  val impossible = isGreater & isLesser
  val anotherWay = isGreater && isLesser
  
  val picard: String = "Picard"
  val bestCaptain: String = "Picard"
  val isBest: Boolean = picard == bestCaptain
}