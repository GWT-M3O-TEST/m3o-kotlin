
package com.m3o.m3okotlin.services.weather

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "weather"

object WeatherServ {
      suspend fun forecast(req: WeatherForecastRequest): WeatherForecastResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Forecast")) {
          body = req
        }
      }
      suspend fun now(req: WeatherNowRequest): WeatherNowResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Now")) {
          body = req
        }
      }
}
@Serializable
data class WeatherForecast(val min_temp_f: Double? = null, val condition: String? = null, val max_temp_f: Double? = null, val min_temp_c: Double? = null, val sunset: String? = null, val max_temp_c: Double? = null, val max_wind_kph: Double? = null, val max_wind_mph: Double? = null, val icon_url: String? = null, val avg_temp_f: Double? = null, val chance_of_rain: Int? = null, val date: String? = null, val avg_temp_c: Double? = null, val sunrise: String? = null, val will_it_rain: Boolean? = null)
@Serializable
data class WeatherForecastRequest(val days: Int? = null, val location: String? = null)
@Serializable
data class WeatherForecastResponse(val longitude: Double? = null, val region: String? = null, val timezone: String? = null, val country: String? = null, val forecast: List<WeatherForecast>? = null, val latitude: Double? = null, val local_time: String? = null, val location: String? = null)
@Serializable
data class WeatherNowRequest(val location: String? = null)
@Serializable
data class WeatherNowResponse(val daytime: Boolean? = null, val latitude: Double? = null, val longitude: Double? = null, val timezone: String? = null, val wind_direction: String? = null, val wind_mph: Double? = null, val feels_like_f: Double? = null, val local_time: String? = null, val region: String? = null, val temp_c: Double? = null, val temp_f: Double? = null, val wind_kph: Double? = null, val feels_like_c: Double? = null, val icon_url: String? = null, val wind_degree: Int? = null, val cloud: Int? = null, val condition: String? = null, val country: String? = null, val humidity: Int? = null, val location: String? = null)
