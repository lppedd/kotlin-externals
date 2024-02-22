import { ImperativeConfig } from "../ImperativeConfig";
import { IWebDiffGenerator } from "./doc/IWebDiffGenerator";
/**
 * Imperative web diff generator. Accepts the diffContent and constructs
 * the whole webb diff browser view
 *
 * @export
 * @class WebDiffGenerator
 */
declare class WebDiffGenerator implements IWebDiffGenerator {
    /**
     * Imperative config containing data about the CLI
     * @private
     * @memberof WebDiffGenerator
     */
    private mConfig;
    private webDiffDir;
    /**
     * Create an instance of WebDiffGenerator.
     * @param {ImperativeConfig} - Imperative config containing data about the CLI
     * @param {string} - Output directory for web diff files
     */
    constructor(config: ImperativeConfig, webDiffDir: string);
    /**
     * Diff directory builder at the cli home to open the diff strings comparison
     * in the browser.
     */
    buildDiffDir(): Promise<void>;
}
export default WebDiffGenerator;
