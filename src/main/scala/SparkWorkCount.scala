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

  val hashtag = sc.textFile("output/hashtags.txt")
  val counts1 = hashtag.flatMap(line => line.split("\n"))
    .map(word => (word, 1))
    .reduceByKey(_+_)
    .sortBy(-_._2)
  counts1.saveAsTextFile("output/hashtagscount")

  val text = sc.textFile("output/urls.txt")
  val counts2 = text.flatMap(line => line.split("\n"))
    .map(word => (word, 1))
    .reduceByKey(_+_)
    .sortBy(-_._2)
  counts2.saveAsTextFile("output/urlscount")
}