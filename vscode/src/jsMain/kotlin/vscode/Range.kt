@file:JsModule("vscode")

package vscode

/**
 * A range represents an ordered pair of two positions.
 * It is guaranteed that [start].isBeforeOrEqual([end])
 *
 * Range objects are __immutable__. Use the [with],
 * [intersection], or [union] methods
 * to derive new ranges from an existing range.
 */
open external class Range {
  /**
   * Create a new range from two positions. If `start` is not
   * before or equal to `end`, the values will be swapped.
   *
   * @param start A position.
   * @param end A position.
   */
  constructor(start: Position, end: Position)

  /**
   * Create a new range from number coordinates. It is a shorter equivalent of
   * using `new Range(new Position(startLine, startCharacter), new Position(endLine, endCharacter))`
   *
   * @param startLine A zero-based line value.
   * @param startCharacter A zero-based character value.
   * @param endLine A zero-based line value.
   * @param endCharacter A zero-based character value.
   */
  constructor(startLine: Int, startCharacter: Int, endLine: Int, endCharacter: Int)

  /**
   * The start position. It is before or equal to [end].
   */
  val start: Position

  /**
   * The end position. It is after or equal to [start].
   */
  val end: Position

  /**
   * `true` if `start` and `end` are equal.
   */
  var isEmpty: Boolean

  /**
   * `true` if `start.line` and `end.line` are equal.
   */
  var isSingleLine: Boolean

  /**
   * Check if a position or a range is contained in this range.
   *
   * @param positionOrRange A position or a range.
   * @return `true` if the position or range is inside or equal
   *   to this range.
   */
  fun contains(positionOrRange: Position): Boolean

  /**
   * Check if a position or a range is contained in this range.
   *
   * @param positionOrRange A position or a range.
   * @return `true` if the position or range is inside or equal
   *   to this range.
   */
  fun contains(positionOrRange: Range): Boolean

  /**
   * Check if `other` equals this range.
   *
   * @param other A range.
   * @return `true` when start and end are [isEqual] to
   *   start and end of this range.
   */
  fun isEqual(other: Range): Boolean

  /**
   * Intersect `range` with this range and returns a new range or `undefined`
   * if the ranges have no overlap.
   *
   * @param range A range.
   * @return A range of the greater start and smaller end positions. Will
   *   return undefined when there is no overlap.
   */
  fun intersection(range: Range): Range?

  /**
   * Compute the union of `other` with this range.
   *
   * @param other A range.
   * @return A range of smaller start position and the greater end position.
   */
  fun union(other: Range): Range

  /**
   * Derived a new range from this range.
   *
   * @param start A position that should be used as start. The default value is the [start].
   * @param end A position that should be used as end. The default value is the [end].
   * @return A range derived from this range with the given start and end position.
   *   If start and end are not different `this` range will be returned.
   */
  fun with(
    start: Position = definedExternally,
    end: Position = definedExternally,
  ): Range

  /**
   * Derived a new range from this range.
   *
   * @param change An object that describes a change to this range.
   * @return A range that reflects the given change. Will return `this` range if the change
   *   is not changing anything.
   */
  fun with(change: RangeWithChange): Range
}
