package vscode

external interface ElectricCharacterSupport {
  /**
   * This property is deprecated and will be **ignored** from
   * the editor.
   */
  @Deprecated("")
  var brackets: Any?

  /**
   * This property is deprecated and not fully supported anymore by
   * the editor (scope and lineStart are ignored).
   * Use the autoClosingPairs property in the language configuration file instead.
   */
  @Deprecated("")
  var docComment: DeprecatedDocComment?
}
