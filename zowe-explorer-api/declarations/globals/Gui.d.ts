/**
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 *
 */
import * as vscode from "vscode";
import { IZoweLogger, MessageSeverity } from "../logger";
import { IZoweTree, IZoweTreeNode } from "../tree";
export interface GuiMessageOptions<T extends string | vscode.MessageItem> {
    severity?: MessageSeverity;
    items?: T[];
    logger?: IZoweLogger;
    vsCodeOpts?: vscode.MessageOptions;
}
export interface WebviewOptions {
    viewType: string;
    title: string;
    showOptions: vscode.ViewColumn | {
        viewColumn: vscode.ViewColumn;
        preserveFocus?: boolean;
    };
    vscode?: vscode.WebviewPanelOptions & vscode.WebviewOptions;
}
export declare namespace Gui {
    /**
     * Creates a new output channel with the given name and language ID
     * @param name The desired name for the output channel
     * @param languageId Identifier associated with the language for this output channel
     * @returns The new output channel with the specified options
     *
     * @see vscode.window.createOutputChannel for more details
     */
    function createOutputChannel(name: string, languageId?: string): vscode.OutputChannel;
    /**
     * Creates a QuickPick within VS Code with more flexible options than `quickPick`
     * @returns A new QuickPick object
     *
     * @see vscode.window.createQuickPick for more details
     */
    function createQuickPick<T extends vscode.QuickPickItem>(): vscode.QuickPick<T>;
    /**
     * Creates a TreeView given the specified view ID and options
     * @param viewId The ID contributed by `views`
     * @param options Any options for creating the tree view
     * @returns A new TreeView object of the provided type
     *
     * @see vscode.window.createTreeView for more details
     */
    function createTreeView<T>(viewId: string, options: vscode.TreeViewOptions<T>): vscode.TreeView<T>;
    /**
     * Create and show a new webview panel
     * @param options Settings for the new panel (@see WebviewOptions for more info)
     *
     * @see vscode.window.createWebviewPanel for more details
     */
    function createWebviewPanel(options: WebviewOptions): vscode.WebviewPanel;
    /**
     * Wrapper function for `showMessage` to display an error message.
     * @param message The message to display
     * @param options Additional options for the displayed message
     * @returns A thenable containing the selected item (if items were specified), or `undefined`
     */
    function errorMessage<T extends string | vscode.MessageItem>(message: string, options?: Omit<GuiMessageOptions<T>, "severity">): Thenable<T | undefined>;
    /**
     * Wrapper function for `showMessage` to display an informational message.
     * @param message The message to display
     * @param options Additional options for the displayed message
     * @returns A thenable containing the selected item (if items were specified), or `undefined`
     */
    function infoMessage<T extends string | vscode.MessageItem>(message: string, options?: Omit<GuiMessageOptions<T>, "severity">): Thenable<T | undefined>;
    /**
     * Wrapper function for `showMessage` to display a warning message.
     * @param message The message to display
     * @param options Additional options for the displayed message
     * @returns A thenable containing the selected item (if items were specified), or `undefined`
     */
    function warningMessage<T extends string | vscode.MessageItem>(message: string, options?: Omit<GuiMessageOptions<T>, "severity">): Thenable<T | undefined>;
    /**
     * Shows an input box within VS Code using the specified options.
     * @param options All options for the input box
     * @returns The user's response, or `undefined` if the input box was dismissed.
     *
     * @see vscode.window.showInputBox for more details
     */
    function showInputBox(options: vscode.InputBoxOptions): Thenable<string | undefined>;
    /**
     * Shows a file open dialog to the user which allows for file selection
     * @param options Configure the behavior of the open file dialog
     * @returns A promise containing the selected resource(s) or `undefined`
     *
     * @see vscode.window.showOpenDialog for more details
     */
    function showOpenDialog(options?: vscode.OpenDialogOptions): Thenable<vscode.Uri[]>;
    function setStatusBarMessage(text: string, hideAfterTimeout: Thenable<any>): vscode.Disposable;
    function setStatusBarMessage(text: string, hideAfterTimeout: number): vscode.Disposable;
    function setStatusBarMessage(text: string): vscode.Disposable;
    /**
     * Builds the specified QuickPick result based on user interaction.
     * @param quickpick The QuickPick object to resolve
     * @returns A promise containing the result of the QuickPick
     */
    function resolveQuickPick(quickpick: vscode.QuickPick<vscode.QuickPickItem>): Promise<vscode.QuickPickItem | undefined>;
    /**
     *
     * @param items An array of items, or a promise that resolves to an array of items
     * @param options VS Code options for the quick pick's behavior
     * @param token A token used to signal cancellation for the quick pick
     *
     * @see vscode.window.showQuickPick for more details
     */
    function showQuickPick<T extends string>(items: readonly T[] | Thenable<readonly T[]>, options?: vscode.QuickPickOptions, token?: vscode.CancellationToken): Thenable<T | undefined>;
    function showQuickPick<T extends string>(items: readonly T[] | Thenable<readonly T[]>, options?: vscode.QuickPickOptions & {
        canPickMany: true;
    }, token?: vscode.CancellationToken): Thenable<T[] | undefined>;
    function showQuickPick<T extends vscode.QuickPickItem>(items: readonly T[] | Thenable<readonly T[]>, options?: vscode.QuickPickOptions, token?: vscode.CancellationToken): Thenable<T | undefined>;
    /**
     * Displays a message to the user, including any specified options.
     * @param message The message to display
     * @param options Any additional options for the message
     * @returns A thenable containing the selected item (if items were specified), or `undefined`
     */
    function showMessage<T extends string | vscode.MessageItem>(message: string, options?: GuiMessageOptions<T>): Thenable<T | undefined>;
    /**
     * Helper type guard to check if a document object belong to VS Code's `TextDocument` interface
     * @param doc The object that may or may not be a `vscode.TextDocument`
     * @returns Whether `doc` is a `vscode.TextDocument`
     */
    function isTextDocument(doc: any): doc is vscode.TextDocument;
    /**
     * Show the given document in a text editor.
     * @param docOrUri The document or URI object to display
     * @param options Any options for the behavior of the text document
     * @returns A promise that resolves to an editor
     *
     * @see vscode.window.showTextDocument for more details
     */
    function showTextDocument(docOrUri: vscode.TextDocument | vscode.Uri, options?: vscode.TextDocumentShowOptions): Thenable<vscode.TextEditor>;
    /**
     * Show progress in the editor.
     * @param options Location and other details for the progress
     * @param task A callback that returns a promise
     * @returns The promise that the task callback returned
     *
     * @see @see vscode.window.withProgress for more details
     */
    function withProgress<R>(options: vscode.ProgressOptions, task: (progress: vscode.Progress<{
        message?: string;
        increment?: number;
    }>, token: vscode.CancellationToken) => Thenable<R>): Thenable<R>;
    /**
     * Reports the progress of a Gui.withProgress action results in visual update for users.
     *
     * @export
     * @param {any} progress - Gui.withProgress progress
     * @param {number} valueLength - values array length used to calculate progress
     * @param {number} index - withProgress loop array's index
     * @param {string} action - the action the progress is reported for, ie. Uploading
     */
    function reportProgress(progress: any, valueLength: number, index: number, action: string): void;
    namespace utils {
        /**
         * Determines whether a node has been double-clicked within a tree view.
         *
         * @param node The node that was just clicked
         * @param provider The tree provider that the node belongs to
         * @returns Whether the node has been double-clicked.
         */
        function wasDoubleClicked<T>(node: IZoweTreeNode, provider: IZoweTree<T>): boolean;
    }
}
