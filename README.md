# docker-backend-repo
It's backend repo with docker file of java applciatino with mysql and redis server.

When you commit anything in repo then action is not triggering automically. We will triger it manual.
In this action file, there are following actions.
 1. It will pick the latest tag from tag.txt file. 
 2. Create new tag of docker image and push in docker hub. 
 3. Increment the tag version of tag file of repo.

At final, we will modify the docker-compose file with lastest docker images of backend end application.
It's useful to pull the latest docker images from docker hub and deploy into docker server.

In this repo, CDPipeline.sh file which contains the step to deploy the our application into docker server. When we will execute this file then pull latest code of our back-end repo. After it, it will use docker-compose file to deploy application with pulling latest images from dcoker hub.

If we want to down all container then go to location of code and execute the docker-compse down command.
