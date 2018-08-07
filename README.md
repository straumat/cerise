![Cerise BIP-0171](website/public/assets/img/logo.png)

**C**urrency &amp; **E**xchange **R**ate **I**nformation **SE**rver for Bitcoin ([BIP-0171](https://github.com/bitcoin/bips/blob/master/bip-0171.mediawiki)) - for further information please visit our website [http://www.cerise.tech](http://www.cerise.tech/)

We provide the following artifacts : 
 * A [mocked BIP 171 compliant server side implementation](https://github.com/straumat/cerise) you can use to develop your client applications.
 * A [server template project](https://github.com/straumat/cerise-server-template) allowing you to write your implementation and automatically produce your BIP 171 server.
 * A collection of [client libraries](http://www.cerise.tech/#clients) to call any BIP-0171 compliant server with your favorite language.
 
## Running as standalone application.
Download `cerise.jar` from [https://github.com/straumat/cerise/releases](https://github.com/straumat/cerise/releases) and run it with the command `java -jar cerise.jar`.
 
## Running from sources.
```
git clone git@github.com:straumat/cerise.git
cd cerise
mvn spring-boot:run
```

## Running with docker.
```
docker run -l cerise -p 80:8080 straumat/cerise:0.3
```

## View documentation and call the API.
Once the application is launched, you can access the API at this address : [http://localhost:8080/swagger-ui.html#/cerise-api](http://localhost:8080/swagger-ui.html#/cerise-api).
