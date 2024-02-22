package vscode

import js.array.ReadonlyArray

/**
 * A language selector is the combination of one or many language identifiers
 * and language filters ([DocumentFilter]).
 *
 * *Note* that a document selector that is just a language identifier selects *all*
 * documents, even those that are not saved on disk. Only use such selectors when
 * a feature works without further context, e.g. without the need to resolve related
 * 'files'.
 *
 * Example:
 * ```
 * let sel: DocumentSelector = { scheme: 'file', language: 'typescript' };
 * ```
 */
// TODO(Edoardo): use overloads for function's parameters instead of this typealias
typealias DocumentSelector = Union3<DocumentFilter, String, ReadonlyArray<Union<DocumentFilter, String>>> // DocumentFilter | string | ReadonlyArray<DocumentFilter | string>
