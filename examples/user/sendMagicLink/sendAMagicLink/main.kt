
package examples.user.sendMagicLink

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserSendMagicLinkRequest(Email = "joe@example.com",
Subject = "MagicLink to access your account",
Address = "www.example.com",
Endpoint = "verifytoken",)
  
  try {
      val response = UserService.sendMagicLink(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
