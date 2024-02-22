@file:JsModule("vscode")

package vscode

/**
 * Represents an incoming call, e.g. a caller of a method or constructor.
 */
external class CallHierarchyIncomingCall {
  /**
   * Create a new call object.
   *
   * @param item The item making the call.
   * @param fromRanges The ranges at which the calls appear.
   */
  constructor(item: CallHierarchyItem, fromRanges: Array<Range>)

  /**
   * The item that makes the call.
   */
  var from: CallHierarchyItem

  /**
   * The range at which at which the calls appears. This is relative to the caller
   * denoted by [from].
   */
  var fromRanges: Array<Range>
}
