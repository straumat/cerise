![Cerise BIP-0171](website/public/assets/img/logo.png)

**C**urrency &amp; **E**xchange **R**ate **I**nformation **SE**rver for Bitcoin ([BIP-0171](https://github.com/bitcoin/bips/blob/master/bip-0171.mediawiki)) - for further information please visit our website [http://www.cerise.tech](http://www.cerise.tech/)

We provide the following artifacts : 
 * [BIP-0171 specifications](http://www.cerise.tech/#specifications).
 * A [mocked BIP-0171 compliant server as a Java application](https://github.com/straumat/cerise-server-mock) you can use to develop your client application.
 * A [mocked BIP-0171 compliant server as a Docker image](https://hub.docker.com/r/straumat/cerise-server-mock/) you can use to develop your client application.
 * A [BIP-0171 library](https://github.com/straumat/cerise) to transform your application in a BIP-0171 server.
 * A [server template project](https://github.com/straumat/cerise-server-template) to quickly write your implementation and automatically produce your BIP-0171 server.
 * A collection of [client libraries](http://www.cerise.tech/#clients) to call any BIP-0171 compliant server with your favorite language.

## Use within your maven project.
```
<dependency>
    <groupId>com.oakinvest.cerise</groupId>
    <artifactId>cerise</artifactId>
</dependency>
```

## Run cerise server.
```
git clone git@github.com:straumat/cerise.git
cd cerise
mvn spring-boot:run
```

## View documentation and call the API.
You can access the API at this address : [http://localhost:8080/docs](http://localhost:8080/docs).