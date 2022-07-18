
package examples.image.resize

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.image

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ImageResizeRequest(Width = 100,
Height = 100,
CropOptions: &image.CropOptions{
Height = 50,
Width = 50,
},
Base64 = "data:image/png;base64, iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAYAAACNbyblAAAAHElEQVQI12P4//8/w38GIAXDIBKE0DHxgljNBAAO9TXL0Y4OHwAAAABJRU5ErkJggg==",)
  
  try {
      val response = ImageServ.resize(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
