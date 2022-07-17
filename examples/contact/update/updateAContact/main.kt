
package examples.contact.update

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.contact

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ContactUpdateRequest(Note = "this person is very important",
Emails: []contact.Email{
contact.Email: {
Label = "work", Address = "work@example.com", },
},
Links: []contact.Link{
contact.Link: {
Label = "blog", Url = "https://blog.joe.me", },
},
Birthday = "1995-01-01",
Addresses: []contact.Address{
contact.Address: {
Label = "company address", Location = "123 street address", },
},
SocialMedias: []contact.SocialMedia{
contact.SocialMedia: {
Username = "joe-facebook", Label = "facebook", },
},
Id = "42e48a3c-6221-11ec-96d2-acde48001122",
Name = "joe",
Phones: []contact.Phone{
contact.Phone: {
Label = "work", Number = "010-87654321", },
},)
  
  try {
      val response = ContactServ.update(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
