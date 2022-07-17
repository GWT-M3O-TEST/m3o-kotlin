
package examples.time.zone

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.time

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = TimeZoneRequest(Location = "London",)
  
  try {
      val response = TimeServ.zone(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
