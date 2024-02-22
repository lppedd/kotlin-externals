package vscode

import seskar.js.JsNative

/**
 * Represents a typed event.
 *
 * A function that represents an event to which you subscribe by calling it with
 * a listener function as argument.
 *
 * Example:
 * ```
 * item.onDidChange(function(event) { console.log("Event happened: " + event); });
 * ```
 */
external interface Event<T> {
  /**
   * A function that represents an event to which you subscribe by calling it with
   * a listener function as argument.
   *
   * @param listener The listener function will be called when the event happens.
   * @param thisArgs The `this`-argument which will be used when calling the event listener.
   * @param disposables An array to which a [Disposable] will be added.
   * @return A disposable which unsubscribes the event listener.
   */
  @JsNative
  operator fun invoke(
    listener: (e: T) -> Any?,
    thisArgs: Any? = definedExternally,
    disposables: Array<Disposable> = definedExternally,
  ): Disposable
}
