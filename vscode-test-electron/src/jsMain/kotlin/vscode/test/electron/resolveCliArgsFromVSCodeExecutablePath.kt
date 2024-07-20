@file:JsModule("@vscode/test-electron")

package vscode.test.electron

/**
 * Resolve the VS Code cli arguments from executable path returned from `downloadAndUnzipVSCode`.
 * You can use this path to spawn processes for extension management. For example:
 *
 * ```ts
 * const cp = require('child_process');
 * const { downloadAndUnzipVSCode, resolveCliArgsFromVSCodeExecutablePath } = require('@vscode/test-electron')
 * const vscodeExecutablePath = await downloadAndUnzipVSCode('1.36.0');
 * const [cli, ...args] = resolveCliArgsFromVSCodeExecutablePath(vscodeExecutablePath);
 *
 * cp.spawnSync(cli, [...args, '--install-extension', '<EXTENSION-ID-OR-PATH-TO-VSIX>'], {
 *   encoding: 'utf-8',
 *   stdio: 'inherit',
 *   shell: process.platform === 'win32',
 * });
 * ```
 *
 * @param vscodeExecutablePath The `vscodeExecutablePath` from `downloadAndUnzipVSCode`.
 */
external fun resolveCliArgsFromVSCodeExecutablePath(
  vscodeExecutablePath: String,
  options: PickTestOptions = definedExternally,
): Array<String>
