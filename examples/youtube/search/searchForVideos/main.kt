
package examples.youtube.search

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.youtube
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = YoutubesearchRequest(name = "Jone")
  
  try {
      val response = YoutubeService.search(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
