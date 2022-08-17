FROM public.ecr.aws/amazoncorretto/amazoncorretto:11
EXPOSE 8083
ADD target/auth-service-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

