
package examples.dns.query

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.dns

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = DnsQueryRequest(Name = "google.com",)
  
  try {
      val response = DnsServ.query(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
