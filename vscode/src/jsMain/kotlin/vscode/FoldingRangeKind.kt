package vscode

import seskar.js.JsIntValue

/**
 * An enumeration of specific folding range kinds. The kind is an optional field of a [FoldingRange]
 * and is used to distinguish specific folding ranges such as ranges originated from comments. The kind is used by commands like
 * `Fold all comments` or `Fold all regions`.
 * If the kind is not set on the range, the range originated from a syntax element other than comments, imports or region markers.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface FoldingRangeKind {
  companion object {
    /**
     * Kind for folding range representing a comment.
     */
    @JsIntValue(1)
    val Comment: FoldingRangeKind

    /**
     * Kind for folding range representing a import.
     */
    @JsIntValue(2)
    val Imports: FoldingRangeKind

    /**
     * Kind for folding range representing regions originating from folding markers like `#region` and `#endregion`.
     */
    @JsIntValue(3)
    val Region: FoldingRangeKind
  }
}
