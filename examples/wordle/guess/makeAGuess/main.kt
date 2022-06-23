
package examples.wordle.guess

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.wordle

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = WordleGuessRequest(Word = "noise",)
  
  try {
      val response = WordleService.guess(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
