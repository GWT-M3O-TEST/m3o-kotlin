
package examples.notes.update

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.notes

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NotesUpdateRequest(name = "Jone")
  
  try {
      val response = NotesService.update(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
