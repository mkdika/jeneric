## How to Contribute to Jeneric


### Creating an issue
* Reporting bug or hotfix, remember to include sufficient information.
* New features or functions.
* Asking questions.
* Suggestions, advices and recommendation.


### Creating a PR
Every PR will be considered.


#### How to increase the chance of having your PR merged

* Ask about the feature beforehand (or pick one of the open issues).
* If no issue exists, create an issue for the PR.
* Format your code so it looks somewhat like the rest of the source.
* Write a proper and sufficient __javadoc__ for each method or attribute, give some example of usage if needed. Try to follow the style and convension from the existing code.
* Try to write some unit test for your change. There are a lot of examples in the `test` dir.
* In order to maintain the standard quality of delivery, here are some metric that we used:
	* Coverage test: __>= 90%__
	* Mutation test: __>= 80%__


### How to run the test

#### Unit test and coverage test

```console
mvn test
```

#### Mutation test

```console
mvn org.pitest:pitest-maven:mutationCoverage
```

### How to install in local Maven repository for development testing

```console
mvn install
```

Thanks! :heart:
