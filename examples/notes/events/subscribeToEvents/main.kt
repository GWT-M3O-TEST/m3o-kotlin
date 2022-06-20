
package examples.notes.events

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.notes
fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = val req = NotesEventsRequest(messages = 2, name = "John")
  
  try {
      val socket = NotesService.events(req) { socketError, response ->
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
