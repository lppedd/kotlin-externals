package zowe.imperative.settings.doc

/**
 * This interface defines the structure of the settings file.
 */
external interface ISettingsFile {
  /**
   * The overrides object determines which items will be used for any overrides in the overrides
   * loader. Overrides can come from the base cli or plugins.
   */
  // TODO(Edoardo): fix this mess
  var overrides: Any // ISettingsFileOverrides
}
