import { logging } from "selenium-webdriver";
export declare enum ReleaseQuality {
    Stable = "stable",
    Insider = "insider"
}
export interface RunOptions {
    /** version of VS Code to test against, defaults to latest */
    vscodeVersion?: string;
    /** path to custom settings json file */
    settings?: string;
    /** remove the extension's directory as well (if present) */
    cleanup?: boolean;
    /** path to a custom mocha configuration file */
    config?: string;
    /** logging level of the Webdriver */
    logLevel?: logging.Level;
    /** try to perform all setup without internet connection, needs all requirements pre-downloaded manually */
    offline?: boolean;
    /** list of resources to be opened by VS Code */
    resources: string[];
}
/** defaults for the [[RunOptions]] */
export declare const DEFAULT_RUN_OPTIONS: {
    vscodeVersion: string;
    settings: string;
    logLevel: logging.Level;
    offline: boolean;
    resources: never[];
};
/**
 * Handles the VS Code instance used for testing.
 * Includes downloading, unpacking, launching, and version checks.
 */
export declare class CodeUtil {
    private codeFolder;
    private downloadPlatform;
    private downloadFolder;
    private releaseType;
    private executablePath;
    private cliPath;
    private cliEnv;
    private availableVersions;
    private extensionsFolder;
    /**
     * Create an instance of code handler
     * @param folder Path to folder where all the artifacts will be stored.
     * @param extensionsFolder Path to use as extensions directory by VS Code
     */
    constructor(folder?: string, type?: ReleaseQuality, extensionsFolder?: string);
    /**
     * Get all versions for the given release stream
     */
    getVSCodeVersions(): Promise<string[]>;
    /**
     * Download and unpack VS Code for testing purposes
     *
     * @param version VS Code version to get, default latest
     */
    downloadVSCode(version?: string): Promise<void>;
    /**
     * Install your extension into the test instance of VS Code
     */
    installExtension(vsix?: string, id?: string): void;
    /**
     * Install extension dependencies from marketplace
     */
    installDependencies(): void;
    private installExt;
    /**
     * Open files/folders in running vscode
     * @param paths vararg paths to files or folders to open
     */
    open(...paths: string[]): void;
    /**
     * Download a vsix file
     * @param vsixURL URL of the vsix file
     */
    downloadExtension(vsixURL: string): Promise<string>;
    /**
     * Package extension into a vsix file
     * @param useYarn false to use npm as packaging system, true to use yarn instead
     */
    packageExtension(useYarn?: boolean): Promise<void>;
    /**
     * Uninstall the tested extension from the test instance of VS Code
     *
     * @param cleanup remove the extension's directory as well.
     */
    uninstallExtension(cleanup?: boolean): void;
    /**
     * Run tests in your test environment using mocha
     *
     * @param testFilesPattern glob pattern of test files to run
     * @param runOptions additional options for customizing the test run
     *
     * @return The exit code of the mocha process
     */
    runTests(testFilesPattern: string[], runOptions?: RunOptions): Promise<number>;
    /**
     * Finds the version of chromium used for given VS Code version.
     * Works only for versions 1.30+, older versions need to be checked manually
     *
     * @param codeVersion version of VS Code, default latest
     * @param quality release stream, default stable
     */
    getChromiumVersion(codeVersion?: string): Promise<string>;
    /**
     * Check if VS Code exists in local cache along with an appropriate version of chromedriver
     * without internet connection
     */
    checkOfflineRequirements(): Promise<string>;
    /**
     * Attempt to get chromium version from a downloaded copy of vs code
     */
    getChromiumVersionOffline(): Promise<string>;
    /**
     * Get the root folder of VS Code instance
     */
    getCodeFolder(): string;
    /**
     * Check if given version is available in the given stream
     */
    private checkCodeVersion;
    /**
     * Check what VS Code version is present in the testing folder
     */
    private getExistingCodeVersion;
    /**
     * Construct the platform string based on OS
     */
    private getPlatform;
    /**
     * Setup paths specific to used OS
     */
    private findExecutables;
    /**
     * Parse JSON from a file
     * @param path path to json file
     */
    private parseSettings;
}
