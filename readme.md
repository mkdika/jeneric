# Jeneric
[![License: Apache-2.0](https://img.shields.io/badge/license-Apache--2.0-green.svg)](/LICENSE)
[![Build Status](https://travis-ci.org/mkdika/jeneric.svg?branch=master)](https://travis-ci.org/mkdika/jeneric)
[![codecov](https://codecov.io/gh/mkdika/jeneric/branch/master/graph/badge.svg)](https://codecov.io/gh/mkdika/jeneric)
[![Javadocs](https://www.javadoc.io/badge/com.mkdika/jeneric.svg)](https://www.javadoc.io/doc/com.mkdika/jeneric/1.0.0)

A tiny library for collection of custom yet frequently used function and helper. 
Build on top of Java 8 standard API, no external libraries is needed.


## Overview
- high level function to ease usage.
- total up to 64 functions (version 1.0.0)
- build on top of Java 8 standard API.
- high coverage > 95%, and Mutation test > 85%.
- Return types oriented.


## Used Tool and Library
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase8-2177648.html)
- [Maven3](https://maven.apache.org/index.html), as build system and dependency management.
- __Unit Testing__:
	- [JUnit4](https://junit.org/junit4/), as unit testing framework.
	- [Java Hamcrest](http://hamcrest.org/JavaHamcrest/), for ease matcher and more human readable equality test.
	- [JUnitParams](https://github.com/Pragmatists/JUnitParams), for ease parameterized test.
	- [Mockito](http://site.mockito.org/), a mock test framework.
	- [Jacoco](https://www.eclemma.org/jacoco/), a code coverage library.
	- [Pitest](http://pitest.org/), State of the art mutation testing system for the JVM.


## Quickstart

### Setting up dependency

#### Maven

```xml
<dependency>
	<groupId>com.mkdika</groupId>
	<artifactId>jeneric</artifactId>
	<version>1.0.0</version>
</dependency>
```

#### Gradle
_coming soon.._


### Usage

This is a example Jeneric's function usage:

```java
import com.mkdika.jeneric.function.DateFun;
import com.mkdika.jeneric.function.StringFun;
import java.util.Date;

public class JenericTest {

    public static void main(String[] args) {
        Date d1 = DateFun.of(2018, 4, 28, 19, 35, 25);
        Date d2 = DateFun.of(2018, 5, 23, 12, 30, 45);
        System.out.println(StringFun.elapsedTime(d1, d2));

        // print: 24 days 16 hours 55 minutes 20 seconds 0 milliseconds        
    }
}
```


## Build and Testing
- Install Java 8 JDK.
- [Install Maven3](https://maven.apache.org/install.html).
- To build from source and run the __Coverage Test__, execute this from the project root:
	
	```console
	mvn clean install org.pitest:pitest-maven:mutationCoverage
	```
	
	- Check `target` folder, and search for `jeneric-<version>.jar`, for built file.
	- Check folder and open file `target/site/jacoco/index.html`, for Jacoco coverage test result.	
	
- After built the project, Additionally you can run the __Mutation Test__ as well (please note it may need some time to finish), execute this from the project root:
	
	```console
	mvn org.pitest:pitest-maven:mutationCoverage
	```
	
	- Check folder and open file `target/pit-reports/<YYYYMMDDHHMI>/index.html`, for PiTest mutation test result.


## Documentation
_coming soon.._


## Maintainer
- [Maikel Chandika](https://github.com/mkdika)
- [Reja](https://github.com/zigic88)


## License
Licensed under the Apache License, Version 2.0. See [LICENSE](/LICENSE) file.
