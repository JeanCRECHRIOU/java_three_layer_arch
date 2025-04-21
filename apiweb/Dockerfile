# Étape 1 : Build avec Maven et JDK basé sur Debian
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Création du dossier /app et entrée dedans
WORKDIR /app

# Copie tout projet local (là où est ton Dockerfile) dans /app du conteneur
COPY . .

# Maven compile le projet à partir du pom.xml de la racine du projet
RUN mvn clean install -DskipTests


# Étape 2 : Image d'exécution (runtime) basée sur Debian
FROM eclipse-temurin:17-jdk-jammy

# Création du dossier /app dans l’image d’exécution
WORKDIR /app

# Copie le JAR compilé depuis l’image de build (étape précédente) dans cette image légère
COPY --from=build /app/apiweb/target/apiweb-1.0-SNAPSHOT.jar app.jar

# Activation du débogage à distance sur le port 5005
# Cette option démarre la JVM avec un débogueur attaché, accessible via le port 5005
CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "app.jar"]

# C’est la commande par défaut quand le conteneur démarre : elle lance app Java
#ENTRYPOINT ["java", "-jar", "app.jar"]



# mvn clean install -DskipTests

# Executer le dockerfile depuis la racine du projet
#sudo docker build -t java-clean-app -f apiweb/Dockerfile .

# Puis executer l'image
#docker run -p 8080:8080 java-clean-app


# base de donnee
# sudo docker run -d -p 5432:5432 --name postgres-container postgres

#sudo docker compose up --build
#sudo docker rm java-api (suppreesion d un container)

#sudo docker-compose down (sudo docker-compose down sert à arrêter et supprimer les conteneurs, les réseaux et les volumes associés à un projet Docker Compose)
#sudo docker compose up --build (init)
#sudo docker ps (voir les image lancées)
