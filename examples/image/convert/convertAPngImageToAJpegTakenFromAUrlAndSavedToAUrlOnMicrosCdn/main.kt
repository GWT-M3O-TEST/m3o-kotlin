
package examples.image.convert

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.image

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ImageConvertRequest(OutputUrl = true,
Url = "somewebsite.com/cat.png",
Name = "cat.jpeg",)
  
  try {
      val response = ImageServ.convert(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
