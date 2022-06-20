
package examples.memegen.templates

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.memegen

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = MemegenTemplatesRequest(name = "Jone")
  
  try {
      val response = MemegenService.templates(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
