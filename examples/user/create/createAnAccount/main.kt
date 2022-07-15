
package examples.user.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserCreateRequest(Password = "Password1",
Id = "user-1",
Username = "joe",
Email = "joe@example.com",)
  
  try {
      val response = UserService.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
