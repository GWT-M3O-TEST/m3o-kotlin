
package examples.rss.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.rss

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = RssListRequest()
  
  try {
      val response = RssService.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
