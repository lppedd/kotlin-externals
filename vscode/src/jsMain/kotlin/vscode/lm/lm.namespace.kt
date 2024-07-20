@file:JsModule("vscode")
@file:JsQualifier("lm")

package vscode.lm

import vscode.Event
import vscode.LanguageModelChat
import vscode.LanguageModelChatSelector
import vscode.Thenable

/**
 * An event that is fired when the set of available chat models changes.
 */
external val onDidChangeChatModels: Event<Unit>

/**
 * Select chat models by a [LanguageModelChatSelector]. This can yield multiple or no chat models and
 * extensions must handle these cases, esp. when no chat model exists, gracefully.
 *
 * ```ts
 * const models = await vscode.lm.selectChatModels({ family: 'gpt-3.5-turbo' });
 * if (models.length > 0) {
 * 	const [first] = models;
 * 	const response = await first.sendRequest(...)
 * 	// ...
 * } else {
 * 	// NO chat models available
 * }
 * ```
 *
 * A selector can be written to broadly match all models of a given vendor or family, or it can narrowly select one model by ID.
 * Keep in mind that the available set of models will change over time, but also that prompts may perform differently in
 * different models.
 *
 * *Note* that extensions can hold on to the results returned by this function and use them later. However, when the
 * [onDidChangeChatModels]-event is fired the list of chat models might have changed and extensions should re-query.
 *
 * @param selector A chat model selector. When omitted all chat models are returned.
 * @return An array of chat models, can be empty!
 */
external fun selectChatModels(
  selector: LanguageModelChatSelector = definedExternally,
): Thenable<Array<LanguageModelChat>>
