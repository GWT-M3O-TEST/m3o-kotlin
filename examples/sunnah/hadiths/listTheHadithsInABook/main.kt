
package examples.sunnah.hadiths

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.sunnah

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SunnahHadithsRequest(Book = 1,
Collection = "bukhari",)
  
  try {
      val response = SunnahService.hadiths(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
