
package examples.chat.kick

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.chat

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ChatKickRequest(name = "Jone")
  
  try {
      val response = ChatService.kick(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
