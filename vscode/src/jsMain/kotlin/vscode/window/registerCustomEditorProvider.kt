@file:JsModule("vscode")

package vscode.window

import vscode.*

/**
 * Register a provider for custom editors for the `viewType` contributed by the `customEditors` extension point.
 *
 * When a custom editor is opened, an `onCustomEditor:viewType` activation event is fired. Your extension
 * must register a [CustomTextEditorProvider], [CustomReadonlyEditorProvider],
 * [CustomEditorProvider] for `viewType` as part of activation.
 *
 * @param viewType Unique identifier for the custom editor provider. This should match the `viewType` from the
 *   `customEditors` contribution point.
 * @param provider Provider that resolves custom editors.
 * @param options Options for the provider.
 *
 * @return Disposable that unregisters the provider.
 */
external fun registerCustomEditorProvider(
  viewType: String,
  provider: CustomTextEditorProvider,
  options: RegisterCustomEditorProviderOptions = definedExternally,
): Disposable

/**
 * Register a provider for custom editors for the `viewType` contributed by the `customEditors` extension point.
 *
 * When a custom editor is opened, an `onCustomEditor:viewType` activation event is fired. Your extension
 * must register a [CustomTextEditorProvider], [CustomReadonlyEditorProvider],
 * [CustomEditorProvider] for `viewType` as part of activation.
 *
 * @param viewType Unique identifier for the custom editor provider. This should match the `viewType` from the
 *   `customEditors` contribution point.
 * @param provider Provider that resolves custom editors.
 * @param options Options for the provider.
 *
 * @return Disposable that unregisters the provider.
 */
external fun registerCustomEditorProvider(
  viewType: String,
  provider: CustomReadonlyEditorProvider<CustomDocument>,
  options: RegisterCustomEditorProviderOptions = definedExternally,
): Disposable

/**
 * Register a provider for custom editors for the `viewType` contributed by the `customEditors` extension point.
 *
 * When a custom editor is opened, an `onCustomEditor:viewType` activation event is fired. Your extension
 * must register a [CustomTextEditorProvider], [CustomReadonlyEditorProvider],
 * [CustomEditorProvider] for `viewType` as part of activation.
 *
 * @param viewType Unique identifier for the custom editor provider. This should match the `viewType` from the
 *   `customEditors` contribution point.
 * @param provider Provider that resolves custom editors.
 * @param options Options for the provider.
 *
 * @return Disposable that unregisters the provider.
 */
external fun registerCustomEditorProvider(
  viewType: String,
  provider: CustomEditorProvider<CustomDocument>,
  options: RegisterCustomEditorProviderOptions = definedExternally,
): Disposable
