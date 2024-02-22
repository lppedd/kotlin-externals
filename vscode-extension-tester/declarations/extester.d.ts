/// <reference types="mocha" />
import { ReleaseQuality, RunOptions } from './util/codeUtil';
export { ReleaseQuality };
export { MochaOptions } from 'mocha';
export * from './browser';
export * from './suite/mochaHooks';
export * from 'monaco-page-objects';
export interface SetupOptions {
    /** version of VS Code to test against, defaults to latest */
    vscodeVersion?: string;
    /** when true run `vsce package` with the `--yarn` flag */
    useYarn?: boolean;
    /** install the extension's dependencies from the marketplace. Defaults to `false`. */
    installDependencies?: boolean;
}
export declare const DEFAULT_SETUP_OPTIONS: {
    vscodeVersion: string;
    installDependencies: boolean;
};
export declare const DEFAULT_STORAGE_FOLDER: string;
export declare const VSCODE_VERSION_MIN = "1.84.2";
export declare const VSCODE_VERSION_MAX = "1.86.2";
/**
 * The latest version of NodeJS which is properly working with selenium-webdriver
 * (for more details, see https://www.npmjs.com/package/selenium-webdriver?activeTab=readme#node-support-policy)
 */
export declare const NODEJS_VERSION_MAX = "18.15.0";
/**
 * ExTester
 */
export declare class ExTester {
    private code;
    private chrome;
    constructor(storageFolder?: string, releaseType?: ReleaseQuality, extensionsDir?: string);
    /**
     * Download VSCode of given version and release quality stream
     * @param version version to download, default latest
     */
    downloadCode(version?: string): Promise<void>;
    /**
     * Install the extension into the test instance of VS Code
     * @param vsixFile path to extension .vsix file. If not set, default vsce path will be used
     * @param useYarn when true run `vsce package` with the `--yarn` flag
     */
    installVsix({ vsixFile, useYarn, installDependencies }?: {
        vsixFile?: string;
        useYarn?: boolean;
        installDependencies?: boolean;
    }): Promise<void>;
    /**
     * Install an extension from VS Code marketplace into the test instance
     * @param id id of the extension to install
     */
    installFromMarketplace(id: string): Promise<void>;
    /**
     * Download the matching chromedriver for a given VS Code version
     * @param vscodeVersion selected versio nof VSCode, default latest
     */
    downloadChromeDriver(vscodeVersion?: string): Promise<string>;
    /**
     * Performs all necessary setup: getting VSCode + ChromeDriver
     * and packaging/installing extension into the test instance
     *
     * @param options Additional options for setting up the tests
     */
    setupRequirements(options?: SetupOptions, offline?: boolean): Promise<void>;
    /**
     * Performs requirements setup and runs extension tests
     *
     * @param testFilesPattern glob pattern(s) for test files to run
     * @param vscodeVersion version of VS Code to test against, defaults to latest
     * @param setupOptions Additional options for setting up the tests
     * @param runOptions Additional options for running the tests
     *
     * @return Promise resolving to the mocha process exit code - 0 for no failures, 1 otherwise
     */
    setupAndRunTests(testFilesPattern: string | string[], vscodeVersion?: string, setupOptions?: Omit<SetupOptions, "vscodeVersion">, runOptions?: Omit<RunOptions, "vscodeVersion">): Promise<number>;
    /**
     * Runs the selected test files in VS Code using mocha and webdriver
     * @param testFilesPattern glob pattern(s) for selected test files
     * @param runOptions Additional options for running the tests
     *
     * @return Promise resolving to the mocha process exit code - 0 for no failures, 1 otherwise
     */
    runTests(testFilesPattern: string | string[], runOptions?: RunOptions): Promise<number>;
}
export declare function loadCodeVersion(version: string | undefined): string;
