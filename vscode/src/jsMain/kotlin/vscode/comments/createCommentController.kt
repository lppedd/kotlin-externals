@file:JsModule("vscode")

package vscode.comments

import vscode.CommentController

/**
 * Creates a new [CommentController] instance.
 *
 * @param id An `id` for the comment controller.
 * @param label A human-readable string for the comment controller.
 * @return An instance of [CommentController].
 */
external fun createCommentController(
  id: String,
  label: String,
): CommentController
