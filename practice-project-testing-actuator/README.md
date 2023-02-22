<a>Practice Project</a>
---
##Prerequisites
1. *Dabasebase: Oracle 19c*
1. *Add proper properties into application.properties configurating app*
1. *Table will be initialized when app started*

#API
##-POST: "/api/tutorials"
*Add new tutorial*


##-GET: "/api/tutorials"
*Get all tutorials*

##-GET: "/api/tutorials/:id"
*Get a tutorial detail by ID


##-PUT: "/api/tutorials/:id"
*UPDATE tutorial detail by ID*

##-DELETE: "/api/tutorials/:id"
*DELETE an specific tutorial by ID*

##-DELETE: "/api/tutorials"
*DELETE all tutorials*

##-GET: "/api/tutorials/published"
*Get tutorials filtered by published*

##-GET: "/api/tutorials?title=[keyword]"
*Get tutorials by the params*

