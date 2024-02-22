package vscode

import kotlin.ts.Union

/**
 * MarkedString can be used to render human-readable text. It is either a markdown string
 * or a code-block that provides a language and a code snippet. Note that
 * markdown strings will be sanitized - that means html will be escaped.
 */
@Deprecated("Use MarkdownString instead", ReplaceWith("MarkdownString"))
typealias MarkedString = Union<String, LanguageSnippet> // string | { language: string; value: string; }
