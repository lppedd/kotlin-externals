package zowe.explorer.api.globals

import vscode.MessageItem
import vscode.Union
import zowe.explorer.api.logger.IZoweLogger

sealed external interface GuiMessageOptionsBase<T : Union<String, MessageItem>> {
  var items: Array<T>?
  var logger: IZoweLogger?
  var vsCodeOpts: vscode.MessageOptions?
}
