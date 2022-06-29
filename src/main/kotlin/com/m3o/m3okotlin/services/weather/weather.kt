
package com.m3o.m3okotlin.services.weather

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "weather"

object WeatherService {
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
data class WeatherForecast(val avg_temp_c: Double, val avg_temp_f: Double, val max_wind_mph: Double, val date: String, val max_temp_f: Double, val min_temp_c: Double, val icon_url: String, val max_wind_kph: Double, val min_temp_f: Double, val sunrise: String, val sunset: String, val will_it_rain: Boolean, val chance_of_rain: Int, val condition: String, val max_temp_c: Double)
@Serializable
data class WeatherForecastRequest(val days: Int, val location: String)
@Serializable
data class WeatherForecastResponse(val region: String, val timezone: String, val country: String, val forecast: List<WeatherForecast>, val latitude: Double, val local_time: String, val location: String, val longitude: Double)
@Serializable
data class WeatherNowRequest(val location: String)
@Serializable
data class WeatherNowResponse(val feels_like_c: Double, val location: String, val region: String, val temp_c: Double, val condition: String, val daytime: Boolean, val feels_like_f: Double, val temp_f: Double, val timezone: String, val country: String, val wind_degree: Int, val wind_kph: Double, val wind_mph: Double, val longitude: Double, val humidity: Int, val icon_url: String, val latitude: Double, val local_time: String, val wind_direction: String, val cloud: Int)
