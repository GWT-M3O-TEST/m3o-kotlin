
package examples.contact.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.contact

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ContactDeleteRequest(name = "Jone")
  
  try {
      val response = ContactService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
