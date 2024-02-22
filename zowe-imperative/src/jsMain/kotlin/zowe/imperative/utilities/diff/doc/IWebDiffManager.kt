package zowe.imperative.utilities.diff.doc

/**
 * Web diff manager API that handles launching of web diff and generating it if necessary.
 */
external interface IWebDiffManager<T> {
  /**
   * launch the diff of two file in web
   *
   * @param content Html content string to launch in web
   */
  fun openDiffs(content: String): T
}
