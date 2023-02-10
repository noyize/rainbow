# rainbow

[//]: # (TODO: Provide the source project name and the Figma link)
Design system for the `<project>`. You can find the Figma
page for DLS [here](`<provide-figma-link>`)

## Getting Started

DLS library is available through GitHub packages. To use it:

1. [Create a GitHub access token (Classic)](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token#creating-a-personal-access-token-classic)
   with the `read:packages` scope
2. Add the Maven repository to your build.gradle or build.gradle.kts file.

   Example using build.gradle.kts file:
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

   > _Note: Provide credentials using a properties file or system environment variables which are
   not part of version control._

3. Add the DLS package to your dependencies in build.gradle or build.gradle.kts file.
   ```kotlin
   dependencies {
     // TODO: Update the DLS dependency coordinates
     implementation("com.company:artifact-id:<latest-version>")
     // Provide more dependencies here...
   }
   ```

For more information on how to get started with the DLS library, please take a look at our
[Getting Started](docs/getting_started.md) guide.

## Useful Links

- [Using Snapshot Version](./docs/getting_started.md#using-snapshot-version)
- [Changelog](./CHANGELOG.md)
- [Contributing](./CONTRIBUTING.md)
