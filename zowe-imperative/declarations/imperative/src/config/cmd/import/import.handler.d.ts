import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * Import config
 */
export default class ImportHandler implements ICommandHandler {
    private params;
    /**
     * Process the command and input.
     *
     * @param {IHandlerParameters} params Parameters supplied by yargs
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
    /**
     * Build a session from a URL and command line arguments.
     * @param url Web URL of the config JSON file
     * @returns Populated session object
     */
    private buildSession;
    /**
     * Download the config from a URL
     * @param url Web URL of the config JSON file
     * @returns Parsed config object
     */
    private fetchConfig;
    /**
     * Download the config schema from a URL to disk
     * @param url Web URL of the schema JSON file
     * @param filePath Local path to download to
     */
    private downloadSchema;
}
