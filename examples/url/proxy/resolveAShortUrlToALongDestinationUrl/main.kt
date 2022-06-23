
package examples.url.proxy

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.url

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UrlProxyRequest(ShortUrl = "https://m3o.one/u/ck6SGVkYp",)
  
  try {
      val response = UrlService.proxy(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
