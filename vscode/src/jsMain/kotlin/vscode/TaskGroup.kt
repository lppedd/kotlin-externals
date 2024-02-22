@file:JsModule("vscode")

package vscode

/**
 * A grouping for tasks. The editor by default supports the
 * 'Clean', 'Build', 'RebuildAll' and 'Test' group.
 */

external class TaskGroup {
  /**
   * Whether the task that is part of this group is the default for the group.
   * This property cannot be set through API, and is controlled by a user's task configurations.
   */
  val isDefault: Boolean?

  /**
   * The ID of the task group. Is one of TaskGroup.Clean.id, TaskGroup.Build.id, TaskGroup.Rebuild.id, or TaskGroup.Test.id.
   */
  val id: String

  companion object {
    /**
     * The clean task group;
     */
    var Clean: TaskGroup

    /**
     * The build task group;
     */
    var Build: TaskGroup

    /**
     * The rebuild all task group;
     */
    var Rebuild: TaskGroup

    /**
     * The test all task group;
     */
    var Test: TaskGroup
  }
}
