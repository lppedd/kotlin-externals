package zowe.imperative.config.doc

import js.objects.Record
import kotlin.js.plain.JsPlainObject

/**
 * This type corresponds to the `extenders.json` file stored in the CLI home directory.
 *
 * Here is an example structure of what `extenders.json` could look like on disk:
 * ```json
 * {
 *     "profileTypes": {
 *         "banana": {
 *             "from": ["@zowe/banana-for-zowe-cli", "Zowe Explorer Banana Extension"],
 *             "version": "v1.1.0",
 *             "latestFrom": "Zowe Explorer Banana Extension"
 *         }
 *     }
 * }
 * ```
 */
@JsPlainObject
external interface IExtendersJsonOpts {
  var profileTypes: Record<String, ProfileType>
}
