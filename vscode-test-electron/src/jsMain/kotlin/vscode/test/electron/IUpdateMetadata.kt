package vscode.test.electron

external interface IUpdateMetadata {
  var url: String
  var name: String
  var version: String
  var productVersion: String
  var hash: String
  var timestamp: Int
  var sha256hash: String
  var supportsFastUpdate: Boolean
}
