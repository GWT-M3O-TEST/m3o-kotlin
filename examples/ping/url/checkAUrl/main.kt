
package examples.ping.url

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.ping
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PingurlRequest(name = "Jone")
  
  try {
      val response = PingService.url(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
