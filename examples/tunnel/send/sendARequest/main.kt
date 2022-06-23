
package examples.tunnel.send

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.tunnel

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = TunnelSendRequest(Url = "https://google.com",)
  
  try {
      val response = TunnelService.send(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
