@file:JsModule("vscode")

package vscode

/**
 * A notebook range represents an ordered pair of two cell indices.
 * It is guaranteed that start is less than or equal to end.
 */
external class NotebookRange {
  /**
   * Create a new notebook range. If `start` is not
   * before or equal to `end`, the values will be swapped.
   *
   * @param start start index
   * @param end end index.
   */
  @Suppress("ConvertSecondaryConstructorToPrimary")
  constructor(start: Int, end: Int)

  /**
   * The zero-based start index of this range.
   */
  val start: Int

  /**
   * The exclusive end index of this range (zero-based).
   */
  val end: Int

  /**
   * `true` if `start` and `end` are equal.
   */
  val isEmpty: Boolean

  /**
   * Derive a new range for this range.
   *
   * @param change An object that describes a change to this range.
   * @return A range that reflects the given change. Will return `this` range if the change
   *   is not changing anything.
   */
  fun with(change: NotebookRangeWithChange): NotebookRange
}
