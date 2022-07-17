
package examples.user.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserDeleteRequest(Id = "8b98acbe-0b6a-4d66-a414-5ffbf666786f",)
  
  try {
      val response = UserServ.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
