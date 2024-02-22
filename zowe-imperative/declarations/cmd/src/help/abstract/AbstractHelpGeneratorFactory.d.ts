import { IHelpGeneratorFactoryParms } from "../doc/IHelpGeneratorFactoryParms";
import { IHelpGeneratorFactory } from "../doc/IHelpGeneratorFactory";
import { IHelpGeneratorParms } from "../doc/IHelpGeneratorParms";
import { IHelpGenerator } from "../doc/IHelpGenerator";
/**
 * The abstract help generator factory class - implemented normally by imperative to provide the help generator
 * object that should be used for your CLI.
 * @export
 * @abstract
 * @class AbstractHelpGeneratorFactory
 */
export declare abstract class AbstractHelpGeneratorFactory implements IHelpGeneratorFactory {
    /**
     * The root command name of your CLI
     * @private
     * @type {string}
     * @memberof AbstractHelpGeneratorFactory
     */
    private mRootCommandName;
    /**
     * The primary highlight color - for terminal/console coloring
     * @private
     * @type {string}
     * @memberof AbstractHelpGeneratorFactory
     */
    private mPrimaryHighlightColor;
    /**
     * True to produce markdown instead of the "normal" help text
     * @private
     * @type {boolean}
     * @memberof AbstractHelpGeneratorFactory
     */
    private mProduceMarkdown;
    /**
     * The input parameters to the factory.
     * @private
     * @type {IHelpGeneratorFactoryParms}
     * @memberof AbstractHelpGeneratorFactory
     */
    private mParms;
    /**
     * Creates an instance of AbstractHelpGeneratorFactory.
     * @param {IHelpGeneratorFactoryParms} parms - Control parameters and inforamtion required to build help generators
     * @memberof AbstractHelpGeneratorFactory
     */
    constructor(parms: IHelpGeneratorFactoryParms);
    /**
     * Verifies the input parameters and returns the help generator instance for the command.
     * @param {IHelpGeneratorParms} parms - The input parameters - see interface for details.
     * @returns {IHelpGenerator}
     * @memberof AbstractHelpGeneratorFactory
     */
    getHelpGenerator(parms: IHelpGeneratorParms): IHelpGenerator;
    /**
     * Implement to return your specific help generator instance.
     * @abstract
     * @param {IHelpGeneratorParms} parms
     * @returns {IHelpGenerator} - The help generator for the command.
     * @memberof AbstractHelpGeneratorFactory
     */
    protected abstract getGenerator(parms: IHelpGeneratorParms): IHelpGenerator;
    /**
     * Accessor of the root command nae.
     * @readonly
     * @protected
     * @type {string}
     * @memberof AbstractHelpGeneratorFactory
     */
    protected get rootCommandName(): string;
    /**
     * Accessor for the primary highlight color
     * @readonly
     * @protected
     * @type {string}
     * @memberof AbstractHelpGeneratorFactory
     */
    protected get primaryHighlightColor(): string;
    /**
     * Accessor for the produce markdown flag
     * @readonly
     * @protected
     * @type {boolean}
     * @memberof AbstractHelpGeneratorFactory
     */
    protected get produceMarkdown(): boolean;
    /**
     * Accessor for the full list of parameters
     * @readonly
     * @protected
     * @type {IHelpGeneratorFactoryParms}
     * @memberof AbstractHelpGeneratorFactory
     */
    protected get factoryParameters(): IHelpGeneratorFactoryParms;
}
