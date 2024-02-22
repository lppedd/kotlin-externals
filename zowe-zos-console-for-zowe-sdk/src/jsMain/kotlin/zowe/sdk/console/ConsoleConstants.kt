@file:JsModule("@zowe/zos-console-for-zowe-sdk")

package zowe.sdk.console

import zowe.imperative.messages.doc.IMessageDefinition

external class ConsoleConstants {
  companion object {
    val CLASS: String
    val RESOURCE: String
    val RES_DEF_CN: String
    val SOL_MSGS: String
    val DEFAULT_FOLLOWUP_ATTEMPTS: Int
    val DEFAULT_TIMEOUT: Int
  }
}

external val displayResponse: IMessageDefinition

external val displayError: IMessageDefinition

external val displayCollectResponse: IMessageDefinition

external val displayCollectError: IMessageDefinition

external val decreaseCounter: IMessageDefinition

external val resetCounter: IMessageDefinition

external val noZosmfInput: IMessageDefinition

external val noConsoleInput: IMessageDefinition

external val noConsoleName: IMessageDefinition

external val noCommandKey: IMessageDefinition

external val noCollectParameters: IMessageDefinition

external val collectProcessingDetails: IMessageDefinition
