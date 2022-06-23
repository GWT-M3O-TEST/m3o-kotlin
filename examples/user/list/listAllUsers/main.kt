
package examples.user.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserListRequest(Offset = 0,
Limit = 100,)
  
  try {
      val response = UserService.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
