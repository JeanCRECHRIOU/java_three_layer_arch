# Étape 1 : Build avec Maven et JDK basé sur Debian
# Construction de l’application
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Creation dossier /app et entre dedans
WORKDIR /app

# Copie tout projet local (là où est ton Dockerfile) dans /app du conteneur.
COPY . .

# Maven compile projet à partir du pom.xml de la racine du projet, sans lancer les tests. Il va générer le .jar final dans target/apiweb
RUN mvn clean install -DskipTests


# Étape 2 : Image d'exécution (runtime) basée sur Debian
FROM eclipse-temurin:17-jdk-jammy

# Création le dossier /app dans la nouvelle image d’exécution.
WORKDIR /app

# Copie le JAR compilé depuis l’image de build (étape précédente) dans cette image légère.
COPY --from=build /app/apiweb/target/apiweb-1.0-SNAPSHOT.jar app.jar

# C’est la commande par défaut quand le conteneur démarre : elle lance  app Java.
ENTRYPOINT ["java", "-jar", "app.jar"]

# Étape 2 : Image d'exécution (runtime) basée sur Debian
FROM eclipse-temurin:17-jdk-jammy

# Creation app dans nouvelle image d'execution
WORKDIR /app

# copie du JAR compilé depuis l’image de build (étape précédente) dans cette image légère.
COPY --from=build /app/apiweb/target/apiweb-1.0-SNAPSHOT.jar app.jar

# C’est la commande par défaut quand le conteneur démarre : elle lance app Java.
ENTRYPOINT ["java", "-jar", "app.jar"]

# mvn clean install -DskipTests

# Executer le dockerfile depuis la racine du projet
#sudo docker build -t java-clean-app -f apiweb/Dockerfile .

# Puis executer l'image
#docker run -p 8080:8080 java-clean-app


# base de donnee
# sudo docker run -d -p 5432:5432 --name postgres-container postgres
#sudo docker compose up --build

