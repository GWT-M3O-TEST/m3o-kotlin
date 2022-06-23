
package examples.contact.read

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.contact

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ContactReadRequest(Id = "42e48a3c-6221-11ec-96d2-acde48001122",)
  
  try {
      val response = ContactService.read(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
