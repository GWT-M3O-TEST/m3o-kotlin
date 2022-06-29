
package examples.url.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.url

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UrlDeleteRequest(ShortUrl = "https://m3o.one/u/f8f3f83f3f83g",)
  
  try {
      val response = UrlService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
