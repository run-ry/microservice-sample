FROM public.ecr.aws/amazoncorretto/amazoncorretto:11
EXPOSE 8761
ADD target/discovery-server-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

