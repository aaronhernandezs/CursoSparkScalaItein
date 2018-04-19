package DiaUno.SparkScala

object funciones {
  //el formato de las funciones es de la siguientes manera
  /*
  * def <nombrefuncion> (nombreParametro : Tipo ) : TipodeRetorno = {expresion}
  */
  //ejemplo de una funcion
  def squareIt(x: Int) : Int = {
  	x * x
  }
  
  def cubeIt(x: Int): Int = {x * x * x}
  
  println(squareIt(2))
  
  println(cubeIt(2))
  
  // funciones que pueden tomar otras funciones como parametro
  
  def transformInt(x: Int, f: Int => Int) : Int = {
  	f(x)
  }
  
  val result = transformInt(2, cubeIt)
  println (result)
  
  // funciones literales, funciones anonimas o funciones lambda
  // Puedes declarar funciones en línea sin siquiera darles un nombre
  //
	//Esto sucede mucho en Spark
  transformInt(3, x => x * x * x)
  
  transformInt(10, x => x / 2)
  
  transformInt(2, x => {val y = x * 2; y * y})
  
  // This is really important!
  
  
  // usa el metodo .toUpperCase para covertir un string en mayusculas como por ejemplo spark   SPARK
  // es cribe una funcion que convierta un string a mayusculas
  val foo:String = "Hola"
  foo.toUpperCase()

  
  val entrada = sc.parallelize(List(1, 2, 3, 4))
	val resultado = entrada.map(x => x * x)
println(resultado.collect().mkString(“,”))
}