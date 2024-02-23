@file:JsModule("vscode")
@file:JsQualifier("notebooks")

package vscode.notebooks

import vscode.NotebookRendererMessaging

/**
 * Creates a new messaging instance used to communicate with a specific renderer.
 *
 * * *Note 1:* Extensions can only create renderer that they have defined in their `package.json`-file
 * * *Note 2:* A renderer only has access to messaging if `requiresMessaging` is set to `always` or `optional` in
 * its `notebookRenderer` contribution.
 *
 * @param rendererId The renderer ID to communicate with
 * @return A new notebook renderer messaging object.
 */
external fun createRendererMessaging(rendererId: String): NotebookRendererMessaging
