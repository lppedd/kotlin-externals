@file:JsModule("vscode")

package vscode

/**
 * Represents an outgoing call, e.g. calling a getter from a method or a method from a constructor etc.
 */
external class CallHierarchyOutgoingCall {
  /**
   * Create a new call object.
   *
   * @param item The item being called
   * @param fromRanges The ranges at which the calls appear.
   */
  constructor(item: CallHierarchyItem, fromRanges: Array<Range>)

  /**
   * The item that is called.
   */
  var to: CallHierarchyItem

  /**
   * The range at which this item is called. This is the range relative to the caller, e.g the item
   * passed to [CallHierarchyProvider.provideCallHierarchyOutgoingCalls] and not [to].
   */
  var fromRanges: Array<Range>
}
