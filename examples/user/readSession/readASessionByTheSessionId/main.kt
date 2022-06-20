
package examples.user.readSession

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserReadSessionRequest(name = "Jone")
  
  try {
      val response = UserService.readSession(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
