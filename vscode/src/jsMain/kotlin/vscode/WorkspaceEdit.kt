@file:JsModule("vscode")

package vscode

import js.array.JsTuple2
import js.array.ReadonlyArray

/**
 * A workspace edit is a collection of textual and files changes for
 * multiple resources and documents.
 *
 * Use the [vscode.workspace.applyEdit]-function to apply a workspace edit.
 */
external class WorkspaceEdit {
  /**
   * The number of affected resources of textual or resource changes.
   */
  val size: Int

  /**
   * Replace the given range with given text for the given resource.
   *
   * @param uri A resource identifier.
   * @param range A range.
   * @param newText A string.
   * @param metadata Optional metadata for the entry.
   */
  fun replace(
    uri: Uri,
    range: Range,
    newText: String,
    metadata: WorkspaceEditEntryMetadata = definedExternally,
  )

  /**
   * Insert the given text at the given position.
   *
   * @param uri A resource identifier.
   * @param position A position.
   * @param newText A string.
   * @param metadata Optional metadata for the entry.
   */
  fun insert(
    uri: Uri,
    position: Position,
    newText: String,
    metadata: WorkspaceEditEntryMetadata = definedExternally,
  )

  /**
   * Delete the text at the given range.
   *
   * @param uri A resource identifier.
   * @param range A range.
   * @param metadata Optional metadata for the entry.
   */
  fun delete(
    uri: Uri,
    range: Range,
    metadata: WorkspaceEditEntryMetadata = definedExternally,
  )

  /**
   * Check if a text edit for a resource exists.
   *
   * @param uri A resource identifier.
   * @return `true` if the given resource will be touched by this edit.
   */
  fun has(uri: Uri): Boolean

  /**
   * Set (and replace) notebook edits with metadata for a resource.
   *
   * @param uri A resource identifier.
   * @param edits An array of edits.
   */
  fun set(
    uri: Uri,
    edits: ReadonlyArray<Union<TextEdit, SnippetTextEdit>>,
  )

  /**
   * Set (and replace) notebook edits with metadata for a resource.
   *
   * @param uri A resource identifier.
   * @param edits An array of edits.
   */
  fun set(
    uri: Uri,
    edits: ReadonlyArray<JsTuple2<Union<TextEdit, SnippetTextEdit>, WorkspaceEditEntryMetadata?>>,
  )

  /**
   * Set (and replace) notebook edits with metadata for a resource.
   *
   * @param uri A resource identifier.
   * @param edits An array of edits.
   */
  fun set(
    uri: Uri,
    edits: ReadonlyArray<NotebookEdit>,
  )

  /**
   * Set (and replace) notebook edits with metadata for a resource.
   *
   * @param uri A resource identifier.
   * @param edits An array of edits.
   */
  fun set(
    uri: Uri,
    edits: ReadonlyArray<JsTuple2<NotebookEdit, WorkspaceEditEntryMetadata?>>,
  )

  /**
   * Get the text edits for a resource.
   *
   * @param uri A resource identifier.
   * @return An array of text edits.
   */
  fun get(uri: Uri): Array<TextEdit>

  /**
   * Create a regular file.
   *
   * @param uri Uri of the new file.
   * @param options Defines if an existing file should be overwritten or be
   *   ignored. When `overwrite` and `ignoreIfExists` are both set `overwrite` wins.
   *   When both are unset and when the file already exists then the edit cannot
   *   be applied successfully. The `content`-property allows to set the initial contents
   *   the file is being created with.
   * @param metadata Optional metadata for the entry.
   */
  fun createFile(
    uri: Uri,
    options: WorkspaceEditCreateFileOptions = definedExternally,
    metadata: WorkspaceEditEntryMetadata = definedExternally,
  )

  /**
   * Delete a file or folder.
   *
   * @param uri The uri of the file that is to be deleted.
   * @param metadata Optional metadata for the entry.
   */
  fun deleteFile(
    uri: Uri,
    options: WorkspaceEditDeleteFileOptions = definedExternally,
    metadata: WorkspaceEditEntryMetadata = definedExternally,
  )

  /**
   * Rename a file or folder.
   *
   * @param oldUri The existing file.
   * @param newUri The new location.
   * @param options Defines if existing files should be overwritten or be
   *   ignored. When overwrite and ignoreIfExists are both set overwrite wins.
   * @param metadata Optional metadata for the entry.
   */
  fun renameFile(
    oldUri: Uri,
    newUri: Uri,
    options: WorkspaceEditRenameFileOptions = definedExternally,
    metadata: WorkspaceEditEntryMetadata = definedExternally,
  )

  /**
   * Get all text edits grouped by resource.
   *
   * @return A shallow copy of `[Uri, TextEdit[]]`-tuples.
   */
  fun entries(): Array<JsTuple2<Uri, Array<TextEdit>>>
}
