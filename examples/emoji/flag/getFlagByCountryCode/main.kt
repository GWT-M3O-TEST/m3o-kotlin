
package examples.emoji.flag

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.emoji

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EmojiFlagRequest(Code = "GB",)
  
  try {
      val response = EmojiServ.flag(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
