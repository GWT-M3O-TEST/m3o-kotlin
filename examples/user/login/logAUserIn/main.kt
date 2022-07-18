
package examples.user.login

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserLoginRequest(Password = "Password1",
Email = "joe@example.com",)
  
  try {
      val response = UserServ.login(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
