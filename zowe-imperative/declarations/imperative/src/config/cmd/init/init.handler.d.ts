import { ICommandHandler, IHandlerParameters } from "../../../../../cmd";
/**
 * Init config
 */
export default class InitHandler implements ICommandHandler {
    private params;
    /**
     * List of property names that have been prompted for.
     */
    private promptProps;
    /**
     * Process the command and input.
     *
     * @param {IHandlerParameters} params Parameters supplied by yargs
     *
     * @throws {ImperativeError}
     */
    process(params: IHandlerParameters): Promise<void>;
    /**
     * Creates JSON template for config. Also creates a schema file in the same
     * folder alongside the config.
     * @param config Config object to be populated
     * @param user If true, properties will be left empty for user config
     */
    private initWithSchema;
    /**
     * Do a dry run of creating JSON template for config.
     * Also create a schema file in the same folder alongside the config.
     * @param config Config object to be populated
     * @param user If true, properties will be left empty for user config
     */
    private initForDryRun;
    /**
     * Prompts for the value of a property on the CLI. Returns null if `--prompt false`
     * argument is passed, or prompt times out, or a blank value is entered.
     * @param propName The name of the property
     * @param property The profile property definition
     */
    private promptForProp;
}
