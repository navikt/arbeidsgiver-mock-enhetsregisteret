FROM cgr.dev/chainguard/jre:latest
ENV TZ="Europe/Oslo"
WORKDIR /app
COPY build/install/arbeidsgiver-mock-enhetsregisteret/ /app/
ENTRYPOINT ["java", "-cp", "/app/lib/*", "no.nav.arbeidsgiver.mock.enhetsregisteret.MainKt"]
