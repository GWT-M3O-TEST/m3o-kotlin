
package examples.quran.chapters

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.quran
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = QuranchaptersRequest(name = "Jone")
  
  try {
      val response = QuranService.chapters(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
