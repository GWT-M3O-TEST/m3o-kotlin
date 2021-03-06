
package examples.comments.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.comments

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CommentsCreateRequest(Subject = "New Comment",
Text = "This is my comment",)
  
  try {
      val response = CommentsServ.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
