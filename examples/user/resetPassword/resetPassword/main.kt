
package examples.user.resetPassword

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserResetPasswordRequest(Code = "012345",
Email = "joe@example.com",)
  
  try {
      val response = UserServ.resetPassword(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
