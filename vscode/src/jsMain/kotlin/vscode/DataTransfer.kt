@file:JsModule("vscode")

package vscode

import js.array.JsTuple2
import js.iterable.JsIterable

/**
 * A map containing a mapping of the mime type of the corresponding transferred data.
 *
 * Drag and drop controllers that implement [TreeDragAndDropController.handleDrag] can add additional mime types to the
 * data transfer. These additional mime types will only be included in the `handleDrop` when the the drag was initiated from
 * an element in the same drag and drop controller.
 */
external class DataTransfer :
  JsIterable<JsTuple2<String, DataTransferItem>/* [ mimeType: string, item: DataTransferItem ] */> {
  /**
   * Retrieves the data transfer item for a given mime type.
   *
   * @param mimeType The mime type to get the data transfer item for, such as `text/plain` or `image/png`.
   * Mimes type look ups are case-insensitive.
   *
   * Special mime types:
   * - `text/uri-list` — A string with `toString()`ed Uris separated by `\r\n`. To specify a cursor position in the file,
   * set the Uri's fragment to `L3,5`, where 3 is the line number and 5 is the column number.
   */
  fun get(mimeType: String): DataTransferItem?

  /**
   * Sets a mime type to data transfer item mapping.
   *
   * @param mimeType The mime type to set the data for. Mimes types stored in lower case, with case-insensitive looks up.
   * @param value The data transfer item for the given mime type.
   */
  fun set(
    mimeType: String,
    value: DataTransferItem,
  )

  /**
   * Allows iteration through the data transfer items.
   *
   * @param callbackfn Callback for iteration through the data transfer items.
   * @param thisArg The `this` context used when invoking the handler function.
   */
  fun forEach(
    callbackfn: (item: DataTransferItem, mimeType: String, dataTransfer: DataTransfer) -> Unit,
    thisArg: Any? = definedExternally,
  )
}
