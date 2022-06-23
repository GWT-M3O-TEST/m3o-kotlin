
package examples.answer.question

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.answer

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = AnswerQuestionRequest(Query = "microsoft",)
  
  try {
      val response = AnswerService.question(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
