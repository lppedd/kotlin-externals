@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.download

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all options to be used by the Download data set API
 */
external val DownloadOptions: Record<String, ICommandOptionDefinition>
