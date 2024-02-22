@file:JsModule("vscode")

package vscode

/**
 * Represents a location inside a resource, such as a line
 * inside a text file.
 */
external class Location {
  /**
   * Creates a new location object.
   *
   * @param uri The resource identifier.
   * @param rangeOrPosition The range or position. Positions will be converted to an empty range.
   */
  constructor(uri: Uri, rangeOrPosition: Range)

  /**
   * Creates a new location object.
   *
   * @param uri The resource identifier.
   * @param rangeOrPosition The range or position. Positions will be converted to an empty range.
   */
  constructor(uri: Uri, rangeOrPosition: Position)

  /**
   * The resource identifier of this location.
   */
  var uri: Uri

  /**
   * The document range of this location.
   */
  var range: Range
}
