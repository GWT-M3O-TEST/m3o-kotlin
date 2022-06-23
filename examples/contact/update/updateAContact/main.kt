
package examples.contact.update

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.contact

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ContactUpdateRequest(Birthday = "1995-01-01",
Addresses: []contact.Address{
contact.Address: {
Label = "company address", Location = "123 street address", },
},
Name = "joe",
Emails: []contact.Email{
contact.Email: {
Address = "work@example.com", Label = "work", },
},
Links: []contact.Link{
contact.Link: {
Label = "blog", Url = "https://blog.joe.me", },
},
SocialMedias: []contact.SocialMedia{
contact.SocialMedia: {
Label = "facebook", Username = "joe-facebook", },
},
Note = "this person is very important",
Id = "42e48a3c-6221-11ec-96d2-acde48001122",
Phones: []contact.Phone{
contact.Phone: {
Label = "work", Number = "010-87654321", },
},)
  
  try {
      val response = ContactService.update(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
