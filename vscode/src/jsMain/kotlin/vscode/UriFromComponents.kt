package vscode

external interface UriFromComponents {
  /**
   * The scheme of the uri
   */
  val scheme: String

  /**
   * The authority of the uri
   */
  val authority: String?

  /**
   * The path of the uri
   */
  val path: String?

  /**
   * The query string of the uri
   */
  val query: String?

  /**
   * The fragment identifier of the uri
   */
  val fragment: String?
}
