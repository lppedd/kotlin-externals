@file:Suppress("UnstableApiUsage")

plugins {
  id("module.vscode")
}

dependencies {
  jsMainImplementation(libs.kotlinx.coroutines.core)
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
