@file:JsModule("vscode")

package vscode

/**
 * Encapsulates data transferred during drag and drop operations.
 */
external class DataTransferItem {
  /**
   * @param value Custom data stored on this item. Can be retrieved using [DataTransferItem.value].
   */
  constructor(value: Any?)

  /**
   * Get a string representation of this item.
   *
   * If [DataTransferItem.value] is an object, this returns the result of json stringifying [DataTransferItem.value] value.
   */
  fun asString(): Thenable<String>

  /**
   * Try getting the [DataTransferFile] associated with this data transfer item.
   *
   * Note that the file object is only valid for the scope of the drag and drop operation.
   *
   * @return The file for the data transfer or `undefined` if the item is either not a file or the
   *   file data cannot be accessed.
   */
  fun asFile(): DataTransferFile?

  /**
   * Custom data stored on this item.
   *
   * You can use `value` to share data across operations. The original object can be retrieved so long as the extension that
   * created the `DataTransferItem` runs in the same extension host.
   */
  val value: Any?
}
