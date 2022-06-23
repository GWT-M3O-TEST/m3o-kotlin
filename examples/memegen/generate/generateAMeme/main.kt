
package examples.memegen.generate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.memegen

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = MemegenGenerateRequest(TopText = "WTF",
BottomText = "Huh?",
Id = "444501",)
  
  try {
      val response = MemegenService.generate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
