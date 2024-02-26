package com.github.lppedd.kotlin.gradle.vscode

import org.jetbrains.kotlin.gradle.targets.js.npm.PackageJson

@DslMarker
annotation class VSCodeExtensionDsl

@VSCodeExtensionDsl
class VSCodeExtension(private val map: MutableMap<String, Any?>) {
  /**
   * The display name for the extension used in the VS Code gallery.
   */
  fun displayName(displayName: String) {
    map["displayName"] = displayName
  }

  /**
   * TODO
   */
  fun description(description: String) {
    map["description"] = description
  }

  /**
   * The categories used by the VS Code gallery to categorize the extension.
   */
  fun categories(categories: List<String>) {
    map["categories"] = categories
  }

  /**
   * A person who has been involved in creating or maintaining this package.
   */
  fun author(name: String, init: Author.() -> Unit = {}) {
    val author = Author().apply(init)
    map["author"] = buildMap {
      putIfNotNull("name", name)
      putIfNotNull("email", author.email)
      putIfNotNull("url", author.url)
    }
  }

  /**
   * All contributions of the VS Code extension represented by this package.
   */
  fun contributes(init: Contributes.() -> Unit) {
    map["contributes"] = buildMap {
      Contributes(this).init()
    }
  }

  /**
   * TODO
   */
  fun activationEvents(init: ActivationEvents.() -> Unit) {
    map["activationEvents"] = buildSet {
      ActivationEvents(this).init()
    }
  }
}

@VSCodeExtensionDsl
class ActivationEvents(private val list: MutableSet<String>) {
  fun onCommand(event: String) {
    list.add("onCommand:$event")
  }
}

class Author {
  var email: String? = null
  var url: String? = null
}

@VSCodeExtensionDsl
class Contributes(private val contributes: MutableMap<String, Any?>) {
  /**
   * Contributes configuration settings.
   */
  fun configuration(init: Configuration.() -> Unit) {
    contributes["configuration"] = buildMap {
      val configuration = Configuration(this).apply(init)
      putIfNotNull("title", configuration.title)
      putIfNotNull("order", configuration.order)
    }
  }

  /**
   * Contributes commands to the command palette.
   */
  fun commands(init: Commands.() -> Unit) {
    contributes["commands"] = buildList {
      Commands(this).init()
    }
  }

  /**
   * Contributes menu items to the editor.
   */
  fun menus(init: Menus.() -> Unit) {
    contributes["menus"] = buildMap {
      Menus(this).init()
    }
  }
}

@VSCodeExtensionDsl
class Configuration(private val map: MutableMap<String, Any?>) {
  /**
   * A title for the current category of settings.
   * This label will be rendered in the Settings editor as a subheading.
   * If the title is the same as the extension display name,
   * then the category will be grouped under the main extension heading.
   */
  var title: String? = null

  /**
   * When specified, gives the order of this category of settings relative to other categories.
   */
  var order: Int? = null

  /**
   * Description of the configuration properties.
   */
  fun properties(init: Properties.() -> Unit) {
    val propertiesMap = mutableMapOf<String, Map<String, Any?>>()
    map["properties"] = propertiesMap
    Properties(propertiesMap).init()
  }
}

@VSCodeExtensionDsl
class Commands(private val list: MutableList<Map<String, Any?>>) {
  /**
   * @param id Identifier of the command to execute.
   * @param title Title by which the command is represented in the UI.
   */
  fun command(id: String, title: String, init: Command.() -> Unit = {}) {
    val command = Command().apply(init)
    list.add(buildMap {
      putIfNotNull("command", id)
      putIfNotNull("title", title)
      putIfNotNull("category", command.category)
      putIfNotNull("icon", command.icon)
    })
  }
}

@VSCodeExtensionDsl
class Command {
  /**
   * Category string by which the command is grouped in the UI.
   */
  var category: String? = null

  /**
   * Icon which is used to represent the command in the UI.
   * Either a file path, an object with file paths for dark and light themes,
   * or a theme icon references, like `$(zap)`.
   */
  var icon: String? = null
}

@VSCodeExtensionDsl
class Properties(private val map: MutableMap<String, Map<String, Any?>>) {
  fun property(id: String, init: Property.() -> Unit) {
    val property = Property().apply(init)
    map[id] = buildMap {
      val types = property.type?.split(",")?.map(String::trim)

      if (types != null) {
        putIfNotNull("type", if (types.size == 1) types[0] else types)
      }

      putIfNotNull("default", property.default)
      putIfNotNull("description", property.description)
    }
  }
}

@VSCodeExtensionDsl
class Property {
  /**
   * Either a string of one of the basic schema types (number, integer, null, array, object, boolean, string)
   * or an array of strings specifying a subset of those types.
   */
  var type: String? = null

  /**
   * A default value. Used by suggestions.
   */
  var default: String? = null

  /**
   * A long description of the element. Used in hover menus and suggestions.
   */
  var description: String? = null
}

@VSCodeExtensionDsl
class Menus(private val map: MutableMap<String, Any?>) {
  fun menu(path: String, init: MenuItems.() -> Unit) {
    map[path] = buildList {
      MenuItems(this).init()
    }
  }
}

@VSCodeExtensionDsl
class MenuItems(private val list: MutableList<Map<String, Any?>>) {
  fun menuItem(init: MenuItem.() -> Unit) {
    val menuItem = MenuItem().apply(init)
    list.add(buildMap {
      putIfNotNull("command", menuItem.commandId)
      putIfNotNull("when", menuItem.condition)
      putIfNotNull("group", menuItem.group)
    })
  }
}

@VSCodeExtensionDsl
class MenuItem {
  /**
   * Identifier of the command to execute.
   * The command must be declared in the 'commands'-section.
   */
  var commandId: String? = null

  /**
   * Condition which must be true to show this item.
   */
  var condition: String? = null

  /**
   * Group into which this item belongs.
   */
  var group: String? = null
}

// Entry point for the DSL
fun PackageJson.vscode(version: String, init: VSCodeExtension.() -> Unit) {
  val map = mutableMapOf<String, Any?>()
  map["categories"] = listOf("Other")

  VSCodeExtension(map).init()

  for (entry in map) {
    customField(entry.key, entry.value)
  }

  customField("engines", mapOf("vscode" to version))
}

private fun <K, V> MutableMap<K, V>.putIfNotNull(key: K, value: V) {
  if (value != null) {
    this[key] = value
  }
}
