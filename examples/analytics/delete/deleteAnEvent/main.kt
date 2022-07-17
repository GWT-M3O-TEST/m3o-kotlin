
package examples.analytics.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.analytics

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = AnalyticsDeleteRequest(Name = "click",)
  
  try {
      val response = AnalyticsServ.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
