@file:JsModule("@vscode/test-electron")

package vscode.test.electron

/**
 * Resolve the VS Code cli path from executable path returned from `downloadAndUnzipVSCode`.
 * Usually you will want [resolveCliArgsFromVSCodeExecutablePath] instead.
 */
external fun resolveCliPathFromVSCodeExecutablePath(
  vscodeExecutablePath: String,
  platform: DownloadPlatform = definedExternally,
): String
