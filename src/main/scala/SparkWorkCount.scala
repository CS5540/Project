import org.apache
import org.apache.spark
import org.apache.spark.sql.{Row, SparkSession}

object SparkWordCount extends App {
  val spark = SparkSession.builder
    .master("local")
    .appName("Spark Graph Frames")
    .getOrCreate()

  val df = spark.read
    .json("data/tweets*/part*")
  // Displays the content of the DataFrame to stdout
  df.show()
  df.groupBy("hashtagEntities").count().show()
}