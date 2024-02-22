package vscode

external interface LanguageConfiguration__electricCharacterSupport {
/**
   * This property is deprecated and will be **ignored** from
   * the editor.
   * @deprecated
   */
  var brackets: Any?

/**
   * This property is deprecated and not fully supported anymore by
   * the editor (scope and lineStart are ignored).
   * Use the autoClosingPairs property in the language configuration file instead.
   * @deprecated
   */
  var docComment: (Temp2)?
}
