package paquete


import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

object book {
  def main(args: Array[String]) {
    val sc = new SparkContext("local[*]", "book")   
    val file = sc.textFile("../book.txt")
    val blankLines = sc.accumulator(0) // Create an Accumulator[Int] initialized to 0
    val callSigns = file.flatMap(line => {
    if (line == "") {
        blankLines += 1 // Add to the accumulator
        println(blankLines)
    }
    line.split("")
    })
    //callSigns.saveAsTextFile("output.txt")
    println("Blank lines: " + blankLines.value)
  }
}