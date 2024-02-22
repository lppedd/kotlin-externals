@file:JsModule("@zowe/cli")

package zowe.cli.zosmf.constants

import js.objects.Record
import zowe.imperative.messages.doc.IMessageDefinition

/**
 * Messages displayed by the zosmf check status command
 */
external val CheckStatusMessages: Record<String, IMessageDefinition>
