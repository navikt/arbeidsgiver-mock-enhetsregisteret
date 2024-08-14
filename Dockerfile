FROM cgr.dev/chainguard/jre:latest
ENV TZ="Europe/Oslo"
COPY ./build/libs/arbeidsgiver-mock-enhetsregisteret-all.jar app.jar

EXPOSE 8080
CMD ["-jar", "app.jar"]
