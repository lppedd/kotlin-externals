@file:Suppress("UnstableApiUsage")

plugins {
  id("module.vscode")
}

dependencies {
  jsMainImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
  jsMainImplementation(projects.shared)
}

vscodeExtension {
  packageJson {
    displayName("HelloWorld")
    description("My first extension")
    contributes {
      commands {
        command(id = "helloworld.helloWorld", title = "Hello World")
      }
    }
    activationEvents {
      onCommand("helloworld.helloWorld")
    }
  }
}
