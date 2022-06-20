
package examples.comments.events

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.comments
fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = val req = CommentseventsRequest(messages = 2, name = "John")
  
  try {
      val socket = CommentsService.events(req) { socketError, response ->
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
