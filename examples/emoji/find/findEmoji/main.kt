
package examples.emoji.find

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.emoji
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EmojifindRequest(name = "Jone")
  
  try {
      val response = EmojiService.find(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
