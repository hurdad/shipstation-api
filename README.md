# shipstation-api
[![Build Status](https://travis-ci.org/hurdad/shipstation-api.svg?branch=master)](https://travis-ci.org/hurdad/shipstation-api)

Java 8 interface to ShipStation HTTP API

## Build Requirements
```
Java 8 JDK
Maven
```

## Build
```
$ mvn
```

## Run Test
```
$ mvn test
```

## Create JAR
```
$ mvn package
```

## Usage
```
# See APITest.java for examples of each API call
import com.apex.shipstation.API;
API api = new API("https://ssapi.shipstation.com", "api_key", "api_secret");
Order order = api.getOrder(123456789);
System.out.println(order.getOrderNumber());
```
