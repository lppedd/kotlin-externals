package vscode

import kotlin.ts.Union

/**
 * A file glob pattern to match file paths against. This can either be a glob pattern string
 * (like `**&#47;*.{ts,js}` or `*.{ts,js}`) or a [RelativePattern].
 *
 * Glob patterns can have the following syntax:
 * - `*` to match zero or more characters in a path segment
 * - `?` to match on one character in a path segment
 * - `**` to match any number of path segments, including none
 * - `{}` to group conditions (e.g. `**​&#47;*.{ts,js}` matches all TypeScript and JavaScript files)
 * - `[]` to declare a range of characters to match in a path segment (e.g., `example.[0-9]` to match on `example.0`, `example.1`, …)
 * - `[!...]` to negate a range of characters to match in a path segment (e.g., `example.[!0-9]` to match on `example.a`, `example.b`, but not `example.0`)
 *
 * Note: a backslash (`\`) is not valid within a glob pattern. If you have an existing file
 * path to match against, consider to use the [RelativePattern] support
 * that takes care of converting any backslash into slash. Otherwise, make sure to convert
 * any backslash to slash when creating the glob pattern.
 */
typealias GlobPattern = Union<String, RelativePattern> // string | RelativePattern
