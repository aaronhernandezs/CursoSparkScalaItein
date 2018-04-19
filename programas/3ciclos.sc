package DiaUno.SparkScala

object ciclos {
	// ciclos for
 	
 	for (x <- 1 to 4) { //x tomara el valor del ciclo, empezando por uno y terminando en cuatro
 		val squared = x * x
 		println(squared)
 	}                                        				//salida esperada  1, 4, 9, 16
                                                  
  // ciclos while
  var xx = 10
  while (xx >= 0) {
  	println(xx)
  	xx -=1
  }
                                                  
  var x = 0
  do {
  println("vuelta numero "+ x); x+=1 }
  while (x <= 10)
                                                  
   // Expresiones
   // el uso de expresiones arrojara el resultado final,
   
   {val x = 10; x + 20}
                                                
	 println({val x = 10; x + 20})
	 
	 
	   
}