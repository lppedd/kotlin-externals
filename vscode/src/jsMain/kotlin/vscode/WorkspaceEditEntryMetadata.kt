package vscode

import kotlin.ts.Union3

/**
 * Additional data for entries of a workspace edit. Supports to label entries and marks entries
 * as needing confirmation by the user. The editor groups edits with equal labels into tree nodes,
 * for instance all edits labelled with "Changes in Strings" would be a tree node.
 */
external interface WorkspaceEditEntryMetadata {
  /**
   * A flag which indicates that user confirmation is needed.
   */
  var needsConfirmation: Boolean

  /**
   * A human-readable string which is rendered prominent.
   */
  var label: String

  /**
   * A human-readable string which is rendered less prominent on the same line.
   */
  var description: String?

  /**
   * The icon path or [ThemeIcon] for the edit.
   */
  var iconPath: Union3<Uri, ThemeUris, ThemeIcon>? // Uri | { light: Uri; dark: Uri; } | ThemeIcon
}
