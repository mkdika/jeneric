# Jeneric
[![License: Apache-2.0](https://img.shields.io/badge/license-Apache--2.0-green.svg)](/LICENSE)
[![Build Status](https://travis-ci.org/mkdika/jeneric.svg?branch=master)](https://travis-ci.org/mkdika/jeneric)
[![codecov](https://codecov.io/gh/mkdika/jeneric/branch/master/graph/badge.svg)](https://codecov.io/gh/mkdika/jeneric)
[![Maven](https://img.shields.io/maven-central/v/com.mkdika/jeneric.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.mkdika%22%20AND%20a%3A%22jeneric%22)
[![Javadocs](https://www.javadoc.io/badge/com.mkdika/jeneric.svg)](https://www.javadoc.io/doc/com.mkdika/jeneric)

A tiny library for collection of custom yet frequently used function and helper. 
Build on top of Java 8 standard API, no external libraries is needed.


## Overview
- high level function to ease usage.
- total up to 64 functions (version 1.0.0)
- only use Java 8 standard API.
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

```groovy
dependencies {
    compile 'com.mkdika:jeneric:1.0.0'
}
```


### Usage

This is a sample usage of Jeneric's function:

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


## Build, Testing and Install

### Pre-requirement
- Install Java 8 JDK.
- [Install Maven3](https://maven.apache.org/install.html).

### Build
To build from source and run the __Coverage Test__, execute this from the project root:
	
```console
mvn clean package
```

Check `target` folder, and search for `jeneric-<version>.jar`, for built file.	
	
### Test

#### Unit Test and Coverage Test

Run this from project root:

```console
mvn test
``` 

Check folder and open file `target/site/jacoco/index.html`, for Jacoco coverage test result.	

#### Mutation Test
	
Additionally after built the project you can run the mutation test as well (please note it may need some time to finish), run this from project root:
	
```console
mvn org.pitest:pitest-maven:mutationCoverage
```

Check folder and open file `target/pit-reports/<YYYYMMDDHHMI>/index.html`, for PiTest mutation test result.

### Install in Local Maven Repository

To install into local Maven repository for development testing purpose, run this from project root:

```console
mvn install
```


## Documentation
_coming soon.._


## Maintainer
- [Maikel Chandika](https://github.com/mkdika)
- [Reja](https://github.com/zigic88)

Contributions are very welcome, please read [How to contribute](/documents/CONTRIBUTING.md).


## License
Licensed under the Apache License, Version 2.0. See [LICENSE](/LICENSE) file.
