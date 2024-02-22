@file:JsModule("vscode")

package vscode

import js.array.ReadonlyArray

/**
 * A snippet string is a template which allows to insert text
 * and to control the editor cursor when insertion happens.
 *
 * A snippet can define tab stops and placeholders with `$1`, `$2`
 * and `${3:foo}`. `$0` defines the final tab stop, it defaults to
 * the end of the snippet. Variables are defined with `$name` and
 * `${name:default value}`. Also see
 * [the full snippet syntax](https://code.visualstudio.com/docs/editor/userdefinedsnippets#_create-your-own-snippets).
 */
external class SnippetString {
  /**
   * Create a new snippet string.
   *
   * @param value A snippet string.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(value: String = definedExternally)

  /**
   * The snippet string.
   */
  var value: String

  /**
   * Builder-function that appends the given string to
   * the [value] of this snippet string.
   *
   * @param string A value to append 'as given'. The string will be escaped.
   * @return This snippet string.
   */
  fun appendText(string: String): SnippetString

  /**
   * Builder-function that appends a tabstop (`$1`, `$2` etc) to
   * the [value] of this snippet string.
   *
   * @param number The number of this tabstop, defaults to an auto-increment
   *   value starting at 1.
   * @return This snippet string.
   */
  fun appendTabstop(number: Int = definedExternally): SnippetString

  /**
   * Builder-function that appends a placeholder (`${1:value}`) to
   * the [value] of this snippet string.
   *
   * @param value The value of this placeholder - either a string or a function
   *   with which a nested snippet can be created.
   * @param number The number of this tabstop, defaults to an auto-increment
   *   value starting at 1.
   * @return This snippet string.
   */
  fun appendPlaceholder(
    value: String,
    number: Int = definedExternally,
  ): SnippetString

  /**
   * Builder-function that appends a placeholder (`${1:value}`) to
   * the [value] of this snippet string.
   *
   * @param value The value of this placeholder - either a string or a function
   *   with which a nested snippet can be created.
   * @param number The number of this tabstop, defaults to an auto-increment
   *   value starting at 1.
   * @return This snippet string.
   */
  fun appendPlaceholder(
    value: (snippet: SnippetString) -> Any?,
    number: Int = definedExternally,
  ): SnippetString

  /**
   * Builder-function that appends a choice (`${1|a,b,c|}`) to
   * the [value] of this snippet string.
   *
   * @param values The values for choices - the array of strings
   * @param number The number of this tabstop, defaults to an auto-increment
   *   value starting at 1.
   * @return This snippet string.
   */
  fun appendChoice(
    values: ReadonlyArray<String>,
    number: Int = definedExternally,
  ): SnippetString

  /**
   * Builder-function that appends a variable (`${VAR}`) to
   * the [value] of this snippet string.
   *
   * @param name The name of the variable - excluding the `$`.
   * @param defaultValue The default value which is used when the variable name cannot
   *   be resolved - either a string or a function with which a nested snippet can be created.
   * @return This snippet string.
   */
  fun appendVariable(
    name: String,
    defaultValue: String,
  ): SnippetString

  /**
   * Builder-function that appends a variable (`${VAR}`) to
   * the [value] of this snippet string.
   *
   * @param name The name of the variable - excluding the `$`.
   * @param defaultValue The default value which is used when the variable name cannot
   *   be resolved - either a string or a function with which a nested snippet can be created.
   * @return This snippet string.
   */
  fun appendVariable(
    name: String,
    defaultValue: (snippet: SnippetString) -> Any?,
  ): SnippetString
}
