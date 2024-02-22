package vscode.l10n

import js.objects.Record
import vscode.Union
import vscode.Union3

external interface Options {
  /**
   * The message to localize. If [args] is an array, this message supports index templating where strings like
   * `{0}` and `{1}` are replaced by the item at that index in the [args] array. If `args` is a `Record<string, any>`,
   * this supports named templating where strings like `{foo}` and `{bar}` are replaced by the value in
   * the Record for that key (foo, bar, etc).
   */
  var message: String

  /**
   * The arguments to be used in the localized string. As an array, the index of the argument is used to
   * match the template placeholder in the localized string. As a Record, the key is used to match the template
   * placeholder in the localized string.
   */
  var args: Union<Array<Union3<String, Number, Boolean>>, Record<String, Any?>>? // Array<string | number | boolean> | Record<string, any>

  /**
   * A comment to help translators understand the context of the message.
   */
  var comment: Union<String, Array<String>> // string | string[]
}
