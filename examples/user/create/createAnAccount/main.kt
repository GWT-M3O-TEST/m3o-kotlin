
package examples.user.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserCreateRequest(Email = "joe@example.com",
Password = "Password1",
Id = "user-1",
Username = "joe",)
  
  try {
      val response = UserService.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
