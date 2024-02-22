@file:JsModule("@zowe/zos-uss-for-zowe-sdk")

package zowe.sdk.uss.constants

import js.objects.Record
import zowe.imperative.messages.doc.IMessageDefinition

/**
 * Messages to be used as command responses for different scenarios
 */
external val ZosUssMessages: Record<String, IMessageDefinition>
