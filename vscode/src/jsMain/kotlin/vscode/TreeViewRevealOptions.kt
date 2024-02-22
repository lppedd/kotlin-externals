package vscode

external interface TreeViewRevealOptions {
  /**
   * If true, then the element will be selected.
   */
  var select: Boolean?

  /**
   * If true, then the element will be focused.
   */
  var focus: Boolean?

  /**
   * If true, then the element will be expanded. If a number is passed, then up to that number of levels of children will be expanded
   */
  var expand: Union<Boolean, Int>?
}
