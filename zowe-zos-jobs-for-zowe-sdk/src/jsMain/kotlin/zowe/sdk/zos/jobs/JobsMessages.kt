@file:JsModule("@zowe/zos-jobs-for-zowe-sdk")

package zowe.sdk.zos.jobs

import js.objects.Record
import zowe.imperative.messages.doc.IMessageDefinition

/**
 * Messages to be used as command responses for different scenarios
 */
external val ZosJobsMessages: Record<String, IMessageDefinition>
