
package examples.chat.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.chat

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ChatListRequest(name = "Jone")
  
  try {
      val response = ChatService.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
