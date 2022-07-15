
package examples.file.save

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.file

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = FileSaveRequest(File: &file.Record{
Project = "examples",
Content = "file content example",
Path = "/document/text-files/file.txt",
},)
  
  try {
      val response = FileService.save(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
