import com.google.gson.GsonBuilder
import org.apache.spark.SparkConf
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import Utilities.{setupTwitter}


object CollectData {
  private var numTweetsCollected = 0L
  private var partNum = 0
  private val gson = new GsonBuilder().create()

  def main(args: Array[String]) {

    // Configure Twitter credentials using twitter.txt
    setupTwitter()
    val sparkConf = new SparkConf().setAppName("PrintTweets")

    // check Spark configuration for master URL, set it to local if not configured
    if (!sparkConf.contains("spark.master")) {
      sparkConf.setMaster("local[2]")
    }

    val ssc = new StreamingContext(sparkConf, Seconds(10))

    val tweetStream = TwitterUtils.createStream(ssc, None)
      .map(gson.toJson(_))

    tweetStream.foreachRDD((rdd, time) => {
      val count = rdd.count()
      if (count > 0) {
        val outputRDD = rdd.repartition(1)
        outputRDD.saveAsTextFile("data/tweets-" + time.milliseconds.toString)
        numTweetsCollected += count
        if (numTweetsCollected > 100000) {
          System.exit(0)
        }
      }
    })

    ssc.start()
    ssc.awaitTermination()
  }
}

