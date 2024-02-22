package zowe.imperative.utilities.diff.doc

/**
 * Web diff genrator API that handles genration of web diff base launcher at cli home dir
 */
external interface IWebDiffGenerator<T> {
  /**
   * build the diff generator
   */
  fun buildDiffDir(): T
}
