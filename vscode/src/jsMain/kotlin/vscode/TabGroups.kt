package vscode

import js.array.ReadonlyArray

/**
 * Represents the main editor area which consists of multiple groups which contain tabs.
 */
external interface TabGroups {
  /**
   * All the groups within the group container.
   */
  val all: Array<out TabGroup>

  /**
   * The currently active group.
   */
  val activeTabGroup: TabGroup

  /**
   * An [Event] which fires when [TabGroup]s have changed.
   */
  val onDidChangeTabGroups: Event<TabGroupChangeEvent>

  /**
   * An [Event] which fires when [Tab]s have changed.
   */
  val onDidChangeTabs: Event<TabChangeEvent>

  /**
   * Closes the tab. This makes the tab object invalid and the tab
   * should no longer be used for further actions.
   * Note: In the case of a dirty tab, a confirmation dialog will be shown which may be cancelled. If cancelled the tab is still valid
   *
   * @param tab The tab to close.
   * @param preserveFocus When `true` focus will remain in its current position. If `false` it will jump to the next tab.
   * @return A promise that resolves to `true` when all tabs have been closed.
   */
  fun close(
    tab: Tab,
    preserveFocus: Boolean = definedExternally,
  ): Thenable<Boolean>

  /**
   * Closes the tab. This makes the tab object invalid and the tab
   * should no longer be used for further actions.
   * Note: In the case of a dirty tab, a confirmation dialog will be shown which may be cancelled. If cancelled the tab is still valid
   *
   * @param tab The tab to close.
   * @param preserveFocus When `true` focus will remain in its current position. If `false` it will jump to the next tab.
   * @return A promise that resolves to `true` when all tabs have been closed.
   */
  fun close(
    tab: ReadonlyArray<Tab>,
    preserveFocus: Boolean = definedExternally,
  ): Thenable<Boolean>

  /**
   * Closes the tab group. This makes the tab group object invalid and the tab group
   * should no longer be used for further actions.
   * @param tabGroup The tab group to close.
   * @param preserveFocus When `true` focus will remain in its current position.
   * @return A promise that resolves to `true` when all tab groups have been closed.
   */
  fun close(
    tabGroup: TabGroup,
    preserveFocus: Boolean = definedExternally,
  ): Thenable<Boolean>

  /**
   * Closes the tab group. This makes the tab group object invalid and the tab group
   * should no longer be used for further actions.
   * @param tabGroup The tab group to close.
   * @param preserveFocus When `true` focus will remain in its current position.
   * @return A promise that resolves to `true` when all tab groups have been closed.
   */
  fun close(
    tabGroup: ReadonlyArray<TabGroup>,
    preserveFocus: Boolean = definedExternally,
  ): Thenable<Boolean>
}
