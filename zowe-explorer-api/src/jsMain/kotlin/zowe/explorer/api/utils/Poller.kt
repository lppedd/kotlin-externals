@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.utils

import js.objects.Record

external class Poller {
  companion object {
    var pollRequests: Record<String, PollRequest>

    fun addRequest(
      uniqueId: String,
      request: PollRequest,
    )

    fun removeRequest(uniqueId: String)
  }
}
