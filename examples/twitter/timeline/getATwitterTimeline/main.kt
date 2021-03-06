
package examples.twitter.timeline

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.twitter

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = TwitterTimelineRequest(Username = "m3oservices",
Limit = 1,)
  
  try {
      val response = TwitterServ.timeline(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
