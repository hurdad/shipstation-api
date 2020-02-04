# ShipStation Java API Client

![CI Status](https://github.com/kdunn926/shipstation-api/workflows/Java%20CI/badge.svg?branch=master)

ShipStation Java API Client

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
See APITest.java for examples of each API call
```
API api = new API("https://ssapi.shipstation.com", "api_key", "api_secret");

Order order = api.getOrder(123456789);

System.out.println(order.getOrderNumber());
```

## Known Issues
```
listUsers - does not work with the mock api.
```
