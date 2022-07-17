
package examples.mq.publish

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.mq

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = MqPublishRequest(Topic = "events",
Message: &mq.Json{
},)
  
  try {
      val response = MqServ.publish(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
