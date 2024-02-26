package util

import kotlinx.coroutines.*
import vscode.IDisposable
import kotlin.coroutines.CoroutineContext

class ExtensionScope(debugName: String) : CoroutineScope, IDisposable {
  override val coroutineContext: CoroutineContext =
    SupervisorJob() + Dispatchers.Main.immediate + CoroutineName("$debugName-scope")

  override fun dispose() =
    coroutineContext.cancelChildren()

  override fun toString(): String =
    "ExtensionScope{coroutineContext=$coroutineContext}"
}
