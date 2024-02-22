package zowe.explorer.api.globals

import vscode.MessageItem
import zowe.explorer.api.logger.MessageSeverity
import kotlin.ts.Union

sealed external interface GuiMessageOptions<T : Union<String, MessageItem>> : GuiMessageOptionsBase<T> {
  var severity: MessageSeverity?
}
