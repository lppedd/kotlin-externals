package vscode

/**
 * An event describing the change in Configuration
 */
external interface ConfigurationChangeEvent {
  /**
   * Checks if the given section has changed.
   * If scope is provided, checks if the section has changed for resources under the given scope.
   *
   * @param section Configuration name, supports _dotted_ names.
   * @param scope A scope in which to check.
   * @return `true` if the given section has changed.
   */
  fun affectsConfiguration(
    section: String,
    scope: Uri /* ConfigurationScope */ = definedExternally,
  ): Boolean

  /**
   * Checks if the given section has changed.
   * If scope is provided, checks if the section has changed for resources under the given scope.
   *
   * @param section Configuration name, supports _dotted_ names.
   * @param scope A scope in which to check.
   * @return `true` if the given section has changed.
   */
  fun affectsConfiguration(
    section: String,
    scope: TextDocument /* ConfigurationScope */ = definedExternally,
  ): Boolean

  /**
   * Checks if the given section has changed.
   * If scope is provided, checks if the section has changed for resources under the given scope.
   *
   * @param section Configuration name, supports _dotted_ names.
   * @param scope A scope in which to check.
   * @return `true` if the given section has changed.
   */
  fun affectsConfiguration(
    section: String,
    scope: WorkspaceFolder /* ConfigurationScope */ = definedExternally,
  ): Boolean

  /**
   * Checks if the given section has changed.
   * If scope is provided, checks if the section has changed for resources under the given scope.
   *
   * @param section Configuration name, supports _dotted_ names.
   * @param scope A scope in which to check.
   * @return `true` if the given section has changed.
   */
  fun affectsConfiguration(
    section: String,
    scope: Scope /* ConfigurationScope */ = definedExternally,
  ): Boolean
}
