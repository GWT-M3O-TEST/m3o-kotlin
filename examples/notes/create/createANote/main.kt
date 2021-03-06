
package examples.notes.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.notes

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NotesCreateRequest(Text = "This is my note",
Title = "New Note",)
  
  try {
      val response = NotesServ.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
