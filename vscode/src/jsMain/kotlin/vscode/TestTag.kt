@file:JsModule("vscode")

package vscode

/**
 * Tags can be associated with [TestItem TestItems] and
 * [TestRunProfile TestRunProfiles]. A profile with a tag can only
 * execute tests that include that tag in their [TestItem.tags] array.
 */
external class TestTag {
  /**
   * Creates a new TestTag instance.
   * @param id ID of the test tag.
   */
  constructor(id: String)

  /**
   * ID of the test tag. `TestTag` instances with the same ID are considered
   * to be identical.
   */
  val id: String
}
