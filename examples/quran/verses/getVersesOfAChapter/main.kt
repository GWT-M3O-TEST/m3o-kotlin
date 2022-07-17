
package examples.quran.verses

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.quran

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = QuranVersesRequest(Chapter = 1,)
  
  try {
      val response = QuranServ.verses(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
