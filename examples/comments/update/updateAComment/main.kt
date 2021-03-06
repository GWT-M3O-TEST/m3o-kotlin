
package examples.comments.update

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.comments

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CommentsUpdateRequest(Comment: &comments.Comment{
Id = "63c0cdf8-2121-11ec-a881-0242e36f037a",
Subject = "Update Comment",
Text = "Updated comment text",
},)
  
  try {
      val response = CommentsServ.update(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
