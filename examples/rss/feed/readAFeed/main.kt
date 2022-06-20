
package examples.rss.feed

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.rss
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = RssfeedRequest(name = "Jone")
  
  try {
      val response = RssService.feed(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
