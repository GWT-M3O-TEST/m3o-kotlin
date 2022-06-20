
package examples.translate.text

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.translate
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = TranslatetextRequest(name = "Jone")
  
  try {
      val response = TranslateService.text(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
