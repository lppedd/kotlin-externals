@file:JsModule("@zowe/imperative")

package zowe.imperative.settings

import zowe.imperative.settings.doc.ISettingsFile
import zowe.imperative.settings.errors.SettingsNotInitialized
import zowe.imperative.settings.persistance.ISettingsFilePersistence

/**
 * This class represents settings for an Imperative CLI application that can be configured by an end
 * user by modifying a settings file. Settings are stored in [AppSettings.getSettings] in a
 * format specified by [ISettingsFile].
 */
external class AppSettings {
  /**
   * Constructs a new settings object
   *
   * @param persistence
   * @param initial Initial settings object
   */
  constructor(persistence: ISettingsFilePersistence, initial: ISettingsFile)

  /**
   * Set a settings option and save it to the settings file.
   *
   * @param namespace [ISettingsFile]
   * @param key Name of a setting option to set
   * @param value
   */
  fun set(
    namespace: SettingOption,
    key: String,
    value: `false`,
  )

  /**
   * Set a settings option and save it to the settings file.
   *
   * @param namespace [ISettingsFile]
   * @param key Name of a setting option to set
   * @param value
   */
  fun set(
    namespace: SettingOption,
    key: String,
    value: String,
  )

  /**
   * Get a value of settings option
   *
   * @param namespace [ISettingsFile]
   * @param key Name of a setting option to set
   */
  fun get(
    namespace: SettingOption,
    key: String,
  ): SettingValue

  /**
   * Get a member of [ISettingsFile] of specified namespace
   *
   * @param namespace
   */
  fun getNamespace(namespace: SettingOption): AppSettingsGetNamespaceResult

  /**
   * Get settings
   */
  fun getSettings(): ISettingsFile

  companion object {
    /**
     * Initialize
     *
     * @param settingsFile The settings file to load from
     * @param defaults {@link ISettingsFile} Settings with default values
     */
    fun initialize(
      settingsFile: String,
      defaults: ISettingsFile,
    ): AppSettings

    /**
     * Get the singleton instance of the app settings object that was initialized within the
     * [AppSettings.initialize] function.
     *
     * @return A singleton AppSettings object
     * @throws SettingsNotInitialized When the settings singleton has not been initialized.
     */
    val instance: AppSettings

    /**
     * @return true if the app settings have been initialized
     */
    val initialized: Boolean
  }
}
