
package examples.rss.add

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.rss

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = RssAddRequest(Category = "news",
Name = "bbc",
Url = "http://feeds.bbci.co.uk/news/rss.xml",)
  
  try {
      val response = RssServ.add(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
