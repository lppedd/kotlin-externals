package vscode

import kotlin.js.RegExp

/**
 * The language configuration interfaces defines the contract between extensions
 * and various editor features, like automatic bracket insertion, automatic indentation etc.
 */
external interface LanguageConfiguration {
  /**
   * The language's comment settings.
   */
  var comments: CommentRule?

  /**
   * The language's brackets.
   * This configuration implicitly affects pressing Enter around these brackets.
   */
  var brackets: Array<CharacterPair>?

  /**
   * The language's word definition.
   * If the language supports Unicode identifiers (e.g. JavaScript), it is preferable
   * to provide a word definition that uses exclusion of known separators.
   *
   * e.g.: A regex that matches anything except known separators (and dot is allowed to occur in a floating point number):
   * ```
   * /(-?\d*\.\d\w*)|([^\`\~\!\@\#\%\^\&\*\(\)\-\=\+\[\{\]\}\\\|\;\:\'\"\,\.\<\>\/\?\s]+)/g
   * ```
   */
  var wordPattern: RegExp?

  /**
   * The language's indentation settings.
   */
  var indentationRules: IndentationRule?

  /**
   * The language's rules to be evaluated when pressing Enter.
   */
  var onEnterRules: Array<OnEnterRule>?

  /**
   * The language's auto closing pairs.
   */
  var autoClosingPairs: Array<AutoClosingPair>?

  /**
   * **Deprecated** Do not use.
   */
  @Deprecated("Will be replaced by a better API soon")
  var __electricCharacterSupport: ElectricCharacterSupport?

  /**
   * **Deprecated** Do not use.
   */
  @Deprecated("Use the autoClosingPairs property in the language configuration file instead")
  var __characterPairSupport: CharacterPairSupport?
}
