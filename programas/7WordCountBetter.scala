package paquete

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

/** Count up how many of each word occurs in a book, using regular expressions. */
object MejorContador {
 
  /**se declaramos main en donde escribiremos todas las acciones*/
  def main(args: Array[String]) {
   
   
    Logger.getLogger("org").setLevel(Level.ERROR)
    
     
    val sc = new SparkContext("local[*]", "WordCountBetter")   
    
 
    val input = sc.textFile("../book.txt")
    
    // usamos una expresion para extaer las palabras
    val words = input.flatMap(x => x.split("\\W+"))
    
    // se normaliza a minusculas
    val lowercaseWords = words.map(x => x.toLowerCase())
    
    // se cuenta el numero de repeticiones por palaras
    val wordCounts = lowercaseWords.countByValue()
    
    // se imprimen resultados
    wordCounts.foreach(println)
  }
  
}

