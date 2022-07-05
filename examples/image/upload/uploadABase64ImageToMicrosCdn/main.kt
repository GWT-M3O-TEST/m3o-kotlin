
package examples.image.upload

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.image

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ImageUploadRequest(Name = "cat.jpeg",
Base64 = "data:image/png;base64, iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAx0lEQVR4nOzaMaoDMQyE4ZHj+x82vVdhwQoTkzKQEcwP5r0ihT7sbjUTeAJ4HCegXQJYfOYefOyjDuBiz3yjwJBoCIl6QZOeUjTC1Ix1IxEJXF9+0KWsf2bD4bn37OO/c/wuQ9QyRC1D1DJELUPUMkQtQ9QyRC1D1DJELUPUMkQtQ9QyRC1D1DJELUPUMkQtQ9Sa/NG94Tf3j4WBdaxudMEkn4IM2rZBA0wBrvo7aOcpj2emXvLeVt0IGm0GVXUj91mvAAAA//+V2CZl+4AKXwAAAABJRU5ErkJggg==",)
  
  try {
      val response = ImageService.upload(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
