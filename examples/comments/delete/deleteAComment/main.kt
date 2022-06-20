
package examples.comments.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.comments
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CommentsdeleteRequest(name = "Jone")
  
  try {
      val response = CommentsService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
