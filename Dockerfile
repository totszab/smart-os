FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY run.sh /app/run.sh
RUN chmod +x /app/run.sh

CMD ["./run.sh"]