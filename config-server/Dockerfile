FROM public.ecr.aws/amazoncorretto/amazoncorretto:11
EXPOSE 8888
ADD target/config-server-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

