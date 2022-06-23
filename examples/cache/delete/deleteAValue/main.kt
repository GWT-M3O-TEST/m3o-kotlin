
package examples.cache.delete

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.cache

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CacheDeleteRequest(Key = "foo",)
  
  try {
      val response = CacheService.delete(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
