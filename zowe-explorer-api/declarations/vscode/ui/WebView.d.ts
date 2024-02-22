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
import { ExtensionContext, WebviewPanel } from "vscode";
export declare class WebView {
    private disposables;
    private webviewContent;
    panel: WebviewPanel;
    private uris;
    private nonce;
    private title;
    /**
     * Constructs a webview for use with bundled assets.
     * The webview entrypoint must be located at src/<webview folder>/dist/<webview-name>/index.js.
     *
     * @param title The title for the new webview
     * @param webviewName The webview name, the same name given to the directory of your webview in the webviews/src directory.
     * @param context The VSCode extension context
     * @param onDidReceiveMessage Event callback: called when messages are received from the webview
     */
    constructor(title: string, webviewName: string, context: ExtensionContext, onDidReceiveMessage?: (message: object) => void | Promise<void>, retainContext?: boolean);
    /**
     * Disposes of the webview instance
     */
    private dispose;
    /**
     * Pre-processed HTML content that loads the bundled script through the webview.
     */
    get htmlContent(): string;
}
