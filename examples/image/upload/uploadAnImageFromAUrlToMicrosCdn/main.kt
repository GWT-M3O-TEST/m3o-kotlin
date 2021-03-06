
package examples.image.upload

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.image

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ImageUploadRequest(Url = "somewebsite.com/cat.png",
Name = "cat.jpeg",)
  
  try {
      val response = ImageServ.upload(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
