
package examples.quran.verses

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.quran

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = QuranVersesRequest(name = "Jone")
  
  try {
      val response = QuranService.verses(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
