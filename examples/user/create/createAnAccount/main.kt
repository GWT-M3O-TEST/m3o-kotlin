
package examples.user.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserCreateRequest(Id = "user-1",
Username = "joe",
Email = "joe@example.com",
Password = "Password1",)
  
  try {
      val response = UserServ.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
