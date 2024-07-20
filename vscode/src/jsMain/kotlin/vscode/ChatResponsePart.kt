package vscode

import kotlin.ts.Union6

/**
 * Represents the different chat response types.
 */
typealias ChatResponsePart = Union6<ChatResponseMarkdownPart, ChatResponseFileTreePart, ChatResponseAnchorPart, ChatResponseProgressPart, ChatResponseReferencePart, ChatResponseCommandButtonPart>
