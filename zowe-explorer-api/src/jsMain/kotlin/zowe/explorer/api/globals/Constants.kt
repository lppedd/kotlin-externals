@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.globals

import vscode.JsInt
import vscode.JsString

@JsString("Zowe Explorer")
external val ZOWE_EXPLORER: String

@JsString("Zowe-Plugin")
external val SCS_ZOWE_PLUGIN: String

@JsString("Zowe")
external val SCS_ZOWE_CLI_V2: String

@JsString("@brightside/cor")
external val SCS_BRIGHTSIDE: String

@JsString("@zowe/cli")
external val SCS_ZOWE_CLI: String

@JsString("Broadcom-Plugin")
external val SCS_BROADCOM_PLUGIN: String

@JsString("Zowe")
external val SETTINGS_SCS_DEFAULT: String

@JsInt(500)
external val DOUBLE_CLICK_SPEED_MS: Int
