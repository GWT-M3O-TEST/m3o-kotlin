
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
internal data class WeatherForecast({/// the average temp in fahrenheit
double? avg_temp_f, /// chance of rain (percentage)
int? chance_of_rain, /// date of the forecast
String? date, /// minimum temp in celsius
double? min_temp_c, /// time of sunset
String? sunset, /// will it rain
bool? will_it_rain, /// the average temp in celsius
double? avg_temp_c, /// max temp in fahrenheit
double? max_temp_f, /// max wind speed kph
double? max_wind_kph, /// max wind speed mph
double? max_wind_mph, /// forecast condition
String? condition, /// the URL of forecast condition icon. Simply prefix with either http or https to use it
String? icon_url, /// max temp in celsius
double? max_temp_c, /// time of sunrise
String? sunrise, /// minimum temp in fahrenheit
double? min_temp_f,})
@Serializable
internal data class WeatherForecastRequest({/// number of days. default 1, max 10
int? days, /// location of the forecase
String? location,})
@Serializable
data class WeatherForecastResponse({/// location of the request
String? location, /// e.g -77.46
double? longitude, /// region related to the location
String? region, /// timezone of the location
String? timezone, /// country of the request
String? country, /// forecast for the next number of days
List<Forecast>? forecast, /// e.g 37.55
double? latitude, /// the local time
String? local_time,})
@Serializable
internal data class WeatherNowRequest({/// location to get weather e.g postcode, city
String? location,})
@Serializable
data class WeatherNowResponse({/// whether its daytime
bool? daytime, /// feels like in fahrenheit
double? feels_like_f, /// the local time
String? local_time, /// e.g -77.46
double? longitude, /// region related to the location
String? region, /// cloud cover percentage
int? cloud, /// the weather condition
String? condition, /// e.g 37.55
double? latitude, /// timezone of the location
String? timezone, /// feels like in celsius
double? feels_like_c, /// location of the request
String? location, /// wind degree
int? wind_degree, /// wind in mph
double? wind_mph, /// country of the request
String? country, /// the humidity percentage
int? humidity, /// the URL of the related icon. Simply prefix with either http or https to use it
String? icon_url, /// temperature in celsius
double? temp_c, /// temperature in fahrenheit
double? temp_f, /// wind direction
String? wind_direction, /// wind in kph
double? wind_kph,})
