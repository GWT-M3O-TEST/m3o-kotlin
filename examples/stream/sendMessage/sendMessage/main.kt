
package examples.stream.sendMessage

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.stream

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = StreamSendMessageRequest(Channel = "general",
Text = "Hey checkout this tweet https://twitter.com/m3oservices/status/1455291054295498752",)
  
  try {
      val response = StreamService.sendMessage(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
