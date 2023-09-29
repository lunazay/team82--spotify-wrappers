# week3project
A readme.md file which must include:
- [X] a description of the problem domain your team is tentatively wanting to focus on in the project. (e.g., trivia, finance, real estate, etc…)
- [X] a brief, high-level description of what kind of application your team is thinking of developing.
- [X] a link to the documentation for an API your team can use related to the domain.
- [X] a screenshot of using <a href="https://hoppscotch.io/" target="_blank">a tool to try out the API</a>
- [ ] an example output of running your Java code (see below).
- [X] a list of any technical problems blocking progress (if any)

## Description of Project Domain
Our project's domain is a personalized stats reporter specific to a user's listening activity on Spotify.

### Description of Application
Our project will utilize Spotify's developer API to generate a stats page for a user which compiles and describes their listening activity by displaying frequently listened to artists, songs, and albums and organizing data with categories such as language and genre. Other web apps for Spotify stats exist, but they generally provide an in depth look into one aspect of a user's listening activity. Our application will focus on providing a generalized overview of listening activity in several organizational categories.

## API

Spotify Web API: https://developer.spotify.com/documentation/web-api

### Usage
Postman call to the API:
<img width="1467" alt="Screenshot 2023-09-29 at 3 28 58 PM" src="https://github.com/lunazay/week3design/assets/144556477/bfc4d313-7f74-4338-9078-66523527d16f">

Errors faced when running Java code:
<img width="473" alt="Screenshot 2023-09-29 at 3 34 04 PM" src="https://github.com/lunazay/week3design/assets/144556477/3dfa3d57-7a4e-439e-bbba-78a99138dd72">

```java
/**OkHttpClient client = new OkHttpClient().newBuilder()
  .build();
MediaType mediaType = MediaType.parse("text/plain");
RequestBody body = RequestBody.create(mediaType, "");
Request request = new Request.Builder()
  .url("https://api.spotify.com/v1/browse/new-releases")
  .method("GET", body)
  .addHeader("Authorization", "Bearer BQCVwBhtZtx55QdA1TTis_e3YcA_7W7AGT1i10nK-okb-jlts2Em3p11aQpRTWV83XF9CQHUOcy_-jJ8nEFIVe5vrFll3M9t6kqOQwyh3i6NfVJe9b6-7Q4WuSDFfIUrXiNNrwfDYJjkwR6_irP6S15twTLiw0cfSc9-RiV5uBExv1NdtlFfIo9jfob2S1u2Bs_s3SNmpId0PwHBP0Mxv6UXQvjOw9NbCwjmYf2uH5R20SQ2C2BRm5MglMGJQ4fN9c6pQ8UxrpkaYA")
  .build();
Response response = client.newCall(request).execute(); **/
```

## Technical Problems
Implementing the API call into Java, we got the code snippet off Postman, but are unable to work through the errors we are facing. 


