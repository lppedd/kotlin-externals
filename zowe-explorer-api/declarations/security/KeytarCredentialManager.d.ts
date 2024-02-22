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
/// <reference types="node" />
import { imperative } from "@zowe/cli";
export declare type KeytarModule = {
    deletePassword: (service: string, account: string) => Promise<boolean>;
    findPassword: (service: string, account: string) => Promise<string | null>;
    findCredentials: (name: string) => Promise<{
        account: string;
        password: string;
    }[]>;
    getPassword: (service: string, account: string) => Promise<string | null>;
    setPassword: (service: string, account: string, password: string) => Promise<void>;
};
/**
 * Keytar - Securely store user credentials in the system keychain
 *
 * @export
 * @class KeytarCredentialManager
 */
export declare class KeytarCredentialManager extends imperative.AbstractCredentialManager {
    /**
     * Reference to the lazily loaded keytar module.
     *
     * @public
     */
    static keytar: KeytarModule;
    /**
     * Combined list of services that credentials may be stored under
     */
    private allServices;
    /**
     * Preferred service name to store credentials with
     */
    private preferredService;
    /**
     * Pass-through to the superclass constructor.
     *
     * @param {string} service The service string to send to the superclass constructor.
     * @param {string} displayName The display name for this credential manager to send to the superclass constructor
     */
    constructor(service: string, displayName: string);
    static getSecurityModules(moduleName: string, isTheia: boolean): NodeModule | undefined;
    /**
     * Calls the keytar deletePassword service with {@link DefaultCredentialManager#service} and the
     * account passed to the function by Imperative.
     *
     * @param {string} account The account for which to delete the password
     *
     * @returns {Promise<void>} A promise that the function has completed.
     *
     * @throws {@link imperative.ImperativeError} if keytar is not defined.
     * @throws {@link imperative.ImperativeError} when keytar.deletePassword returns false.
     */
    protected deleteCredentials(account: string): Promise<void>;
    /**
     * Calls the keytar getPassword service with {@link DefaultCredentialManager#service} and the
     * account passed to the function by Imperative.
     *
     * @param {string} account The account for which to get credentials
     * @param {boolean} optional Set to true if failure to find credentials should be ignored
     * @returns {Promise<imperative.SecureCredential>} A promise containing the credentials stored in keytar.
     *
     * @throws {@link imperative.ImperativeError} if keytar is not defined.
     * @throws {@link imperative.ImperativeError} when keytar.getPassword returns null or undefined.
     */
    protected loadCredentials(account: string, optional?: boolean): Promise<imperative.SecureCredential>;
    /**
     * Calls the keytar setPassword service with {@link DefaultCredentialManager#service} and the
     * account and credentials passed to the function by Imperative.
     *
     * @param {string} account The account to set credentials
     * @param {imperative.SecureCredential} credentials The credentials to store
     *
     * @returns {Promise<void>} A promise that the function has completed.
     *
     * @throws {@link imperative.ImperativeError} if keytar is not defined.
     */
    protected saveCredentials(account: string, credentials: imperative.SecureCredential): Promise<void>;
    private deleteCredentialsHelper;
    private getMissingEntryMessage;
}
/**
 * Imports the necessary security modules
 */
export declare function getSecurityModules(moduleName: string, isTheia: boolean): NodeModule | undefined;
