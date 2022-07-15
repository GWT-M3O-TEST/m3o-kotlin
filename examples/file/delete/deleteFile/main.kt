
package examples.file.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.file

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = FileDeleteRequest(Path = "/document/text-files/file.txt",
Project = "examples",)
  
  try {
      val response = FileService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
