one.irradia.datepicker
===

[![Maven Central](https://img.shields.io/maven-central/v/one.irradia.datepicker/one.irradia.datepicker.views.svg?style=flat-square)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22one.irradia.datepicker%22)
[![Codacy Badge](https://img.shields.io/codacy/grade/d0b7e91a88f640049bcaf706ae088d63.svg?style=flat-square)](https://www.codacy.com/app/github_79/one.irradia.datepicker?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=irradia/one.irradia.datepicker&amp;utm_campaign=Badge_Grade)
[![Gitter](https://badges.gitter.im/irradia-org/community.svg)](https://gitter.im/irradia-org/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

![datepicker](./src/site/resources/datepicker.jpg?raw=true)

## Features

* A minimalist three-part date picker with a configurable range.
* ISC license

## Building

Install the Android SDK.

```
$ ./gradlew clean assemble test
```

If the above fails, it's a bug. Report it!

## Using

Use the following Maven or Gradle dependencies, replacing `${LATEST_VERSION_HERE}` with
whatever is the latest version published to Maven Central:

```
<!-- API -->
<dependency>
  <groupId>one.irradia.datepicker</groupId>
  <artifactId>one.irradia.datepicker.views</artifactId>
  <version>${LATEST_VERSION_HERE}</version>
</dependency>
```

```
repositories {
  mavenCentral()
}

implementation "one.irradia.datepicker:one.irradia.datepicker.views:${LATEST_VERSION_HERE}"
```

## Semantic Versioning

All [irradia.one](https://www.irradia.one) packages obey [Semantic Versioning](https://www.semver.org)
once they reach version `1.0.0`.
