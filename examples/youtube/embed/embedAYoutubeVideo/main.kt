
package examples.youtube.embed

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.youtube

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = YoutubeEmbedRequest(Url = "https://www.youtube.com/watch?v=GWRWZu7XsJ0",)
  
  try {
      val response = YoutubeServ.embed(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
