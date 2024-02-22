package zowe.imperative.utilities.doc

external interface IOptionFormat {
  /**
   * The camel cased format of an option.
   *
   * Example:
   * ---
   * this-is-a-test -> thisIsATest
   */
  var camelCase: String

  /**
   * The kebab cased format of an option key
   *
   * Example:
   * ---
   * thisIsATest -> this-is-a-test
   */
  var kebabCase: String

  /**
   * The untouched original key.
   *
   * Example:
   * ---
   * thisIsATest-test-here -> thisIsATest-test-here
   *
   * camelCase: thisIsATestTestHere kebabCase: this-is-a-test-test-here
   */
  var key: String
}
