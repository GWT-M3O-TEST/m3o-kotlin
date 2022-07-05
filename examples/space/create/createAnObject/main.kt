
package examples.space.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.space

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SpaceCreateRequest(Name = "images/file.jpg",
Visibility = "public",
Object = "<file bytes>",)
  
  try {
      val response = SpaceService.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
