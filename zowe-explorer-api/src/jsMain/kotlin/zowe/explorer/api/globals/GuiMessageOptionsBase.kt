package zowe.explorer.api.globals

import vscode.MessageItem
import zowe.explorer.api.logger.IZoweLogger
import kotlin.ts.Union

sealed external interface GuiMessageOptionsBase<T : Union<String, MessageItem>> {
  var items: Array<T>?
  var logger: IZoweLogger?
  var vsCodeOpts: vscode.MessageOptions?
}
