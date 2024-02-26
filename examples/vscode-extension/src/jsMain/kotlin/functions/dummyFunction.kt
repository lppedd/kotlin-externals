package functions

import vscode.window.showInformationMessage

@Suppress("RedundantSuspendModifier")
suspend fun dummyFunction(connectToHost: String?) {
  showInformationMessage("Hello World! $connectToHost")
}
