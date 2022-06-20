
package examples.sunnah.books

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.sunnah

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SunnahBooksRequest(name = "Jone")
  
  try {
      val response = SunnahService.books(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
