
package examples.user.resetPassword

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserresetPasswordRequest(name = "Jone")
  
  try {
      val response = UserService.resetPassword(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
