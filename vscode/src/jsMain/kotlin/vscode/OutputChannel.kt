package vscode

/**
 * An output channel is a container for readonly textual information.
 *
 * To get an instance of an `OutputChannel` use
 * [window.createOutputChannel createOutputChannel].
 */
external interface OutputChannel {
  /**
   * The human-readable name of this output channel.
   */
  val name: String

  /**
   * Append the given value to the channel.
   *
   * @param value A string, falsy values will not be printed.
   */
  fun append(value: String)

  /**
   * Append the given value and a line feed character
   * to the channel.
   *
   * @param value A string, falsy values will be printed.
   */
  fun appendLine(value: String)

  /**
   * Replaces all output from the channel with the given value.
   *
   * @param value A string, falsy values will not be printed.
   */
  fun replace(value: String)

  /**
   * Removes all output from the channel.
   */
  fun clear()

  /**
   * Reveal this channel in the UI.
   *
   * @param preserveFocus When `true` the channel will not take focus.
   */
  fun show(preserveFocus: Boolean = definedExternally)

  /**
   * Reveal this channel in the UI.
   *
   * @deprecated Use the overload with just one parameter (`show(preserveFocus?: boolean): void`).
   *
   * @param column This argument is **deprecated** and will be ignored.
   * @param preserveFocus When `true` the channel will not take focus.
   */
  fun show(
    column: ViewColumn = definedExternally,
    preserveFocus: Boolean = definedExternally,
  )

  /**
   * Hide this channel from the UI.
   */
  fun hide()

  /**
   * Dispose and free associated resources.
   */
  fun dispose()
}
