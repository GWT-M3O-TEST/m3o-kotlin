
package examples.user.updatePassword

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserUpdatePasswordRequest(UserId = "user-1",)
  
  try {
      val response = UserServ.updatePassword(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
