
package examples.space.head

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.space

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SpaceHeadRequest(Name = "images/file.jpg",)
  
  try {
      val response = SpaceServ.head(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
