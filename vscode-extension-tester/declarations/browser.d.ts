/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License", destination); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import { WebDriver, logging } from '@redhat-developer/page-objects';
import { ReleaseQuality } from './util/codeUtil';
export declare class VSBrowser {
    static readonly baseVersion = "1.37.0";
    static readonly browserName = "vscode";
    private storagePath;
    private extensionsFolder;
    private customSettings;
    private _driver;
    private codeVersion;
    private releaseType;
    private logLevel;
    private static _instance;
    constructor(codeVersion: string, releaseType: ReleaseQuality, customSettings?: object, logLevel?: logging.Level);
    /**
     * Starts the vscode browser from a given path
     * @param codePath path to code binary
     */
    start(codePath: string): Promise<VSBrowser>;
    /**
     * Returns a reference to the underlying instance of Webdriver
     */
    get driver(): WebDriver;
    /**
     * Returns the vscode version as string
     */
    get version(): string;
    /**
     * Returns an instance of VSBrowser
     */
    static get instance(): VSBrowser;
    /**
     * Waits until parts of the workbench are loaded
     */
    waitForWorkbench(timeout?: number): Promise<void>;
    /**
     * Terminates the webdriver/browser
     */
    quit(): Promise<void>;
    /**
     * Take a screenshot of the browser
     * @param name file name of the screenshot without extension
     */
    takeScreenshot(name: string): Promise<void>;
    /**
     * Get a screenshots folder path
     * @returns string path to the screenshots folder
     */
    getScreenshotsDir(): string;
    /**
     * Open folder(s) or file(s) in the current instance of vscode.
     *
     * @param paths path(s) of folder(s)/files(s) to open as varargs
     * @returns Promise resolving when all selected resources are opened and the workbench reloads
     */
    openResources(...paths: string[]): Promise<void>;
}
