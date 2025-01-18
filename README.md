# docker-backend-repo
1. If, use the docker hub repo
	It's backend repo with docker file of java applciatino with mysql and redis server.

	When you commit anything in repo then action is not triggering automically. We will triger it manual.
	In this action file, there are following actions.
	 1. It will pick the latest tag from tag.txt file. 
	 2. Create new tag of docker image and push in docker hub. 
	 3. Increment the tag version of tag file of repo.

	At final, we will modify the docker-compose file with lastest docker images of backend end application.
	It's useful to pull the latest docker images from docker hub and deploy into docker server.

	In this repo, CDPipeline.sh file which contains the step to deploy the our application into docker server. When we will execute this file then pull latest code of our back-end repo. After it, it will use docker-compose file to deploy application with pulling latest images from dcoker hub.

2.  Use the docker-compose-build file to build application and start the container. Clone the docker-backend repo and docker-frontend repo.
   Copy docker-compose_build file docker-backend repo and place outside project where both project exists. 
   
   build docker compose to create image and download other images and start the container.
   

If we want to down all container then go to location of code and execute the docker-compse down command.

Usages : 

Backend v7 and ui 3 image is used for promoties and grafana interface with spring boot and microservices


Actuator:  http://localhost:8484/actuator/prometheus

Prometheus Server : http://localhost:9090/graph?g0.expr=logback_events_total%7Binstance%3D%22uiContainer%3A8484%22%2C%20job%3D%22microservices%22%2C%20level%3D%22info%22%7D&g0.tab=0&g0.stacked=0&g0.show_exemplars=0&g0.range_input=1h

Exm: http://localhost:9090/status
http://localhost:9090/graph?g0.expr=http_server_requests_seconds_count%7Binstance%3D%22uiContainer%3A8484%22%2C%20job%3D%22microservices%22%7D&g0.tab=1&g0.stacked=0&g0.show_exemplars=0&g0.range_input=30m&g1.expr=http_server_requests_active_seconds_count&g1.tab=1&g1.stacked=0&g1.show_exemplars=0&g1.range_input=1h


Grafana Server: http://localhost:3000/d/sOae4vCnk/spring-boot-statistics?orgId=1&refresh=5s
	Add data source in the configuration tab
 	Use Prometheus URL of docker container : http://prometheus:9090
 	Then add panel for metrics of application. 
 
