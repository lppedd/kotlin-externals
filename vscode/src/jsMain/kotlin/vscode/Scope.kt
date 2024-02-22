package vscode

external interface Scope {
  /**
   * The uri of a [TextDocument]
   */
  var uri: Uri?

  /**
   * The language of a text document
   */
  var languageId: String
}
