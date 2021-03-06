
package examples.cache.listKeys

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.cache

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CacheListKeysRequest()
  
  try {
      val response = CacheServ.listKeys(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
