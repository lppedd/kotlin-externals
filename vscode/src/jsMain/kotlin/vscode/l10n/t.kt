@file:JsModule("vscode")
@file:JsQualifier("l10n")

package vscode.l10n

import js.objects.Record
import kotlin.ts.Union3

/**
 * Marks a string for localization. If a localized bundle is available for the language specified by
 * [vscode.env.language] and the bundle has a localized value for this message, then that localized
 * value will be returned (with injected [args] values for any templated values).
 *
 * Example:
 * ```ts
 * l10n.t('Hello {0}!', 'World');
 * ```
 *
 * @param message The message to localize. Supports index templating where strings like `{0}` and `{1}` are
 *   replaced by the item at that index in the [args] array.
 * @param args The arguments to be used in the localized string. The index of the argument is used to
 *   match the template placeholder in the localized string.
 * @return localized string with injected arguments.
 */
external fun t(message: String, vararg args: Union3<String, Number, Boolean> /* string | number | boolean */): String

/**
 * Marks a string for localization. If a localized bundle is available for the language specified by
 * [vscode.env.language] and the bundle has a localized value for this message, then that localized
 * value will be returned (with injected [args] values for any templated values).
 *
 * Example:
 * ```ts
 * l10n.t('Hello {name}', { name: 'Erich' });
 * ```
 *
 * @param message The message to localize. Supports named templating where strings like `{foo}` and `{bar}` are
 *   replaced by the value in the Record for that key (foo, bar, etc.).
 * @param args The arguments to be used in the localized string. The name of the key in the record is used to
 *   match the template placeholder in the localized string.
 * @return localized string with injected arguments.
 */
external fun t(
  message: String,
  args: Record<String, Any?>,
): String

/**
 * Marks a string for localization. If a localized bundle is available for the language specified by
 * [vscode.env.language] and the bundle has a localized value for this message, then that localized
 * value will be returned (with injected args values for any templated values).
 *
 * @param options The options to use when localizing the message.
 * @return localized string with injected arguments.
 */
external fun t(options: Options): String
