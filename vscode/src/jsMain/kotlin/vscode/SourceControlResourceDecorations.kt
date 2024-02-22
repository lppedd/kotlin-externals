package vscode

/**
 * The decorations for a [SourceControlResourceState].
 * Can be independently specified for light and dark themes.
 */
external interface SourceControlResourceDecorations : SourceControlResourceThemableDecorations {
  /**
   * Whether the [SourceControlResourceState] should be striked-through in the UI.
   */
  val strikeThrough: Boolean?

  /**
   * Whether the [SourceControlResourceState] should be faded in the UI.
   */
  val faded: Boolean?

  /**
   * The title for a specific [SourceControlResourceState].
   */
  val tooltip: String?

  /**
   * The light theme decorations.
   */
  val light: SourceControlResourceThemableDecorations?

  /**
   * The dark theme decorations.
   */
  val dark: SourceControlResourceThemableDecorations?
}
