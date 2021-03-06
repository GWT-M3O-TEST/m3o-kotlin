
package examples.stream.listChannels

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.stream

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = StreamListChannelsRequest()
  
  try {
      val response = StreamServ.listChannels(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
