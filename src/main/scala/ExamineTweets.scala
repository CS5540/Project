import com.google.gson.{GsonBuilder, JsonParser}
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Examine the collected tweets and trains a model based on them.
  */
object ExamineTweets {
  val jsonParser = new JsonParser()
  val gson = new GsonBuilder().setPrettyPrinting().create()

  def main(args: Array[String]) {
    val tweetInput = "data/tweets*/part*"

    val sparkConf = new SparkConf().setAppName("Examine")

    if (!sparkConf.contains("spark.master")) {
      sparkConf.setMaster("local[2]")
    }

    val sc = new SparkContext(sparkConf)

    // Pretty print some of the tweets.
    val tweets = sc.textFile(tweetInput)
    println("------------Sample JSON Tweets-------")
    for (tweet <- tweets) {
      var tw = jsonParser.parse(tweet).getAsJsonObject.getAsJsonArray("hashtagEntities")
      if (tw.size() != 0)
        println(tw)
    }
  }
}