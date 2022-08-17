FROM public.ecr.aws/amazoncorretto/amazoncorretto:11
ADD target/gateway-server*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

