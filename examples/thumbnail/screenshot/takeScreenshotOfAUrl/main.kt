
package examples.thumbnail.screenshot

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.thumbnail

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ThumbnailScreenshotRequest(Width = 600,
Height = 600,
Url = "https://google.com",)
  
  try {
      val response = ThumbnailService.screenshot(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
