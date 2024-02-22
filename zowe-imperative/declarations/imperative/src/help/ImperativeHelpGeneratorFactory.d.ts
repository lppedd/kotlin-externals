import { IHelpGenerator, IHelpGeneratorParms, AbstractHelpGeneratorFactory } from "../../../cmd";
import { IImperativeConfig } from "../doc/IImperativeConfig";
/**
 * Imperative Help generator factory passed to yargs to build help generators where needed.
 * @export
 * @class ImperativeHelpGeneratorFactory
 * @extends {AbstractHelpGeneratorFactory}
 */
export declare class ImperativeHelpGeneratorFactory extends AbstractHelpGeneratorFactory {
    /**
     * The imperative configuration object contains control parameters for the help generator factorys
     * @private
     * @type {IImperativeConfig}
     * @memberof ImperativeHelpGeneratorFactory
     */
    private mConfig;
    /**
     * Creates an instance of ImperativeHelpGeneratorFactory.
     * @param {string} rootCommandName - The root command name of your CLI.
     * @param {IImperativeConfig} config - The imperative configuration document for your CLI.
     * @memberof ImperativeHelpGeneratorFactory
     */
    constructor(rootCommandName: string, config: IImperativeConfig);
    /**
     * Obtains an instance of the help generator
     * @protected
     * @param {IHelpGeneratorParms} parms - See the interface for details
     * @returns {IHelpGenerator} - The help generator instance
     * @memberof ImperativeHelpGeneratorFactory
     */
    protected getGenerator(parms: IHelpGeneratorParms): IHelpGenerator;
    /**
     * Internal accessor for the configuration object
     * @readonly
     * @private
     * @type {IImperativeConfig}
     * @memberof ImperativeHelpGeneratorFactory
     */
    private get config();
}
