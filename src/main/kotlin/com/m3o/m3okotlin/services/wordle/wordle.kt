
package com.m3o.m3okotlin.services

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
    suspend fun next(req: WordleNextRequest): WordleNextResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Next")) {
          body = req
        }
    }
}
@Serializable
internal data class WordleChar(val correct: Boolean, val in_word: Boolean, val letter: String, val position: Int)
@Serializable
internal data class WordleGuess(val chars: List<WordleChar>, val highlight: String, val word: String)
@Serializable
internal data class WordleGuessRequest(val player: String, val word: String)
@Serializable
data class WordleGuessResponse(val guesses: List<WordleGuess>, val status: String, val tries_left: Int, val answer: String, val correct: Boolean)
@Serializable
internal data class WordleNextRequest()
@Serializable
data class WordleNextResponse(val duration: String, val seconds: Int)
