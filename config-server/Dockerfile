FROM public.ecr.aws/amazoncorretto/amazoncorretto:11
#RUN adduser -D demo
#USER demo
ADD target/config-server-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

