
package examples.stream.listChannels

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.stream

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = StreamListChannelsRequest(name = "Jone")
  
  try {
      val response = StreamService.listChannels(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
