
package examples.stream.createChannel

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.stream
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = StreamcreateChannelRequest(name = "Jone")
  
  try {
      val response = StreamService.createChannel(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}