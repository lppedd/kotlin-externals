import { CodeUtil, ReleaseQuality } from '../util/codeUtil';
import { logging } from 'selenium-webdriver';
/**
 * Mocha runner wrapper
 */
export declare class VSRunner {
    private mocha;
    private chromeBin;
    private customSettings;
    private codeVersion;
    private cleanup;
    private tmpLink;
    private releaseType;
    constructor(bin: string, codeVersion: string, customSettings: Object | undefined, cleanup: boolean | undefined, releaseType: ReleaseQuality, config?: string);
    /**
     * Set up mocha suite, add vscode instance handling, run tests
     * @param testFilesPattern glob pattern of test files to run
     * @param logLevel The logging level for the Webdriver
     * @return The exit code of the mocha process
     */
    runTests(testFilesPattern: string[], code: CodeUtil, logLevel: logging.Level | undefined, resources: string[]): Promise<number>;
    private createShortcut;
    private loadConfig;
}
