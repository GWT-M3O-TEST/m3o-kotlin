
package examples.event.consume

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.event
fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = val req = EventConsumeRequest(Topic = "user",)
  
  try {
      val socket = EventService.consume(req) { socketError, response ->
          if (socketError == null) {
              println(response)
          } else {
              println(socketError)
          }
      }
  } catch (e: Exception) {
      println(e)
  }
}
