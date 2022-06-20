
package examples.mq.publish

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.mq
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = MqpublishRequest(name = "Jone")
  
  try {
      val response = MqService.publish(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
