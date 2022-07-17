
package examples.sunnah.chapters

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.sunnah

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SunnahChaptersRequest(Book = 1,
Collection = "bukhari",)
  
  try {
      val response = SunnahServ.chapters(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
