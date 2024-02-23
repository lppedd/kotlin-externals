@file:JsModule("vscode")
@file:JsQualifier("scm")

package vscode.scm

import vscode.SourceControl
import vscode.Uri

/**
 * Creates a new [SourceControl] instance.
 *
 * @param id An `id` for the source control. Something short, e.g.: `git`.
 * @param label A human-readable string for the source control. E.g.: `Git`.
 * @param rootUri An optional Uri of the root of the source control. E.g.: `Uri.parse(workspaceRoot)`.
 * @return An instance of [SourceControl].
 */
external fun createSourceControl(
  id: String,
  label: String,
  rootUri: Uri = definedExternally,
): SourceControl
