package paquete

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.sql._
import org.apache.log4j._
import org.apache.spark.sql.{DataFrame, SQLContext, Row}
import org.apache.spark.sql.catalyst.expressions.aggregate._
import org.apache.spark.sql.expressions._
import org.apache.spark.sql.functions._

object mariadb {
  val sc = new SparkContext("local[*]", "localhost")   
  val sqlContext = new SQLContext(sc)
  import sqlContext.implicits._
}