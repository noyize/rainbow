# Getting Started

## Using Snapshot Version

We release a snapshot version of the DLS library every day. In order to use it:

1. Add the Maven repository to your build.gradle or build.gradle.kts file.
    ```kotlin
    repositories {
      maven {
        // TODO: Update org and repo name in the maven link
        url = uri("https://maven.pkg.github.com/`<ORG>`/`<repo>`")
        credentials {
          // TODO: Update user credentials
          username = `<github-user-name>`
          password = `<github-personal-access-token>`
        }
      }
    }
   ```

2. Add the DLS package with version `<latest-version>-SNAPSHOT` to get the snapshot build
    ```kotlin
    dependencies {
      // TODO: Update the DLS dependency coordinates
      implementation("com.company:artifact-id:<latest-version>-SNAPSHOT")
      // Provide more dependencies here...
    }
    ```

## Playgroup App

Playground app provides a quick and easy way to explore components offered by DLS. You can configure
the components under different scenarios and see how they function.

To try out the Playground app, you can run the `playground` module in the Android Studio or run the 
following Gradle command.

```shell
./gradlew :playground:installDebug
```

[//]: # (TODO: Uncomment this if you have a migration guidance doc setup)
[//]: # (## Migration Guidance)

[//]: # ()
[//]: # (To help you migrate your existing codebase from `Material` or `AppCompat`, please take a look at the)

[//]: # ([Migration Guidance]&#40;migration.md&#41; doc.)

[//]: # ()
[//]: # (That would help you with setting up bridge themes or using linting to replace components or how to)

[//]: # (handle any known DLS migration issues.)

## Useful Links

- [Changelog](../CHANGELOG.md)
- [Contributing](../CONTRIBUTING.md)
