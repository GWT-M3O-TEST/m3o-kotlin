
package examples.postcode.validate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.postcode

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PostcodeValidateRequest(name = "Jone")
  
  try {
      val response = PostcodeService.validate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
