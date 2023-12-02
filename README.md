# Spotify Wrappers: Year-Round Spotify Statistics Tracker

Our project is a personalized statistics reporter specific to the user's listening activity on Spotify. We utilized the
<a href="https://developer.spotify.com/documentation/web-api">Spotify for Developers Web API</a> to pull data specific 
to the user's account. 

## Method of Implementation

We implemented our program using Java, with assistance from the <a href="https://github.com/spotify-web-api-java/spotify-web-api-java">Spotify
API Wrapper for Java</a> linked at the end of the Lecture 14 slides. Our program stresses Clean Architecture and SOLID
Design Principles to keep code simple and extendable. 

### API Usage

We utilized the API in several ways to reach the end goal of our program. Most notably, we used GET commands to pull
users' top tracks and top artists. The authorization of the user used a POST command to receive an authorization token,
which allowed us to read information from their account listening history.

The code for our API calls are in /api/SpotDevelopDB.java.

### Design Patterns

To keep our program organized for both us and the user, we implemented several different design patterns. For example, the
API calls to get a user's top songs and artists make calls to /entity/SongFactory.java and /entity/ArtistFactory.java,
respectively. These factories take the JSONObjects returned by the API calls and make them into entity objects which
our program can use. Our views are also observers, which wait for changes from the user and update the view accordingly.

## Use Cases

We return six types of data over three timeframes, short term (last 4 weeks), medium term (last 6 months), and long term
(all time). The data we return are a user's top songs, artists, albums, genres, as well as the related artists to their
top artist and the average valence (Spotify's "happiness rating" of a track) of the user's top songs. This satisfies
almost all of our initial use cases.

## Differences from Original Plan

The scope of our original plan was very large, so we had to downsize to make the project more feasible for the amount
of time we had and our skill-set. Generating graphs and images was a desired function of our program starting out, but
we quickly discovered that images were difficult to manipulate. We opted to focus on getting and organizing user data.

