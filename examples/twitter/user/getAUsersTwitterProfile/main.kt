
package examples.twitter.user

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.twitter

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = TwitterUserRequest(Username = "crufter",)
  
  try {
      val response = TwitterServ.user(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
