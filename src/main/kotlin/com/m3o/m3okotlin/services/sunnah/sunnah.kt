
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "sunnah"

object SunnahService {
    suspend fun books(name: String): SunnahBooksResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Books")) {
          body = SunnahBooksRequest(name)
        }
    }
    suspend fun chapters(name: String): SunnahChaptersResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Chapters")) {
          body = SunnahChaptersRequest(name)
        }
    }
    suspend fun collections(name: String): SunnahCollectionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Collections")) {
          body = SunnahCollectionsRequest(name)
        }
    }
    suspend fun hadiths(name: String): SunnahHadithsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Hadiths")) {
          body = SunnahHadithsRequest(name)
        }
    }
}
@Serializable
internal data class SunnahBook({/// arabic name of the book
String? arabic_name, /// number of hadiths in the book
int? hadiths, /// number of the book e.g 1
int? id, /// name of the book
String? name,})
@Serializable
internal data class SunnahBooksRequest({/// Name of the collection
String? collection, /// Limit the number of books returned
int? limit, /// The page in the pagination
int? page,})
@Serializable
data class SunnahBooksResponse({/// The limit specified
int? limit, /// The page requested
int? page, /// The total overall books
int? total, /// A list of books
List<Book>? books, /// Name of the collection
String? collection,})
@Serializable
internal data class SunnahChapter({/// the chapter key e.g 1.00
String? key, /// title of the chapter
String? title, /// arabic title
String? arabic_title, /// the book number
int? book, /// the chapter id e.g 1
int? id,})
@Serializable
internal data class SunnahChaptersRequest({/// Limit the number of chapters returned
int? limit, /// The page in the pagination
int? page, /// number of the book
int? book, /// name of the collection
String? collection,})
@Serializable
data class SunnahChaptersResponse({/// number of the book
int? book, /// The chapters of the book
List<Chapter>? chapters, /// name of the collection
String? collection, /// Limit the number of chapters returned
int? limit, /// The page in the pagination
int? page, /// Total chapters in the book
int? total,})
@Serializable
internal data class SunnahCollection({/// Arabic title if available
String? arabic_title, /// Total hadiths in the collection
int? hadiths, /// Name of the collection e.g bukhari
String? name, /// An introduction explaining the collection
String? summary, /// Title of the collection e.g Sahih al-Bukhari
String? title,})
@Serializable
internal data class SunnahCollectionsRequest({/// Number of collections to limit to
int? limit, /// The page in the pagination
int? page,})
@Serializable
data class SunnahCollectionsResponse({List<Collection>? collections,})
@Serializable
internal data class SunnahHadith({/// the arabic chapter title
String? arabic_chapter_title, /// the arabic text
String? arabic_text, /// the chapter id
int? chapter, /// the chapter key
String? chapter_key, /// the chapter title
String? chapter_title, /// hadith id
int? id, /// hadith text
String? text,})
@Serializable
internal data class SunnahHadithsRequest({/// number of the book
int? book, /// name of the collection
String? collection, /// Limit the number of hadiths
int? limit, /// The page in the pagination
int? page,})
@Serializable
data class SunnahHadithsResponse({/// number of the book
int? book, /// name of the collection
String? collection, /// The hadiths of the book
List<Hadith>? hadiths, /// Limit the number of hadiths returned
int? limit, /// The page in the pagination
int? page, /// Total hadiths in the  book
int? total,})
