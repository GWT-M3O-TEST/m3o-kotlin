
package examples.helloworld.call

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.helloworld
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = HelloworldcallRequest(name = "Jone")
  
  try {
      val response = HelloworldService.call(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
