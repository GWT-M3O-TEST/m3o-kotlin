
package examples.user.update

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserUpdateRequest(Username = "joe",
Id = "user-1",
Email = "joe+2@example.com",)
  
  try {
      val response = UserServ.update(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
