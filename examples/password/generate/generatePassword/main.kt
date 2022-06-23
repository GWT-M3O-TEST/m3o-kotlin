
package examples.password.generate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.password

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PasswordGenerateRequest(Length = 16,)
  
  try {
      val response = PasswordService.generate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
