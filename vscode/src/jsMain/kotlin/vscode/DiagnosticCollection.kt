package vscode

import js.array.JsTuple2
import js.array.ReadonlyArray
import js.iterable.JsIterable

/**
 * A diagnostics collection is a container that manages a set of
 * [Diagnostic]s. Diagnostics are always scopes to a
 * diagnostics collection and a resource.
 *
 * To get an instance of a `DiagnosticCollection` use
 * [vscode.languages.createDiagnosticCollection].
 */
external interface DiagnosticCollection :
  JsIterable<JsTuple2<Uri, ReadonlyArray<Diagnostic>>/* [ uri: Uri, diagnostics: readonly Diagnostic[] ] */> {
  /**
   * The name of this diagnostic collection, for instance `typescript`. Every diagnostic
   * from this collection will be associated with this name. Also, the task framework uses this
   * name when defining [problem matchers](https://code.visualstudio.com/docs/editor/tasks#_defining-a-problem-matcher).
   */
  val name: String

  /**
   * Assign diagnostics for given resource. Will replace
   * existing diagnostics for that resource.
   *
   * @param uri A resource identifier.
   * @param diagnostics Array of diagnostics or `undefined`
   */
  fun set(
    uri: Uri,
    diagnostics: ReadonlyArray<Diagnostic>?,
  )

  /**
   * Replace diagnostics for multiple resources in this collection.
   *
   *  _Note_ that multiple tuples of the same uri will be merged, e.g
   * `[[file1, [d1]], [file1, [d2]]]` is equivalent to `[[file1, [d1, d2]]]`.
   * If a diagnostics item is `undefined` as in `[file1, undefined]`
   * all previous but not subsequent diagnostics are removed.
   *
   * @param entries An array of tuples, like `[[file1, [d1, d2]], [file2, [d3, d4, d5]]]`, or `undefined`.
   */
  fun set(
    entries: ReadonlyArray<JsTuple2<Uri, ReadonlyArray<Diagnostic>?> /* [ Uri, readonly Diagnostic[] | undefined ] */>,
  )

  /**
   * Remove all diagnostics from this collection that belong
   * to the provided `uri`. The same as `#set(uri, undefined)`.
   *
   * @param uri A resource identifier.
   */
  fun delete(uri: Uri)

  /**
   * Remove all diagnostics from this collection. The same
   * as calling `#set(undefined)`;
   */
  fun clear()

  /**
   * Iterate over each entry in this collection.
   *
   * @param callback Function to execute for each entry.
   * @param thisArg The `this` context used when invoking the handler function.
   */
  fun forEach(
    callback: (uri: Uri, diagnostics: ReadonlyArray<Diagnostic>, collection: DiagnosticCollection) -> Any?,
    thisArg: Any? = definedExternally,
  )

  /**
   * Get the diagnostics for a given resource. *Note* that you cannot
   * modify the diagnostics-array returned from this call.
   *
   * @param uri A resource identifier.
   * @return An immutable array of [Diagnostic]s or `undefined`.
   */
  fun get(uri: Uri): ReadonlyArray<Diagnostic>?

  /**
   * Check if this collection contains diagnostics for a
   * given resource.
   *
   * @param uri A resource identifier.
   * @return `true` if this collection has diagnostic for the given resource.
   */
  fun has(uri: Uri): Boolean

  /**
   * Dispose and free associated resources. Calls
   * [DiagnosticCollection.clear].
   */
  fun dispose()
}
