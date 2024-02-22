package vscode

external interface ConfigurationSettings<T> {
  /**
   * The fully qualified key of the configuration value
   */
  var key: String

  /**
   * The default value which is used when no other value is defined
   */
  var defaultValue: T?

  /**
   * The global or installation-wide value.
   */
  var globalValue: T?

  /**
   * The workspace-specific value.
   */
  var workspaceValue: T?

  /**
   * The workspace-folder-specific value.
   */
  var workspaceFolderValue: T?

  /**
   * Language specific default value when this configuration value is created for a language scope ([ConfigurationScope]).
   */
  var defaultLanguageValue: T?

  /**
   * Language specific global value when this configuration value is created for a language scope ([ConfigurationScope]).
   */
  var globalLanguageValue: T?

  /**
   * Language specific workspace value when this configuration value is created for a language scope ([ConfigurationScope]).
   */
  var workspaceLanguageValue: T?

  /**
   * Language specific workspace-folder value when this configuration value is created for a language scope ([ConfigurationScope]).
   */
  var workspaceFolderLanguageValue: T?

  /**
   * All language identifiers for which this configuration is defined.
   */
  var languageIds: Array<String>?
}
