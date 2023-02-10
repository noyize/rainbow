# Contributing to rainbow

Welcome to the contributing guide for the rainbow. This document serves as a collection
of conventions specific to this project which contributors might useful.

## Pre-requisites

### Environment setup

The project has the following system requirements
- JDK 11 (you can install it from [azul downloads])
- Latest stable version of [Android Studio]

### Test run

Run the Playground app from your IDE on an emulator or on real device. This will ensure your setup
is functioning properly.

### Pre-push hooks

When you build the project, Gradle will automatically install a [Git pre-push hook] in the repository
to run tests when you push to GitHub.

## Building the project

### Generating a release build of the Playground app

[//]: # (TODO: Update the keystore config if changed)
1. Export the following shell variables to auto-configure signing. You can obtain the key and store passwords from [here]
   1. `RELEASE_SIGNING_ENABLED=true`
   2. `KEY_ALIAS=key0`
   3. `STORE_FILE=keystore.jks`
   4. `KEY_PASSWORD=<key password>`
   5. `STORE_PASSWORD=<store password>`
2. Run `./gradlew :playground:assembleRelease`
3. The signed release APK will be generated at `playground/build/outputs/apk/release/`

## Tooling

### Enforcing a consistent code style

We use [Spotless](https://github.com/diffplug/spotless/tree/main/plugin-gradle) paired with [ktfmt](https://github.com/facebookincubator/ktfmt) to set up Kotlin code style for the entire project. Follow the steps for set up.

1. Install the [ktfmt IntelliJ plugin](https://plugins.jetbrains.com/plugin/14912-ktfmt) in Android Studio from Plugins Marketplace
2. The plugin will be disabled by default. Please enable it from the `Preferences -> Editor -> ktfmt Settings`
3. Apply `google` code style in `ktfmt Settings`

When set up, it will replace the normal `Reformat Code` action, which can be triggered from the `Code` menu or with the `Command+Option+L` (by default) keyboard shortcut.

`Spotless` also provides gradle tasks to check code formatting, which is already added to the `check` pipeline. Eg `./gradlew spotlessCheck` and `./gradlew spotlessApply`

### Ensuring binary compatibility across DLS releases

To prevent unintentional backward-incompatible API changes, we leverage Kotlin's [binary-compatibility-validator](https://github.com/Kotlin/binary-compatibility-validator) plugin to keep track of our current public API surface.

The user can execute the `./gradlew apiDump` task to update the existing API at `lib/api/lib.api` file.

### Dependency Guard

We use [Dependency Guard] to ensure that all changes to the DLS library's dependency tree are
validated in CI and can always be seen in a plaintext format. The available tasks are given here

- `dependencyGuardBaseline`: Captures the dependency tree and writes it out to a baseline file. This
should be run after every dependency change.
- `dependencyGuard`: Validation task that ensures your existing dependency baseline matches the
current dependency tree. Also run as part of `./gradlew check`

## Releasing

### GitHub Actions

Releasing the library is automated through GitHub Actions which will publish library artifacts
to the [GitHub Packages maven repository] and to [Firebase App Distribution].

See [RELEASING.md](./RELEASING.md)

[azul downloads]: https://www.azul.com/downloads/
[Android Studio]: https://developer.android.com/studio
[git pre-push hook]: https://git-scm.com/book/en/v2/Customizing-Git-Git-Hooks
[//]: # (TODO: Update the link to keystore signing credentials)
[here]: `<link-to-signing-credentials>`
[dependency guard]: https://github.com/dropbox/dependency-guard
[//]: # (TODO: Update the link to the packages repository)
[github packages maven repository]: `<link-to-repo-github-packages>`
[//]: # (TODO: Update the link to firebase app distribution)
[firebase app distribution]: `<link-to-app-distribution>`
