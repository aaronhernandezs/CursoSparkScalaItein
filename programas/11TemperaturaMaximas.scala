package paquete

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import scala.math.max

/**programa para encontrar temperaturas minimas por estacion**/
object TemperaturaMax {
  
  def parseLine(line:String)= {
    val TIPSalto = line.split(",")
    val IDestacion = TIPSalto(0)
    val TIPentra = TIPSalto(2)
    val temperatura = TIPSalto(3).toFloat * 0.1f * (9.0f / 5.0f) + 32.0f
    (IDestacion, TIPentra, temperatura)
  }
  
  def celsius (temp : Double)  = {
   ( temp -32) / 1.800
  }
    /** creacion de funcion para procesar */
  def main(args: Array[String]) {
   
    // configuramos nuetro log para que solo nos muestre los errores
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    // Create a SparkContext using every core of the local machine
    val sc = new SparkContext("local[*]", "TemperaturasMax")
    
       // se lee cada  linea de nuestro archivo csv
    val lines = sc.textFile("../1800.csv")
    
    // convertimos  (IDestacion, TIPentra, temperatura) a tuplas
    val parsedLines = lines.map(parseLine)
    
    val maxTemps = parsedLines.filter(x => x._2 == "TMAX")
    
    val stationTemps = maxTemps.map(x => (x._1, x._3.toFloat))
    val maxTempsByStation = stationTemps.reduceByKey( (x,y) => max(x,y))
    val results = maxTempsByStation.collect()
    
    for (result <- results.sorted) {
       val estation = result._1
       val temp = result._2
       val formatTemp = f"$temp%.2f F"
       val cel = celsius(temp)
       println(f"la estacion con ID $estation tiene una temperatura maxima: $formatTemp , en grados celsius: $cel%.2f C")
    
    }
      
  }
}