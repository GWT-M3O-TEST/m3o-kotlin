
package examples.chat.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.chat

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ChatCreateRequest(Name = "general",
Description = "The general chat room",)
  
  try {
      val response = ChatService.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
