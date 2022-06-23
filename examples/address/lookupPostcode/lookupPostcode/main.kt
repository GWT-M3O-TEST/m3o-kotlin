
package examples.address.lookupPostcode

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.address

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = AddressLookupPostcodeRequest(Postcode = "SW1A 2AA",)
  
  try {
      val response = AddressService.lookupPostcode(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
