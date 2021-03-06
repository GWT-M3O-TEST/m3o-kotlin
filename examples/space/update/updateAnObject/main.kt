
package examples.space.update

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.space

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SpaceUpdateRequest(Name = "images/file.jpg",
Visibility = "public",
Obj = "<file bytes>",)
  
  try {
      val response = SpaceServ.update(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
