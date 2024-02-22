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
import { imperative } from "@zowe/cli";
import { IZoweTreeNode } from "./IZoweTreeNode";
/**
 * Common implementation of functions and methods associated with the
 * IZoweTreeNode
 *
 * @export
 * @class ZoweDatasetNode
 * @extends {vscode.TreeItem}
 */
export declare class ZoweTreeNode extends vscode.TreeItem {
    private mParent;
    protected session: imperative.Session;
    protected profile: imperative.IProfileLoaded;
    command: vscode.Command;
    fullPath: string;
    dirty: boolean;
    children: IZoweTreeNode[];
    /**
     * @deprecated Define on subclass instead
     */
    binaryFiles: {};
    /**
     * @deprecated Define on subclass instead
     */
    binary: boolean;
    /**
     * @deprecated Define on subclass instead
     */
    shortLabel: string;
    /**
     * Creates an instance of ZoweDatasetNode
     *
     * @param {string} label - Displayed in the [TreeView]
     * @param {vscode.TreeItemCollapsibleState} mCollapsibleState - file/folder
     * @param {IZoweTreeNode} mParent
     * @param {imperative..Session} session
     * @param {string} etag
     */
    constructor(label: string | vscode.TreeItemLabel, collapsibleState: vscode.TreeItemCollapsibleState, mParent: IZoweTreeNode, session: imperative.Session, profile: imperative.IProfileLoaded);
    /**
     * Retrieves parent node of this IZoweTreeNode
     *
     * @returns {Promise<IZoweTreeNode>}
     */
    getParent(): IZoweTreeNode;
    /**
     * Returns the [imperative.Session] for this node
     *
     * @returns {imperative.Session}
     */
    getSession(): imperative.Session;
    /**
     * Returns the imperative.IProfileLoaded profile for this node
     *
     * @returns {imperative.IProfileLoaded}
     */
    getProfile(): imperative.IProfileLoaded;
    /**
     * Implements access to profile name
     *
     * @returns {string}
     */
    getProfileName(): string;
    /**
     * This is the default was that the label should be accessed as it
     * automatically trims the value
     */
    getLabel(): string | vscode.TreeItemLabel;
    /**
     * Sets the imperative.IProfileLoaded profile for this node to the one chosen in parameters.
     *
     * @param {imperative.IProfileLoaded} The profile you will set the node to use
     */
    setProfileToChoice(aProfile: imperative.IProfileLoaded): void;
    /**
     * Sets the session for this node to the one chosen in parameters.
     *
     * @param aSession The session you will set the node to use
     */
    setSessionToChoice(aSession: imperative.Session): void;
}
