@file:JsModule("vscode")

package vscode

/**
 * An event emitter can be used to create and manage an [Event] for others
 * to subscribe to. One emitter always owns one event.
 *
 * Use this class if you want to provide event from within your extension, for instance
 * inside a [TextDocumentContentProvider] or when providing
 * API to other extensions.
 */
external class EventEmitter<T> {
  /**
   * The event listeners can subscribe to.
   */
  var event: Event<T>

  /**
   * Notify all subscribers of the [EventEmitter.event event]. Failure
   * of one or more listener will not fail this function call.
   *
   * @param data The event object.
   */
  fun fire(data: T)

  /**
   * Dispose this object and free resources.
   */
  fun dispose()
}
