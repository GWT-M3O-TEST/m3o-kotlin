
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "weather"

object WeatherService {
    suspend fun forecast(name: String): WeatherForecastResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Forecast")) {
          body = WeatherForecastRequest(name)
        }
    }
    suspend fun now(name: String): WeatherNowResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Now")) {
          body = WeatherNowRequest(name)
        }
    }
}
@Serializable
internal data class WeatherForecast()
@Serializable
internal data class WeatherForecastRequest()
@Serializable
data class WeatherForecastResponse()
@Serializable
internal data class WeatherNowRequest()
@Serializable
data class WeatherNowResponse()
