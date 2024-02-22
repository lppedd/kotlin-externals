@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.security

import js.promise.Promise
import zowe.imperative.logger.Logger

external class KeytarApi {
  constructor(log: Logger)

  var log: Logger

  fun activateKeytar(
    initialized: Boolean,
    _isTheia: Boolean,
  ): Promise<Unit>
}
