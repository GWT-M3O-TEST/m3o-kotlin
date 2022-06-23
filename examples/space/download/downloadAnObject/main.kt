
package examples.space.download

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.space

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SpaceDownloadRequest(Name = "images/file.jpg",)
  
  try {
      val response = SpaceService.download(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
