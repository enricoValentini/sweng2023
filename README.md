# progetto sweng2023
Per eseguire il progetto è necessario usare i seguenti comandi

## Per avviare il client:
mvn -U -e gwt:codeserver -pl sweng-client -am

## Per avviare il server:
mvn -U jetty:run-forked -pl sweng-server -am -Denv=dev

Aprire il browser e digitare localhost:8080
