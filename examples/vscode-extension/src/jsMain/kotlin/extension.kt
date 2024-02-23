import vscode.ExtensionContext
import vscode.commands.registerCommand
import vscode.window.showInformationMessage

// The entry point for the extension.
//
// We must use JsExport as VS Code looks for top level
// functions specifically named "activate" and "deactivate"

@JsExport
fun activate(context: ExtensionContext) {
  println("Extension activated!")

  val disposable = registerCommand("helloworld.helloWorld", {
    showInformationMessage("Hello World!")
  })

  context.subscriptions.push(disposable)
}

@JsExport
fun deactivate() {
  println("Extension deactivated!")
}
