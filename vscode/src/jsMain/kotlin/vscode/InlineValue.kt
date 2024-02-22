package vscode

import kotlin.ts.Union3

/**
 * Inline value information can be provided by different means:
 * - directly as a text value (class InlineValueText).
 * - as a name to use for a variable lookup (class InlineValueVariableLookup)
 * - as an evaluatable expression (class InlineValueEvaluatableExpression)
 *
 * The InlineValue types combines all inline value types into one type.
 */
typealias InlineValue = Union3<InlineValueText, InlineValueVariableLookup, InlineValueEvaluatableExpression> // InlineValueText | InlineValueVariableLookup | InlineValueEvaluatableExpression
