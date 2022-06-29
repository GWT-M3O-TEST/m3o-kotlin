
package examples.chat.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.chat

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ChatCreateRequest(Description = "The general chat room",
Name = "general",)
  
  try {
      val response = ChatService.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
