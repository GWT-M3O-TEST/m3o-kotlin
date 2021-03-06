
package examples.event.read

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.event

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EventReadRequest(Topic = "user",)
  
  try {
      val response = EventServ.read(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
