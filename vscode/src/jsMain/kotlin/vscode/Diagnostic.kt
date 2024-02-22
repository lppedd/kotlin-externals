@file:JsModule("vscode")

package vscode

import kotlin.ts.Union3

/**
 * Represents a diagnostic, such as a compiler error or warning. Diagnostic objects
 * are only valid in the scope of a file.
 */
external class Diagnostic {
  /**
   * Creates a new diagnostic object.
   *
   * @param range The range to which this diagnostic applies.
   * @param message The human-readable message.
   * @param severity The severity, default is [DiagnosticSeverity.Error].
   */
  constructor(range: Range, message: String, severity: DiagnosticSeverity = definedExternally)

  /**
   * The range to which this diagnostic applies.
   */
  var range: Range

  /**
   * The human-readable message.
   */
  var message: String

  /**
   * The severity, default is [DiagnosticSeverity.Error].
   */
  var severity: DiagnosticSeverity

  /**
   * A human-readable string describing the source of this
   * diagnostic, e.g. 'typescript' or 'super lint'.
   */
  var source: String?

  /**
   * A code or identifier for this diagnostic.
   * Should be used for later processing, e.g. when providing code actions ([CodeActionContext]).
   */
  var code: Union3<String, Int, DiagnosticCode>? // string | number | { value: string | number; target: Uri; }

  /**
   * An array of related diagnostic information, e.g. when symbol-names within
   * a scope collide all definitions can be marked via this property.
   */
  var relatedInformation: Array<DiagnosticRelatedInformation>?

  /**
   * Additional metadata about the diagnostic.
   */
  var tags: Array<DiagnosticTag>?
}
