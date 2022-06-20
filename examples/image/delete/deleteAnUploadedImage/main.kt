
package examples.image.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.image
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ImagedeleteRequest(name = "Jone")
  
  try {
      val response = ImageService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
