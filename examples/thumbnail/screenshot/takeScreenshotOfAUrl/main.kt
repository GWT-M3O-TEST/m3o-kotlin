
package examples.thumbnail.screenshot

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.thumbnail

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ThumbnailScreenshotRequest(Height = 600,
Url = "https://google.com",
Width = 600,)
  
  try {
      val response = ThumbnailServ.screenshot(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
