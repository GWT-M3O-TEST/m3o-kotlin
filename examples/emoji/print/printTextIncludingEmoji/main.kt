
package examples.emoji.print

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.emoji

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EmojiPrintRequest(Text = "let's grab a :beer:",)
  
  try {
      val response = EmojiServ.print(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
