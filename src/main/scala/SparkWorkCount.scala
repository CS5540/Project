import org.apache
import org.apache.spark
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Row, SparkSession}

object SparkWordCount extends App {
  val sparkConf = new SparkConf().setAppName("Examine")

  if (!sparkConf.contains("spark.master")) {
    sparkConf.setMaster("local[2]")
  }

  val sc = new SparkContext(sparkConf)

  val text = sc.textFile("output/hashtags.txt")
  val counts = text.flatMap(line => line.split("\n"))
    .map(word => (word, 1))
    .reduceByKey(_+_)
    .sortBy(-_._2)
  counts.saveAsTextFile("output/wordcount")
}