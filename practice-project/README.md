#Practice Project
---
---
#*Prerequisites*
1. *Dabasebase: Oracle 19c*
1. *Add proper properties into application.properties configurating app*
1. *Table will be initialized when app started*

#*API*
#*-POST: "/api/tutorials"*
*Add new tutorial*
![createNewTutorial](https://user-images.githubusercontent.com/86148510/218700401-16d434e9-46bc-43a9-9c10-4aff1d2eafa8.png)
#*-GET: "/api/tutorials"*
*Get all tutorials*
![getAllTutorial](https://user-images.githubusercontent.com/86148510/218700448-c3d0bcbc-af2a-47ed-9150-47ab1cc5a3d4.png)
#-GET: "/api/tutorials/:id"
*Get a tutorial detail by ID
![getTutorialById](https://user-images.githubusercontent.com/86148510/218700505-ea189a08-4283-4d28-9c6c-5084c9a01c57.png)
#*-PUT: "/api/tutorials/:id"*
*UPDATE tutorial detail by ID*
![putTutorial](https://user-images.githubusercontent.com/86148510/218700539-2cd3c21b-e22f-471a-a17e-8fb94a4d9183.png)
#*-DELETE: "/api/tutorials/:id"*
*DELETE an specific tutorial by ID*
![deleteTutorial](https://user-images.githubusercontent.com/86148510/218700586-ca6d005e-ebbb-41d0-9885-6f6acb5bf6dc.png)
#*-DELETE: "/api/tutorials"*
*DELETE all tutorials*
![beforeDeleteAllTutorials](https://user-images.githubusercontent.com/86148510/218700608-ea78e965-841c-48f2-96ee-e7a991d4e329.png)
![afterDeleteAllTutorials](https://user-images.githubusercontent.com/86148510/218700631-32c9d12a-3393-4c6a-a458-1ad009880794.png)
#*-GET: "/api/tutorials/published"*
*Get tutorials filtered by published*
![getTutorialByPublished](https://user-images.githubusercontent.com/86148510/218700669-abe51086-c98a-4a90-a0b9-f3f715bce3ff.png)
##-GET: "/api/tutorials?title=[keyword]"
*Get tutorials by the params*
![getAllTutorialByTitle](https://user-images.githubusercontent.com/86148510/218700703-b2362b1c-8a46-46c0-9d03-9146fd6ed805.png)
