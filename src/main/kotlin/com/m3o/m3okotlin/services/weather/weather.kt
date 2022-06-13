
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
internal data class WeatherForecast(val sunset: String, val chance_of_rain: Int, val condition: String, val max_wind_mph: Double, val min_temp_c: Double, val min_temp_f: Double, val avg_temp_c: Double, val avg_temp_f: Double, val date: String, val max_temp_f: Double, val sunrise: String, val will_it_rain: Boolean, val icon_url: String, val max_temp_c: Double, val max_wind_kph: Double)
@Serializable
internal data class WeatherForecastRequest(val days: Int, val location: String)
@Serializable
data class WeatherForecastResponse(val timezone: String, val country: String, val forecast: List<WeatherForecast>, val latitude: Double, val local_time: String, val location: String, val longitude: Double, val region: String)
@Serializable
internal data class WeatherNowRequest(val location: String)
@Serializable
data class WeatherNowResponse(val daytime: Boolean, val icon_url: String, val local_time: String, val region: String, val cloud: Int, val condition: String, val humidity: Int, val location: String, val temp_f: Double, val wind_degree: Int, val wind_kph: Double, val feels_like_f: Double, val latitude: Double, val temp_c: Double, val timezone: String, val wind_mph: Double, val country: String, val feels_like_c: Double, val longitude: Double, val wind_direction: String)
