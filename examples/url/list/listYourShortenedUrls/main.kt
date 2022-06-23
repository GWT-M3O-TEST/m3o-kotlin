
package examples.url.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.url

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UrlListRequest()
  
  try {
      val response = UrlService.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
