
package examples.event.publish

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.event

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EventPublishRequest(Message: &event.Json{
},
Topic = "user",)
  
  try {
      val response = EventService.publish(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
