
package examples.lists.events

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.lists
fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = val req = ListsEventsRequest(messages = 2, name = "John")
  
  try {
      val socket = ListsService.events(req) { socketError, response ->
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
