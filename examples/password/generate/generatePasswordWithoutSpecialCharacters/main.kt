
package examples.password.generate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.password

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PasswordGenerateRequest(Special = false,
Uppercase = true,
Length = 16,
Lowercase = true,
Numbers = true,)
  
  try {
      val response = PasswordServ.generate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
