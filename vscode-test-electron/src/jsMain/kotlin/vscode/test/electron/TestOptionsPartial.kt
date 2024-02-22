package vscode.test.electron

external interface TestOptionsPartial {
  /**
   * Whether VS Code should be launched using default settings and extensions
   * installed on this machine. If `false`, then separate directories will be
   * used inside the `.vscode-test` folder within the project.
   *
   * Defaults to `false`.
   */
  var reuseMachineInstall: Boolean?

  /**
   * The VS Code platform to download. If not specified, it defaults to the
   * current platform.
   *
   * Possible values are:
   * 	- `win32-x64-archive`
   * 	- `win32-arm64-archive		`
   * 	- `darwin`
   * 	- `darwin-arm64`
   * 	- `linux-x64`
   * 	- `linux-arm64`
   * 	- `linux-armhf`
   */
  var platform: DownloadPlatform?
}
