
package examples.quran.summary

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.quran

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = QuranSummaryRequest(Chapter = 1,)
  
  try {
      val response = QuranServ.summary(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
