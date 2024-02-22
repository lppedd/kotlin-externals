@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.compare

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all options to be used by the Compare API
 */
external val CompareOptions: Record<String, ICommandOptionDefinition>
