
package examples.function.regions

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.function

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = FunctionRegionsRequest()
  
  try {
      val response = FunctionServ.regions(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
