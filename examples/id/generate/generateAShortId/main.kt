
package examples.id.generate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.id

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = IdGenerateRequest(Type = "shortid",)
  
  try {
      val response = IdServ.generate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
