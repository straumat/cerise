![Cerise BIP-0171](website/public/assets/img/logo.png)

Currency &amp; Exchange Rate Information SErver for Bitcoin ([BIP-0171](https://github.com/bitcoin/bips/blob/master/bip-0171.mediawiki)). Visit our website for more informations : [http://www.cerise.tech/](http://www.cerise.tech/)


We aim to provide the following artifacts : 
 * A mocked BIP 171 compliant server side implementation you can use to develop your client applications (done).
 * Unit tests that validates the server side implementation (done).
 * A template project where you can write your code to retrieve data from your information system and will produce your BIP 171 server as a Spring Boot Application (wip).
 * Client libraries to call any BIP-0171 compliant server (done).
 
## Running as standalone application.
Download `cerise.jar` from [https://github.com/straumat/cerise/releases](https://github.com/straumat/cerise/releases) and run it with the command `java -jar cerise.jar`.
 
## Running from sources.
```
git clone git@github.com:straumat/cerise.git
cd cerise
mvn spring-boot:run
```

You can now access the API at this address : [http://localhost:8080/swagger-ui.html#/cerise-api](http://localhost:8080/swagger-ui.html#/cerise-api).

