@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.view

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all options to be used by the View API
 */
external val ViewOptions: Record<String, ICommandOptionDefinition>
