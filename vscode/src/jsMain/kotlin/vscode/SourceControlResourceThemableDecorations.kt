package vscode

import kotlin.ts.Union3

/**
 * The theme-aware decorations for a [SourceControlResourceState].
 */
external interface SourceControlResourceThemableDecorations {
  /**
   * The icon path for a specific [SourceControlResourceState].
   */
  val iconPath: Union3<String, Uri, ThemeIcon>?
}
