@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.edit

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all options to be used by the Edit API
 */
external val EditOptions: Record<String, ICommandOptionDefinition>
