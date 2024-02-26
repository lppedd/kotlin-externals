import com.github.lppedd.example.shared.registerCommand
import com.github.lppedd.example.shared.registerDisposable
import functions.dummyFunction
import js.errors.name
import kotlinx.coroutines.*
import util.ExtensionScope
import vscode.ExtensionContext
import vscode.window.showErrorMessage

@OptIn(DelicateCoroutinesApi::class)
@JsExport
fun activate(context: ExtensionContext) {
  val handler = CoroutineExceptionHandler { _, e ->
    val message = e.message ?: e.name.toString()
    showErrorMessage(message)
  }

  val scope = ExtensionScope("Example extension")
  context.registerDisposable(scope)

  val connectToHost = connectToHost(context)
  context.registerCommand("helloworld.helloWorld") {
    scope.launch(handler) {
      dummyFunction(connectToHost)
    }
  }

  // Dispose the socket pool once the extension is deactivated
  context.registerDisposable {
    GlobalScope.promise {
      println("Disposable")
    }
  }
}

private fun connectToHost(context: ExtensionContext): String? {
  println("connectToHost: $context")
  val configuration = getConfiguration()
  return configuration
}

private fun getConfiguration(): String? {
  val config = vscode.workspace.getConfiguration()
  val hostname = config.get<String>("hostname") ?: return null
  val username = config.get<String>("username") ?: return null
  val password = config.get<String>("password") ?: return null
  return "$hostname:$username:$password"
}
