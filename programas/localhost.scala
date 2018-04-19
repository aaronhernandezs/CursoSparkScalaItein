package paquete

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import org.apache.spark.sql._
import org.apache.spark.sql.SQLContext

object localhost {
    def main(args: Array[String]) {
 
       // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
      
 	val sc = new SparkContext("local[*]", "localhost")   
	val sqlContext = new org.apache.spark.sql.SQLContext(sc)

	val dataframe_mysql = sqlContext.read.format("jdbc").option("url", "jdbc:mysql://192.168.1.76/bd_practicas").option("driver", "com.mysql.jdbc.Driver").option("dbtable", "usuarios").option("user", "aaron").option("password", "aaron").load()
val sql = sqlContext.read.format("jdbc").option("url", "jdbc:mysql://192.168.1.76/bd_practicas").option("driver", "com.mysql.jdbc.Driver").option("dbtable", "usuarios").option("user", "aaron").option("password", "aaron").load()

  dataframe_mysql.show()
  dataframe_mysql.registerTempTable("usuarios")
  val edadOrdenado = sqlContext.sql("select * from usuarios order by edad")
  edadOrdenado.printSchema()
  edadOrdenado.show()
  sqlContext.sql("create table carga ( nombre string, edad Int)")
  def
createTableOptions.(CREATE TABLE t (name: string) ENGINE=InnoDB.))

  
  }
}