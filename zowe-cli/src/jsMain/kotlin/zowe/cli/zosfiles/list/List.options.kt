@file:JsModule("@zowe/cli")

package zowe.cli.zosfiles.list

import js.objects.Record
import zowe.imperative.cmd.doc.option.ICommandOptionDefinition

/**
 * Object containing all options to be used by the List data-set/member API
 */
external val ListOptions: Record<String, ICommandOptionDefinition>
