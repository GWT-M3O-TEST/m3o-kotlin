
package examples.cache.listKeys

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.cache

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CacheListKeysRequest(name = "Jone")
  
  try {
      val response = CacheService.listKeys(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
