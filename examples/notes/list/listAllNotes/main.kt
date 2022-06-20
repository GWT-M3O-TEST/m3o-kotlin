
package examples.notes.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.notes

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NotesListRequest(name = "Jone")
  
  try {
      val response = NotesService.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
