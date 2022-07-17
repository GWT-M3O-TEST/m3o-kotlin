
package examples.url.shorten

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.url

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UrlShortenRequest(DestinationUrl = "https://mysite.com/this-is-a-rather-long-web-address",)
  
  try {
      val response = UrlServ.shorten(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
