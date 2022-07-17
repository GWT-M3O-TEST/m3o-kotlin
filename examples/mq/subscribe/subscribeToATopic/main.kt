
package examples.mq.subscribe

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.mq
fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = val req = MqSubscribeRequest(Topic = "events",)
  
  try {
      val socket = MqServ.subscribe(req) { socketError, response ->
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
