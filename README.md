# Signs-of-Life

Signs-of-life is a demonstration microservice project containing two microservices. The `shape-service` provides geometric operations for its client, the `sign-service`.  All build and test operations can be accomplished using its package Gradle wrapper.

## Build

```bash
# Mac or Linux
./gradlew build

# Windows
gradle.bat build
```

## Test

```bash
# Mac or Linux
./gradlew test

# Windows
gradle.bat test
```

## Run

The microservices are based on Spring Boot, so can be run via the bootRun task

```bash
# Mac or Linux
./gradlew bootRun --parallel

# Windows
gradle.bat bootRun --parallel
```

## Install

The microservices use the maven plugin.  Use the `install` task to install the built jars into your local maven repository.

```bash
# Mac or Linux
./gradlew clean build install

# Windows
gradle.bat clean build install
```