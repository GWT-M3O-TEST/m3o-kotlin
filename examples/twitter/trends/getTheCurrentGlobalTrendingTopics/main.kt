
package examples.twitter.trends

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.twitter

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = TwitterTrendsRequest()
  
  try {
      val response = TwitterServ.trends(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
