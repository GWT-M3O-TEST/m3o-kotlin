
package examples.notes.events

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.notes
fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = val req = NotesEventsRequest(Id = "63c0cdf8-2121-11ec-a881-0242e36f037a",)
  
  try {
      val socket = NotesServ.events(req) { socketError, response ->
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
