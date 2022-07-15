
package examples.cache.increment

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.cache

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CacheIncrementRequest(Value = 2,
Key = "counter",)
  
  try {
      val response = CacheService.increment(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
