
package examples.user.read

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserReadRequest(Username = "joe",)
  
  try {
      val response = UserServ.read(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
