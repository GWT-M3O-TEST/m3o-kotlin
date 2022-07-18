
package examples.chat.leave

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.chat

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ChatLeaveRequest(RoomId = "d8057208-f81a-4e14-ad7f-c29daa2bb910",
UserId = "user-1",)
  
  try {
      val response = ChatServ.leave(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
