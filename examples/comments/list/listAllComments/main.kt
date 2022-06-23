
package examples.comments.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.comments

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CommentsListRequest()
  
  try {
      val response = CommentsService.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
