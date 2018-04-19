package paquete


import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._

object streaming {
  val sc = new SparkContext("local[*]","stream")
  val ssc = new StreamingContext(sc, Seconds(10))
  

}