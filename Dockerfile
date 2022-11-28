FROM openjdk:11
COPY src/main/java/com.example.cookingrecipesapi/ /tmp
ADD target/CookingRecipesAPI.jar CookingRecipesAPI.jar
ENTRYPOINT ["java", "-jar", "/CookingRecipesAPI.jar"]