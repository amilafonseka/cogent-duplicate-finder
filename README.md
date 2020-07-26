# Problem
A client merged their home photo folder with their partner's folder, with disastrous consequences. They now have a lot of duplicate photos in different places in the folder structure.

Write a command-line program in your chosen language which finds files which have exactly the same contents and outputs any duplicates (and their locations) to standard output.

## Assumptions

1. If the same photo is there in different sizes, that is NOT considered as a duplicate.
2. Not using any external library to solve the core problem. All the external libraries are used to make the packaging and running test suites easier.

## Tools and Technologies Used

1. Java 8
2. JUnit 5
3. Maven
4. Eclipse

## Design

- Project is organised in a standard structure with a service layer with 2 services and a custom exception. Unit tests appear in the standard(conventional)structure for the 2 service classes.
- Service implementation is segregated from its definition. ```DuplicateFinderServiceImpl.java``` contains the method that finds duplicates in the given directory path,
```getFilePathsWithDuplicates(...)```.
- Another service was implemented to validate the user inputs,
```DuplicateFinderInputValidationServiceImpl```. In case if the inputs are malformed, a custom exception, ```ArgumentFormatException```, is thrown.
- JavaDoc documentation is available for most methods. In line comments are written where ever it was necessary to simplify the cases handled.

## Unit Tests
Both service classes, ```DuplicateFinderInputValidationServiceImpl``` and ```DuplicateFinderServiceImpl```, have unit tests. Data driven unit testing was done where it was appropriate.

## How to run Application
### Running in IDE
This is a ```Maven``` project.

Unzip the resource bundle(project bundle) and import to your preferred IDE (with ```Maven``` project support) as a ```Maven``` project.

Give the directory path which contains the images as command line arguments in your IDE. (In Eclipse this should be done in the ```Run Configurations...``` in ```CogentDuplicateFinderApplication.java```)

Run ```CogentDuplicateFinderApplication.java``` as a Java application.

Most of the scenarios can be found in the unit test class ```DuplicateFinderServiceImplTest```

### Running in Terminal

Make sure you have ```Maven``` locally installed.

Unzip the resource bundle(project bundle) and import to your preferred IDE (with ```Maven``` project support) as a ```Maven``` project.

In terminal, go to project directory where the ```POM``` file is and run ```mvn clean install package```

Go to ```target``` directory in the same project directory and run ```java -jar cogentduplicatefinder-0.0.1-SNAPSHOT.jar IMAGES_DIRECTORY_PATH``` 

You will see a list of duplicates in the console.

