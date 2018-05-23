# Jeneric
[![License: Apache-2.0](https://img.shields.io/badge/license-Apache--2.0-green.svg)](/LICENSE)
[![Build Status](https://travis-ci.org/mkdika/jeneric.svg?branch=master)](https://travis-ci.org/mkdika/jeneric)
[![codecov](https://codecov.io/gh/mkdika/jeneric/branch/master/graph/badge.svg)](https://codecov.io/gh/mkdika/jeneric)
[![JavaDoc](https://img.shields.io/badge/javadoc-html-blue.svg)](/#)

A tiny library for collection of custom yet frequently used function and helper. 
Build on top of Java 8 standard API, no external libraries is needed.


## Overview
_coming soon.._


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
_coming soon.._


## Build and Testing
- Install Java 8 JDK.
- [Install Maven3](https://maven.apache.org/install.html).
- To build from source and run the complete __Coverage Test__ and __Mutation Test__, execute this from project root folder:
	
	```console
	mvn clean install org.pitest:pitest-maven:mutationCoverage
	```
	
	- Check `target` folder, and search for `jeneric-<version>.jar`, for built file.
	- Check folder and open file `target/site/jacoco/index.html`, for Jacoco coverage test result.
	- Check folder and open file `target/pit-reports/<YYYYMMDDHHMI>/index.html`, for PiTest mutation test result.


## Documentation
_coming soon.._


## Maintainer
- [Maikel Chandika](https://github.com/mkdika)
- [Reja](https://github.com/zigic88)


## License
Licensed under the Apache License, Version 2.0. See [LICENSE](/LICENSE) file.
