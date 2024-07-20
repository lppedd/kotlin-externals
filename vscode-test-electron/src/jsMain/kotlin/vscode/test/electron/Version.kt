@file:JsModule("@vscode/test-electron")

package vscode.test.electron

external class Version {
  constructor(id: String, isReleased: Boolean = definedExternally)

  val id: String
  val isReleased: Boolean
  val isCommit: Boolean
  val isInsiders: Boolean
  val isStable: Boolean

  companion object {
    fun parse(version: String): Version
  }
}
