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
import { ProfilesCache, ZoweExplorerApi } from "../profiles";
import { imperative } from "@zowe/cli";
import { IPromptCredentialsOptions } from "./doc/IPromptCredentials";
import { MessageSeverity, IZoweLogger } from "../logger";
import { IZoweNodeType } from "../tree/IZoweTreeNode";
/**
 * Collection of utility functions for writing Zowe Explorer VS Code extensions.
 */
export declare class ZoweVsCodeExtension {
    private static get profilesCache();
    /**
     * Get custom logging path if one is defined in VS Code settings.
     */
    static get customLoggingPath(): string | undefined;
    /**
     * @param {string} [requiredVersion] Optional semver string specifying the minimal required version
     *           of Zowe Explorer that needs to be installed for the API to be usable to the client.
     * @returns an initialized instance `ZoweExplorerApi.IApiRegisterClient` that extenders can use
     *          to access the Zowe Explorer APIs or `undefined`. Also `undefined` if requiredVersion
     *          is larger than the version of Zowe Explorer found.
     */
    static getZoweExplorerApi(requiredVersion?: string): ZoweExplorerApi.IApiRegisterClient;
    /**
     * Show a message within VS Code dialog, and log it to an Imperative logger
     * @param message The message to display
     * @param severity The level of severity for the message (see `MessageSeverity`)
     * @param logger The IZoweLogger object for logging the message
     *
     * @deprecated Please use `Gui.showMessage` instead
     */
    static showVsCodeMessage(message: string, severity: MessageSeverity, logger: IZoweLogger): void;
    /**
     * Opens an input box dialog within VS Code, given an options object
     * @param inputBoxOptions The options for this input box
     *
     * @deprecated Use `Gui.showInputBox` instead
     */
    static inputBox(inputBoxOptions: vscode.InputBoxOptions): Promise<string>;
    /**
     * Helper function to standardize the way we ask the user for credentials
     * @param options Set of options to use when prompting for credentials
     * @returns Instance of imperative.IProfileLoaded containing information about the updated profile
     * @deprecated
     */
    static promptCredentials(options: IPromptCredentialsOptions): Promise<imperative.IProfileLoaded>;
    /**
     * Helper function to standardize the way we ask the user for credentials that updates ProfilesCache
     * @param options Set of options to use when prompting for credentials
     * @returns Instance of imperative.IProfileLoaded containing information about the updated profile
     */
    static updateCredentials(options: IPromptCredentialsOptions, apiRegister: ZoweExplorerApi.IApiRegisterClient): Promise<imperative.IProfileLoaded>;
    /**
     * Trigger a login operation with the merged contents between the service profile and the base profile.
     *  If the connection details (host:port) do not match (service vs base), the token will be stored in the service profile.
     *  If there is no API registered for the profile type, this method defaults the login behavior to that of the APIML.
     * @param serviceProfile Profile to be used for login pursposes (either the name of the IProfileLoaded instance)
     * @param loginTokenType The tokenType value for compatibility purposes
     * @param node The node for compatibility purposes
     * @param zeRegister The ZoweExplorerApiRegister instance for compatibility purposes
     * @param zeProfiles The Zowe Explorer "Profiles.ts" instance for compatibility purposes
     */
    static loginWithBaseProfile(serviceProfile: string | imperative.IProfileLoaded, loginTokenType?: string, node?: IZoweNodeType, zeRegister?: ZoweExplorerApi.IApiRegisterClient, // ZoweExplorerApiRegister
    zeProfiles?: ProfilesCache): Promise<boolean>;
    /**
     * Trigger a logout operation with the merged contents between the service profile and the base profile.
     *  If the connection details (host:port) do not match (service vs base), the token will be removed from the service profile.
     *  If there is no API registered for the profile type, this method defaults the logout behavior to that of the APIML.
     * @param serviceProfile Profile to be used for logout pursposes (either the name of the IProfileLoaded instance)
     * @param zeRegister The ZoweExplorerApiRegister instance for compatibility purposes
     * @param zeProfiles The Zowe Explorer "Profiles.ts" instance for compatibility purposes
     */
    static logoutWithBaseProfile(serviceProfile: string | imperative.IProfileLoaded, zeRegister?: ZoweExplorerApi.IApiRegisterClient, // ZoweExplorerApiRegister
    zeProfiles?: ProfilesCache): Promise<void>;
    /**
     * This method is intended to be used for authentication (login, logout) purposes
     *
     * Note: this method calls the `getProfileInfo()` which creates a new instance of the ProfileInfo APIs
     *          Be aware that any non-saved updates will not be considered here.
     * @param cache Instance of ProfilesCache already initialized
     * @param profile Name of the profile to load the IProfileLoaded
     * @returns The IProfileLoaded with tokenType and tokenValue
     */
    private static getServiceProfileForAuthPurposes;
    private static saveCredentials;
    private static promptUserPass;
}
