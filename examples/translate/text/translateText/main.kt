
package examples.translate.text

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.translate

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = TranslateTextRequest(Content = "hello",
Model = "nmt",
Format = "text",
Source = "en",
Target = "fr",)
  
  try {
      val response = TranslateServ.text(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
