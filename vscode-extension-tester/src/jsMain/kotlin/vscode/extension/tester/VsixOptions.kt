package vscode.extension.tester

external interface VsixOptions {
  var vsixFile: String?
  var useYarn: Boolean?
  var installDependencies: Boolean?
}
