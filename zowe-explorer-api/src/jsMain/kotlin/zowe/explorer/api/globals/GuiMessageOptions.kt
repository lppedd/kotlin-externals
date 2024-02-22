package zowe.explorer.api.globals

import vscode.Union
import zowe.explorer.api.logger.MessageSeverity

sealed external interface GuiMessageOptions<T : Union<String, vscode.MessageItem>> : GuiMessageOptionsBase<T> {
  var severity: MessageSeverity?
}
