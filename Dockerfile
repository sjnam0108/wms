FROM public.ecr.aws/amazoncorretto/amazoncorretto:17
VOLUME /tmp
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]

HEALTHCHECK --interval=10s --timeout=3s \
  CMD curl -f http://localhost:8080/actuator/health || exit 1