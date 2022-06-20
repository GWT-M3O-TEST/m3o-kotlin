
package examples.analytics.track

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.analytics

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = AnalyticsTrackRequest(name = "Jone")
  
  try {
      val response = AnalyticsService.track(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
