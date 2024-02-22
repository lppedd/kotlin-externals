package vscode

/**
 * Represents the configuration. It is a merged view of
 *
 * - *Default Settings*
 * - *Global (User) Settings*
 * - *Workspace settings*
 * - *Workspace Folder settings* - From one of the [vscode.workspace.workspaceFolders] under which requested resource belongs to.
 * - *Language settings* - Settings defined under requested language.
 *
 * The *effective* value (returned by [WorkspaceConfiguration.get]) is computed by overriding or merging the values in the following order:
 *
 * 1. `defaultValue` (if defined in `package.json` otherwise derived from the value's type)
 * 1. `globalValue` (if defined)
 * 1. `workspaceValue` (if defined)
 * 1. `workspaceFolderValue` (if defined)
 * 1. `defaultLanguageValue` (if defined)
 * 1. `globalLanguageValue` (if defined)
 * 1. `workspaceLanguageValue` (if defined)
 * 1. `workspaceFolderLanguageValue` (if defined)
 *
 * **Note:** Only `object` value types are merged and all other value types are overridden.
 *
 * Example 1: Overriding
 *
 * ```ts
 * defaultValue = 'on';
 * globalValue = 'relative'
 * workspaceFolderValue = 'off'
 * value = 'off'
 * ```
 *
 * Example 2: Language Values
 *
 * ```ts
 * defaultValue = 'on';
 * globalValue = 'relative'
 * workspaceFolderValue = 'off'
 * globalLanguageValue = 'on'
 * value = 'on'
 * ```
 *
 * Example 3: Object Values
 *
 * ```ts
 * defaultValue = { "a": 1, "b": 2 };
 * globalValue = { "b": 3, "c": 4 };
 * value = { "a": 1, "b": 3, "c": 4 };
 * ```
 *
 * *Note:* Workspace and Workspace Folder configurations contains `launch` and `tasks` settings. Their basename will be
 * part of the section identifier. The following snippets shows how to retrieve all configurations
 * from `launch.json`:
 *
 * ```ts
 * // launch.json configuration
 * const config = workspace.getConfiguration('launch', vscode.workspace.workspaceFolders[0].uri);
 *
 * // retrieve values
 * const values = config.get('configurations');
 * ```
 *
 * Refer to [Settings](https://code.visualstudio.com/docs/getstarted/settings) for more information.
 */
external interface WorkspaceConfiguration {
  /**
   * Return a value from this configuration.
   *
   * @param section Configuration name, supports _dotted_ names.
   * @return The value `section` denotes or `undefined`.
   */
  fun <T> get(section: String): T?

  /**
   * Return a value from this configuration.
   *
   * @param section Configuration name, supports _dotted_ names.
   * @param defaultValue A value should be returned when no value could be found, is `undefined`.
   * @return The value `section` denotes or the default.
   */
  fun <T> get(
    section: String,
    defaultValue: T,
  ): T

  /**
   * Check if this configuration has a certain value.
   *
   * @param section Configuration name, supports _dotted_ names.
   * @return `true` if the section doesn't resolve to `undefined`.
   */
  fun has(section: String): Boolean

  /**
   * Retrieve all information about a configuration setting. A configuration value
   * often consists of a *default* value, a global or installation-wide value,
   * a workspace-specific value, folder-specific value
   * and language-specific values (if [WorkspaceConfiguration] is scoped to a language).
   *
   * Also provides all language ids under which the given configuration setting is defined.
   *
   * *Note:* The configuration name must denote a leaf in the configuration tree
   * (`editor.fontSize` vs `editor`) otherwise no result is returned.
   *
   * @param section Configuration name, supports _dotted_ names.
   * @return Information about a configuration setting or `undefined`.
   */
  fun <T> inspect(section: String): ConfigurationSettings<T>?

  /**
   * Update a configuration value. The updated configuration values are persisted.
   *
   * A value can be changed in
   *
   * - [ConfigurationTarget.Global]: Changes the value for all instances of the editor.
   * - [ConfigurationTarget.Workspace]: Changes the value for current workspace, if available.
   * - [ConfigurationTarget.WorkspaceFolder]: Changes the value for settings from one of the [vscode.workspace.workspaceFolders] under which the requested resource belongs to.
   * - Language settings: Changes the value for the requested languageId.
   *
   * *Note:* To remove a configuration value use `undefined`, like so: `config.update('somekey', undefined)`
   *
   * @param section Configuration name, supports _dotted_ names.
   * @param value The new value.
   * @param configurationTarget The [ConfigurationTarget] or a boolean value.
   *	 - If `true` updates [ConfigurationTarget.Global].
   *	 - If `false` updates [ConfigurationTarget.Workspace].
   *	 - If `undefined` or `null` updates to [ConfigurationTarget.WorkspaceFolder] if configuration is resource specific,
   * 	   otherwise to [ConfigurationTarget.Workspace].
   * @param overrideInLanguage Whether to update the value in the scope of requested languageId or not.
   *	 - If `true` updates the value under the requested languageId.
   *	 - If `undefined` updates the value under the requested languageId only if the configuration is defined for the language.
   * @throws error while updating
   *	 - configuration which is not registered.
   *	 - window configuration to workspace folder
   *	 - configuration to workspace or workspace folder when no workspace is opened.
   *	 - configuration to workspace folder when there is no workspace folder settings.
   *	 - configuration to workspace folder when [WorkspaceConfiguration] is not scoped to a resource.
   */
  fun update(
    section: String,
    value: Any?,
    configurationTarget: ConfigurationTarget? = definedExternally,
    overrideInLanguage: Boolean = definedExternally,
  ): Thenable<Unit>

  /**
   * Update a configuration value. The updated configuration values are persisted.
   *
   * A value can be changed in
   *
   * - [ConfigurationTarget.Global]: Changes the value for all instances of the editor.
   * - [ConfigurationTarget.Workspace]: Changes the value for current workspace, if available.
   * - [ConfigurationTarget.WorkspaceFolder]: Changes the value for settings from one of the [vscode.workspace.workspaceFolders] under which the requested resource belongs to.
   * - Language settings: Changes the value for the requested languageId.
   *
   * *Note:* To remove a configuration value use `undefined`, like so: `config.update('somekey', undefined)`
   *
   * @param section Configuration name, supports _dotted_ names.
   * @param value The new value.
   * @param configurationTarget The [ConfigurationTarget] or a boolean value.
   *	 - If `true` updates [ConfigurationTarget.Global].
   *	 - If `false` updates [ConfigurationTarget.Workspace].
   *	 - If `undefined` or `null` updates to [ConfigurationTarget.WorkspaceFolder] if configuration is resource specific,
   * 	   otherwise to [ConfigurationTarget.Workspace].
   * @param overrideInLanguage Whether to update the value in the scope of requested languageId or not.
   *	 - If `true` updates the value under the requested languageId.
   *	 - If `undefined` updates the value under the requested languageId only if the configuration is defined for the language.
   * @throws error while updating
   *	 - configuration which is not registered.
   *	 - window configuration to workspace folder
   *	 - configuration to workspace or workspace folder when no workspace is opened.
   *	 - configuration to workspace folder when there is no workspace folder settings.
   *	 - configuration to workspace folder when [WorkspaceConfiguration] is not scoped to a resource.
   */
  fun update(
    section: String,
    value: Any?,
    configurationTarget: Boolean? = definedExternally,
    overrideInLanguage: Boolean = definedExternally,
  ): Thenable<Unit>

  /**
   * Readable dictionary that backs this configuration.
   */
  @seskar.js.JsNative
  operator fun get(key: String): Any?
}
