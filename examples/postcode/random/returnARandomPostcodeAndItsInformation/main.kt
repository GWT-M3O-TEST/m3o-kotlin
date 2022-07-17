
package examples.postcode.random

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.postcode

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PostcodeRandomRequest()
  
  try {
      val response = PostcodeServ.random(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
