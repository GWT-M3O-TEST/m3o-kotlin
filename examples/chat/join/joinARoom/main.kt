
package examples.chat.join

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.chat
fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = val req = ChatJoinRequest(RoomId = "d8057208-f81a-4e14-ad7f-c29daa2bb910",
UserId = "user-2",)
  
  try {
      val socket = ChatService.join(req) { socketError, response ->
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
