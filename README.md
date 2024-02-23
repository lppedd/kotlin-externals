# kotlin-externals

Additional Kotlin externals for a variety of JS libraries.

### Initial generation

Unlike what you may find under [kotlin-wrappers][1], our externals are not entirely auto-generated.
Usually:

1. An initial generation is done with [Karakum][2]. The project may not compile at this point.
2. A formatting round is done with the IntelliJ IDEA formatter
3. An additional formatting round is done with Ktlint
4. Each file is manually reviewed and adjusted

### Updates

Each project keeps the collection of `.d.ts` files used for the Kotlin sources generation process.

When a npm library version is bumped under `gradle.properties`, the task

```
./gradlew :project-name:copyTsDeclarations
```

is run.

At this point the updates to the TypeScript declarations will be highlighted
in the VCS changes, allowing us to manually port them to the Kotlin sources.

[1]: https://github.com/JetBrains/kotlin-wrappers
[2]: https://github.com/karakum-team/karakum
