package vscode

/**
 * A source control resource group is a collection of [SourceControlResourceState]s.
 */
external interface SourceControlResourceGroup {
  /**
   * The id of this source control resource group.
   */
  val id: String

  /**
   * The label of this source control resource group.
   */
  var label: String

  /**
   * Whether this source control resource group is hidden when it contains
   * no [SourceControlResourceState]s.
   */
  var hideWhenEmpty: Boolean?

  /**
   * This group's collection of [SourceControlResourceState]s.
   */
  var resourceStates: Array<SourceControlResourceState>

  /**
   * Dispose this source control resource group.
   */
  fun dispose()
}
