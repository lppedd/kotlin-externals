@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.create.vsam

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all extra options to be used by the Create API
 */
external val VsamCreateOptions: Record<String, ICommandOptionDefinition>
