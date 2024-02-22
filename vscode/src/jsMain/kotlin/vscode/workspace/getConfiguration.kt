@file:JsModule("vscode")

package vscode.workspace

import vscode.*

/**
 * Get a workspace configuration object.
 *
 * When a section-identifier is provided only that part of the configuration
 * is returned. Dots in the section-identifier are interpreted as child-access,
 * like `{ myExt: { setting: { doIt: true }}}` and `getConfiguration('myExt.setting').get('doIt') === true`.
 *
 * When a scope is provided configuration confined to that scope is returned. Scope can be a resource or a language identifier or both.
 *
 * @param section A dot-separated identifier.
 * @param scope A scope for which the configuration is asked for.
 * @return The full configuration or a subset.
 */
external fun getConfiguration(
  section: String = definedExternally,
  scope: Uri? = definedExternally,
): WorkspaceConfiguration

/**
 * Get a workspace configuration object.
 *
 * When a section-identifier is provided only that part of the configuration
 * is returned. Dots in the section-identifier are interpreted as child-access,
 * like `{ myExt: { setting: { doIt: true }}}` and `getConfiguration('myExt.setting').get('doIt') === true`.
 *
 * When a scope is provided configuration confined to that scope is returned. Scope can be a resource or a language identifier or both.
 *
 * @param section A dot-separated identifier.
 * @param scope A scope for which the configuration is asked for.
 * @return The full configuration or a subset.
 */
external fun getConfiguration(
  section: String = definedExternally,
  scope: TextDocument? = definedExternally,
): WorkspaceConfiguration

/**
 * Get a workspace configuration object.
 *
 * When a section-identifier is provided only that part of the configuration
 * is returned. Dots in the section-identifier are interpreted as child-access,
 * like `{ myExt: { setting: { doIt: true }}}` and `getConfiguration('myExt.setting').get('doIt') === true`.
 *
 * When a scope is provided configuration confined to that scope is returned. Scope can be a resource or a language identifier or both.
 *
 * @param section A dot-separated identifier.
 * @param scope A scope for which the configuration is asked for.
 * @return The full configuration or a subset.
 */
external fun getConfiguration(
  section: String = definedExternally,
  scope: WorkspaceFolder? = definedExternally,
): WorkspaceConfiguration

/**
 * Get a workspace configuration object.
 *
 * When a section-identifier is provided only that part of the configuration
 * is returned. Dots in the section-identifier are interpreted as child-access,
 * like `{ myExt: { setting: { doIt: true }}}` and `getConfiguration('myExt.setting').get('doIt') === true`.
 *
 * When a scope is provided configuration confined to that scope is returned. Scope can be a resource or a language identifier or both.
 *
 * @param section A dot-separated identifier.
 * @param scope A scope for which the configuration is asked for.
 * @return The full configuration or a subset.
 */
external fun getConfiguration(
  section: String = definedExternally,
  scope: Scope? = definedExternally,
): WorkspaceConfiguration
