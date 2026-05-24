#!/bin/bash

# =========================================
# RESOURCE GROUP
# =========================================

az group create \
  --name rg-clyvo-final \
  --location canadacentral

# =========================================
# VIRTUAL MACHINE
# =========================================

az vm create \
  --resource-group rg-clyvo-final \
  --name vm-clyvo-final \
  --image Ubuntu2204 \
  --admin-username azureuser \
  --generate-ssh-keys \
  --size Standard_B2ats_v2

# =========================================
# OPEN PORTS
# =========================================

az vm open-port \
  --resource-group rg-clyvo-final \
  --name vm-clyvo-final \
  --port 8080

az vm open-port \
  --resource-group rg-clyvo-final \
  --name vm-clyvo-final \
  --port 8082

az vm open-port \
  --resource-group rg-clyvo-final \
  --name vm-clyvo-final \
  --port 9092

# =========================================
# INSTALL DOCKER
# =========================================

sudo apt update

sudo apt install docker.io docker-compose -y

sudo systemctl enable docker
sudo systemctl start docker

# =========================================
# CLONE PROJECT
# =========================================

git clone https://github.com/FelipeRibeiroSalles/clyvo-care-ai.git

cd clyvo-care-ai

# =========================================
# BUILD APPLICATION
# =========================================

chmod +x mvnw

./mvnw clean package -DskipTests

# =========================================
# RUN CONTAINERS
# =========================================

sudo docker-compose up --build -d
