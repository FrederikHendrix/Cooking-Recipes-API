FROM openjdk:11
EXPOSE 8080
ADD target/CookingRecipesAPI.jar CookingRecipesAPI.jar
ENTRYPOINT ["java", "-jar", "/CookingRecipesAPI.jar"]