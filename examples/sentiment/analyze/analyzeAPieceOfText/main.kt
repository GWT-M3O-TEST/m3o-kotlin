
package examples.sentiment.analyze

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.sentiment

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SentimentAnalyzeRequest(Text = "this is amazing",)
  
  try {
      val response = SentimentService.analyze(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
