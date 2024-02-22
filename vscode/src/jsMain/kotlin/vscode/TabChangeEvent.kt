package vscode

import js.array.ReadonlyArray

/**
 * An event describing change to tabs.
 */
external interface TabChangeEvent {
  /**
   * The tabs that have been opened.
   */
  val opened: ReadonlyArray<Tab>

  /**
   * The tabs that have been closed.
   */
  val closed: ReadonlyArray<Tab>

  /**
   * Tabs that have changed, e.g have changed
   * their [Tab.isActive] state.
   */
  val changed: ReadonlyArray<Tab>
}
