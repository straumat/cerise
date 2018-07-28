![Cerise BIP-0171](website/assets/img/logo.png)

Currency &amp; Exchange Rate Information SErver for Bitcoin ([BIP-0171](https://github.com/bitcoin/bips/blob/master/bip-0171.mediawiki))

We plan to provide the following artifacts : 
 * A mocked BIP 171 compliant server side implementation you can use to develop your client applications.
 * Unit tests that validates the server side implementation.
 * A template project where you can write your code to retrieve data from your information system and will produce your BIP 171 server as a Spring Boot Application.
 * A java client library to call any BIP-0171 compliant server.
 
## Running.
```
git clone git@github.com:straumat/cerise.git
cd cerise
mvn spring-boot:run
```

You can now access the API at this address : [http://localhost:8080/swagger-ui.html#/cerise-api](http://localhost:8080/swagger-ui.html#/cerise-api).

