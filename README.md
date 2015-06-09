# sf_movies
A simple app backed by a web service that displays information about movies shoot locations in san francisco.

Author Mukul Sharma

Technical Track : Full Stack

Problem: SF Movies
Create a service that shows on a map where movies have been filmed in San Francisco. The user should be able to filter the view using autocompletion search.

Technical Track Reasoning : I went with Full Stack technical track even though i am not very good in JS. I thought it was a good chance to test my JS skills.  I had various issues while working on the project. The data that i downloaded had missing/ inconsisient address strings. Also Google geocoding api has a rate limit, so i had to limit the results to 4 results per page only. I also had tough time getting this app coded as i had some issues at my current work(quarter release :) ) and hence limiting the time i was able to give to coding.



Tradeoffs/ More Features: I did several tradeoffs to save time. I did not created interface for services(not advisable at all and i will try to get interface set tomorrow). I am not usung any caching at persistence layer level so this app will not perform very well on load. Not able to add tests to the app(will try to add those too). I wanted to implement 2 features when i initially thought of the app.
1. IMDB Info. I thought of adding GET /rest/movies/{id}/imdb endpoint to rest service which will return the imdb resource associated with a movie, hence alowing front end to show Image, and additional info of  movie
2. Create a login page, and make user signin. After that user can bookmark some place, get back to it and then ask for directons from the app.

Code: Backend
I tried to create a clear layred api stack with porper division of concerns.
There are two services SfMovieService and SearchService.
A service has following layers


Service : deals with Json parsing and calling appropriate EntityProviders.


Providers: Deal with json validation, bean conversion to entity, Calling appropriate converters and managers

Manager: Manage the beans, handle CRUD operations on beans

DAO: Persistence layer for beans

Bean: POJO mapping to some DB table.

Entity: POJO represnetation of a resource that is served by service(could be formed from more than one bean)


Find the Working app [here](http://ec2-52-24-119-5.us-west-2.compute.amazonaws.com:8080/sf_movies/)


Stack Used:
FrontEnd: Bootstrap,typeahead, jquery, ajax, javascript, html, css.
Service: Rest, Jax-rs, jersey, JSON, Spring , postgres, Java
Build tools : Maven

