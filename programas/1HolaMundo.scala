
//practica uno Hola Mundo 
/*curso introduccion a apache spark con scala 
 * 
 * 
 * */
package DiaUno.SparkScala                              //se hace referencia al paquete al cual pertence nuestro programa

object HolaMundo {                                     //se declara la palabra reservada object con su nombre en este caso HolaMundo
  def main(args: Array[String]) {                      //se define la clase main
    val bienvenida: String = "hola mundo"              // es declarada una variable bienvenida con el valor hola mundo
    println(bienvenida)                                //se imprime la variable bienvenida
  }                                                    // se cierra main
}                                                      //se cierra nuestro objeto HolaMundo