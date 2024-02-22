@file:JsModule("vscode")

package vscode.languages

import vscode.DocumentFilter
import vscode.DocumentSelector
import vscode.TextDocument

/**
 * Compute the match between a document [DocumentSelector] and a document. Values
 * greater than zero mean the selector matches the document.
 *
 * A match is computed according to these rules:
 * 1. When [DocumentSelector] is an array, compute the match for each contained `DocumentFilter` or language identifier and take the maximum value.
 * 2. A string will be desugared to become the `language`-part of a [DocumentFilter], so `"fooLang"` is like `{ language: "fooLang" }`.
 * 3. A  [DocumentFilter] will be matched against the document by comparing its parts with the document. The following rules apply:
 *    1. When the `DocumentFilter` is empty (`{}`) the result is `0`
 *    2. When `scheme`, `language`, `pattern`, or `notebook` are defined but one doesn't match, the result is `0`
 *    3. Matching against `*` gives a score of `5`, matching via equality or via a glob-pattern gives a score of `10`
 *    4. The result is the maximum value of each match
 *
 * Samples:
 * ```js
 * // default document from disk (file-scheme)
 * doc.uri; //'file:///my/file.js'
 * doc.languageId; // 'javascript'
 * match('javascript', doc); // 10;
 * match({ language: 'javascript' }, doc); // 10;
 * match({ language: 'javascript', scheme: 'file' }, doc); // 10;
 * match('*', doc); // 5
 * match('fooLang', doc); // 0
 * match(['fooLang', '*'], doc); // 5
 *
 * // virtual document, e.g. from git-index
 * doc.uri; // 'git:/my/file.js'
 * doc.languageId; // 'javascript'
 * match('javascript', doc); // 10;
 * match({ language: 'javascript', scheme: 'git' }, doc); // 10;
 * match('*', doc); // 5
 *
 * // notebook cell document
 * doc.uri; // `vscode-notebook-cell:///my/notebook.ipynb#gl65s2pmha`;
 * doc.languageId; // 'python'
 * match({ notebookType: 'jupyter-notebook' }, doc) // 10
 * match({ notebookType: 'fooNotebook', language: 'python' }, doc) // 0
 * match({ language: 'python' }, doc) // 10
 * match({ notebookType: '*' }, doc) // 5
 * ```
 *
 * @param selector A document selector.
 * @param document A text document.
 * @return A number `>0` when the selector matches and `0` when the selector does not match.
 */
external fun match(
  selector: DocumentSelector,
  document: TextDocument,
): Int
