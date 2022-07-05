
package com.m3o.m3okotlin.services.wordle

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "wordle"

object WordleService {
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
data class WordleChar(val in_word: Boolean, val letter: String, val position: Int, val correct: Boolean)
@Serializable
data class WordleGuess(val word: String, val chars: List<WordleChar>, val highlight: String)
@Serializable
data class WordleGuessRequest(val player: String, val word: String)
@Serializable
data class WordleGuessResponse(val answer: String, val correct: Boolean, val guesses: List<WordleGuess>, val status: String, val tries_left: Int)
@Serializable
data class WordleNextResponse(val seconds: Int, val duration: String)
