
package examples.space.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.space

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SpaceListRequest(Prefix = "images/",)
  
  try {
      val response = SpaceServ.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
