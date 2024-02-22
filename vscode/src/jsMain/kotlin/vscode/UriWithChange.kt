package vscode

external interface UriWithChange {
  /**
   * The new scheme, defaults to this Uri's scheme.
   */
  var scheme: String?

  /**
   * The new authority, defaults to this Uri's authority.
   */
  var authority: String?

  /**
   * The new path, defaults to this Uri's path.
   */
  var path: String?

  /**
   * The new query, defaults to this Uri's query.
   */
  var query: String?

  /**
   * The new fragment, defaults to this Uri's fragment.
   */
  var fragment: String?
}
