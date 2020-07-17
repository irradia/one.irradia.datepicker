one.irradia.datepicker
===

[![Build Status](https://img.shields.io/travis/irradia/one.irradia.datepicker.svg?style=flat-square)](https://travis-ci.org/irradia/one.irradia.datepicker)
[![Maven Central](https://img.shields.io/maven-central/v/one.irradia.datepicker/one.irradia.datepicker.views.svg?style=flat-square)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22one.irradia.datepicker%22)
[![Maven Central (snapshot)](https://img.shields.io/nexus/s/https/oss.sonatype.org/one.irradia.datepicker/one.irradia.datepicker.api.svg?style=flat-square)](https://oss.sonatype.org/content/repositories/snapshots/one.irradia.datepicker/)
[![Codacy Badge](https://img.shields.io/codacy/grade/d0b7e91a88f640049bcaf706ae088d63.svg?style=flat-square)](https://www.codacy.com/app/github_79/one.irradia.datepicker?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=irradia/one.irradia.datepicker&amp;utm_campaign=Badge_Grade)
[![Codecov](https://img.shields.io/codecov/c/github/irradia/one.irradia.datepicker.svg?style=flat-square)](https://codecov.io/gh/irradia/one.irradia.datepicker)
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
