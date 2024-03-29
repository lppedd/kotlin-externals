package vscode

/**
 * Accessibility information which controls screen reader behavior.
 */
external interface AccessibilityInformation {
  /**
   * Label to be read out by a screen reader once the item has focus.
   */
  val label: String

  /**
   * Role of the widget which defines how a screen reader interacts with it.
   * The role should be set in special cases when for example a tree-like element behaves like a checkbox.
   * If role is not specified the editor will pick the appropriate role automatically.
   * More about aria roles can be found here https://w3c.github.io/aria/#widget_roles
   */
  val role: String?
}
