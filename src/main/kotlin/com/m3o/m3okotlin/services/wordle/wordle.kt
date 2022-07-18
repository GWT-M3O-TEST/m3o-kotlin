
package com.m3o.m3okotlin.services.wordle

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "wordle"

object WordleServ {
      suspend fun guess(req: WordleGuessRequest): WordleGuessResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Guess")) {
          body = req
        }
      }
      suspend fun next(): WordleNextResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Next")) 
      }
}
@Serializable
data class WordleChar(val position: Int? = null, val correct: Boolean? = null, val in_word: Boolean? = null, val letter: String? = null)
@Serializable
data class WordleGuess(val chars: List<WordleChar>? = null, val highlight: String? = null, val word: String? = null)
@Serializable
data class WordleGuessRequest(val player: String? = null, val word: String? = null)
@Serializable
data class WordleGuessResponse(val guesses: List<WordleGuess>? = null, val status: String? = null, val tries_left: Int? = null, val answer: String? = null, val correct: Boolean? = null)
@Serializable
data class WordleNextResponse(val duration: String? = null, val seconds: Int? = null)
