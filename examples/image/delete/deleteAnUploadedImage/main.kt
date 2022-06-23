
package examples.image.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.image

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ImageDeleteRequest(Url = "https://cdn.m3ocontent.com/micro/images/micro/41e23b39-48dd-42b6-9738-79a313414bb8/cat.png",)
  
  try {
      val response = ImageService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
