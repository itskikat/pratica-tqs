# TQS - LAB02
#### Author: Francisca Barros, NMEC-93102
---

## 2/ Reverse Geocoding

##### b)

In this test, we do not want to check that the remote API is up-and-running. Instead, we want to verify that the AddressResolver is doing its job. 

The service we must mock will be the HttpClient.
- This way, we must define a realistic expectation when we're doing a 'get'


 
## 3/ Integration Test

In this exercise, we're not supposed to use mocks. Instead, we want to test the API itself, so we must use real implementations of the module. 

``` java
    private ISimpleHttpClient basicHttpClient;
    private AddressResolver addressResolver;
    
    @BeforeEach
    public void init(){
        basicHttpClient = new TqsBasicHttpClient();
        addressResolver = new AddressResolver(basicHttpClient);
    }
```

In an integration test, we want to check out the APIs behaviour - see how it reacts when it is actually called.

##### Only using mvn test

- By default, maven will only run Unit Tests. It assumes that all classes ending in 'Test' represent Unit Tests.
- Since the Integration Test class doesn't end in 'Test', yet in 'IT', it won't be considered in this scenario.

``` zsh
TQS_Lab02-MockHttpClient % mvn test
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< uatqs:gs-MockForHttpClient >---------------------
[INFO] Building gs-MockForHttpClient 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ gs-MockForHttpClient ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ gs-MockForHttpClient ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ gs-MockForHttpClient ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/franciscabarros/IdeaProjects/TQS_Lab02-MockHttpClient/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ gs-MockForHttpClient ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ gs-MockForHttpClient ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running geocoding.AddressResolverTest
 url is --> http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=40.640661%2C-8.656688&includeRoadMetadata=true <--
JSON is: >{"info":{"statuscode":0,"copyright":{"text":"\u00A9 2021 MapQuest, Inc.","imageUrl":"http://api.mqcdn.com/res/mqlogo.gif","imageAltText":"\u00A9 2021 MapQuest, Inc."},"messages":[]},"options":{"maxResults":1,"thumbMaps":true,"ignoreLatLngInput":false},"results":[{"providedLocation":{"latLng":{"lat":40.640661,"lng":-8.656688}},"locations":[{"street":"Cais do Alboi","adminArea6":"","adminArea6Type":"Neighborhood","adminArea5":"Gl\u00F3ria e Vera Cruz","adminArea5Type":"City","adminArea4":"","adminArea4Type":"County","adminArea3":"Centro","adminArea3Type":"State","adminArea1":"PT","adminArea1Type":"Country","postalCode":"3800-246","geocodeQualityCode":"B1AAA","geocodeQuality":"STREET","dragPoint":false,"sideOfStreet":"N","linkId":"0","unknownInput":"","type":"s","latLng":{"lat":40.640524,"lng":-8.656713},"displayLatLng":{"lat":40.640524,"lng":-8.656713},"mapUrl":"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.64052368145179,-8.656712986761146|marker-sm-50318A-1&scalebar=true&zoom=15&rand=1991826040","roadMetadata":null}]}]}<
 url is --> http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=55555.000000%2C-66666.000000&includeRoadMetadata=true <--
JSON is: >{"info":{"statuscode":0,"copyright":{"text":"\u00A9 2021 MapQuest, Inc.","imageUrl":"http://api.mqcdn.com/res/mqlogo.gif","imageAltText":"\u00A9 2021 MapQuest, Inc."},"messages":[]},"options":{"maxResults":1,"thumbMaps":true,"ignoreLatLngInput":false},"results":[{"providedLocation":{"latLng":{"lat":55555,"lng":-66666}},"locations":[]}]}<
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.538 s - in geocoding.AddressResolverTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.066 s
[INFO] Finished at: 2021-03-24T08:36:18Z
[INFO] ------------------------------------------------------------------------

```


##### Using Failsafe Plugin  

- In this scenario, we're presented with two 'test-blocks' - the first one containing the Unit Tests (like before), and the second one with our Integration Tests :) 

``` zsh
TQS_Lab02-MockHttpClient % mvn install failsafe:integration-test
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< uatqs:gs-MockForHttpClient >---------------------
[INFO] Building gs-MockForHttpClient 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ gs-MockForHttpClient ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ gs-MockForHttpClient ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ gs-MockForHttpClient ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/franciscabarros/IdeaProjects/TQS_Lab02-MockHttpClient/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ gs-MockForHttpClient ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ gs-MockForHttpClient ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running geocoding.AddressResolverTest
 url is --> http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=40.640661%2C-8.656688&includeRoadMetadata=true <--
JSON is: >{"info":{"statuscode":0,"copyright":{"text":"\u00A9 2021 MapQuest, Inc.","imageUrl":"http://api.mqcdn.com/res/mqlogo.gif","imageAltText":"\u00A9 2021 MapQuest, Inc."},"messages":[]},"options":{"maxResults":1,"thumbMaps":true,"ignoreLatLngInput":false},"results":[{"providedLocation":{"latLng":{"lat":40.640661,"lng":-8.656688}},"locations":[{"street":"Cais do Alboi","adminArea6":"","adminArea6Type":"Neighborhood","adminArea5":"Gl\u00F3ria e Vera Cruz","adminArea5Type":"City","adminArea4":"","adminArea4Type":"County","adminArea3":"Centro","adminArea3Type":"State","adminArea1":"PT","adminArea1Type":"Country","postalCode":"3800-246","geocodeQualityCode":"B1AAA","geocodeQuality":"STREET","dragPoint":false,"sideOfStreet":"N","linkId":"0","unknownInput":"","type":"s","latLng":{"lat":40.640524,"lng":-8.656713},"displayLatLng":{"lat":40.640524,"lng":-8.656713},"mapUrl":"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.64052368145179,-8.656712986761146|marker-sm-50318A-1&scalebar=true&zoom=15&rand=1991826040","roadMetadata":null}]}]}<
 url is --> http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=55555.000000%2C-66666.000000&includeRoadMetadata=true <--
JSON is: >{"info":{"statuscode":0,"copyright":{"text":"\u00A9 2021 MapQuest, Inc.","imageUrl":"http://api.mqcdn.com/res/mqlogo.gif","imageAltText":"\u00A9 2021 MapQuest, Inc."},"messages":[]},"options":{"maxResults":1,"thumbMaps":true,"ignoreLatLngInput":false},"results":[{"providedLocation":{"latLng":{"lat":55555,"lng":-66666}},"locations":[]}]}<
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.586 s - in geocoding.AddressResolverTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ gs-MockForHttpClient ---
[INFO] Building jar: /Users/franciscabarros/IdeaProjects/TQS_Lab02-MockHttpClient/target/gs-MockForHttpClient-1.0-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ gs-MockForHttpClient ---
[INFO] Installing /Users/franciscabarros/IdeaProjects/TQS_Lab02-MockHttpClient/target/gs-MockForHttpClient-1.0-SNAPSHOT.jar to /Users/franciscabarros/.m2/repository/uatqs/gs-MockForHttpClient/1.0-SNAPSHOT/gs-MockForHttpClient-1.0-SNAPSHOT.jar
[INFO] Installing /Users/franciscabarros/IdeaProjects/TQS_Lab02-MockHttpClient/pom.xml to /Users/franciscabarros/.m2/repository/uatqs/gs-MockForHttpClient/1.0-SNAPSHOT/gs-MockForHttpClient-1.0-SNAPSHOT.pom
[INFO] 
[INFO] --- maven-failsafe-plugin:2.22.2:integration-test (default-cli) @ gs-MockForHttpClient ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running integration.AddressResolverIT
 url is --> http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=55555.000000%2C-66666.000000&includeRoadMetadata=true <--
JSON is: >{"info":{"statuscode":0,"copyright":{"text":"\u00A9 2021 MapQuest, Inc.","imageUrl":"http://api.mqcdn.com/res/mqlogo.gif","imageAltText":"\u00A9 2021 MapQuest, Inc."},"messages":[]},"options":{"maxResults":1,"thumbMaps":true,"ignoreLatLngInput":false},"results":[{"providedLocation":{"latLng":{"lat":55555.0,"lng":-66666.0}},"locations":[]}]}<
 url is --> http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&location=40.640661%2C-8.656688&includeRoadMetadata=true <--
JSON is: >{"info":{"statuscode":0,"copyright":{"text":"\u00A9 2021 MapQuest, Inc.","imageUrl":"http://api.mqcdn.com/res/mqlogo.gif","imageAltText":"\u00A9 2021 MapQuest, Inc."},"messages":[]},"options":{"maxResults":1,"thumbMaps":true,"ignoreLatLngInput":false},"results":[{"providedLocation":{"latLng":{"lat":40.640661,"lng":-8.656688}},"locations":[{"street":"Cais do Alboi","adminArea6":"","adminArea6Type":"Neighborhood","adminArea5":"Gl\u00F3ria e Vera Cruz","adminArea5Type":"City","adminArea4":"","adminArea4Type":"County","adminArea3":"Centro","adminArea3Type":"State","adminArea1":"PT","adminArea1Type":"Country","postalCode":"3800-246","geocodeQualityCode":"B1AAA","geocodeQuality":"STREET","dragPoint":false,"sideOfStreet":"N","linkId":"0","unknownInput":"","type":"s","latLng":{"lat":40.640524,"lng":-8.656713},"displayLatLng":{"lat":40.640524,"lng":-8.656713},"mapUrl":"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.64052368145179,-8.656712986761146|marker-sm-50318A-1&scalebar=true&zoom=15&rand=-1078533582","roadMetadata":null}]}]}<
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.034 s - in integration.AddressResolverIT
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.958 s
[INFO] Finished at: 2021-03-24T08:38:28Z
[INFO] ------------------------------------------------------------------------

```