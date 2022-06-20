
package examples.url.shorten

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.url
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UrlshortenRequest(name = "Jone")
  
  try {
      val response = UrlService.shorten(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
