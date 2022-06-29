
package examples.helloworld.stream

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.helloworld
fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = val req = HelloworldStreamRequest(Name = "John",
Messages = 10,)
  
  try {
      val socket = HelloworldService.stream(req) { socketError, response ->
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
