FROM --platform=$BUILDPLATFORM maven:3.9.9-amazoncorretto-21-alpine AS mybuild

WORKDIR /workdir/app
COPY pom.xml /workdir/app/pom.xml
RUN pwd
RUN mvn dependency:go-offline

COPY src /workdir/app/src
RUN mvn install -X -Dmaven.test.skip=true

FROM mybuild AS production
RUN mkdir -p target/dependency
RUN pwd
WORKDIR /workdir/app/target/dependency
RUN jar -xf ../*.jar

FROM eclipse-temurin:21-jre-alpine
EXPOSE 8080
ARG DEPENDENCY=/workdir/app/target/dependency
COPY --from=production ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=production ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=production ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.jay.EventManager.EventManagerApplication"]