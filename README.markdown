`git clone git://github.com/luiszandonadi/GooglePlacesApi.git`

`cd GooglePlacesApi`

`mvn jar:jar`

get the jar in a target directory.





**Using it:**

`PlacesService service = new PlaceService("put your key here");`

`List<Place> findPlaces = service.findPlaces(latitude,longitude);`


Enjoy it!!

