
package examples.avatar.generate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.avatar

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = AvatarGenerateRequest(Gender = "female",
Username = "",
Format = "jpeg",
Upload = false,)
  
  try {
      val response = AvatarServ.generate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
