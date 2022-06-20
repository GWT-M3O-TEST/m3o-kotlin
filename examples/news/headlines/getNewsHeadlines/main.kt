
package examples.news.headlines

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.news

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NewsHeadlinesRequest(name = "Jone")
  
  try {
      val response = NewsService.headlines(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
