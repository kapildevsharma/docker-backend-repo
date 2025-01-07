#!/bin/bash
 
# Define variables for repository URL and target directory
REPO_URL="https://"+$GIT_TOKEN+"@github.com/kdsmika/docker-backend-repo.git"

TARGET_DIR="/home/kapilsharma05/Docekr_Project/Docker_Github"
 
# Step 1: Pull the latest changes from the GitHub repository
echo "Cloning the repository..."
git clone $REPO_URL $TARGET_DIR || (cd $TARGET_DIR && git pull)
 
# Step 2: Navigate to the directory with the Docker Compose file
echo "Navigating to the repository directory..."
cd $TARGET_DIR || exit
 
# Step 3: Check if Docker Compose file exists
if [ ! -f "docker-compose.yml" ]; then
  echo "docker-compose.yml not found in the repository. Exiting..."
  exit 1
fi
 
# Step 4: Run Docker Compose
echo "Running Docker Compose..."
docker-compose up -d
 
# Step 5: Optionally check if containers are up
docker ps
 
echo "Done!"