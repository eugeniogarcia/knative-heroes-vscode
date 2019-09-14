# Crear la imagen manualmente
```
docker run -it -v "C:/Users/Eugenio/Documents/cloudcode-projects/java-hello-world:/home/euge" openjdk:8-jre-alpine
```
Una vez se arranca la imagen y estamos en el terminal:  
```
apk update && apk upgrade && apk add netcat-openbsd

mkdir -p /app 

cp /home/euge/target/heroes-0.0.2-SNAPSHOT.jar /app/ 

java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005,quiet=y -jar /app/heroes-0.0.2-SNAPSHOT.jar &

```
Vamos a instalar curl:  
```
apk add curl
```
Abrimos otro powershell y ejecutamos:  
```
docker ps
```
Veremos nuestro contenedor ejecutandose, con un nombre xxxx. Hacemos lo siguiente para ver todo lo que hemos hecho en la imagen:  
```
docker diff xxxx
```
Para guardar el contendor como una imagen:
```
docker commit xxxx
```
Finalmente podemos crear un tag para la imagen recien creada. yyyy sera el `IMAGE ID`:
```
docker tag yyyy www.gz.com:5000/heroes:0.0.2-SNAPSHOT
```
Podemos ahora lanzar nuestra imagen:  
```
docker run -it -p 8082:8082 www.gz.com:5000/heroes:0.0.2-SNAPSHOT
```
Es equivalente a:  
```
docker run -it -p 8082:8082 www.gz.com:5000/heroes:0.0.2-SNAPSHOT /bin/sh
```
Podemos hacer:  
```
docker run -d -p 8082:8082 www.gz.com:5000/heroes:0.0.2-SNAPSHOT java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005,quiet=y -jar /app/heroes-0.0.2-SNAPSHOT.jar
```