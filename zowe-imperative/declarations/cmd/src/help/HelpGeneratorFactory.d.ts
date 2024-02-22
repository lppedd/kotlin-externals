import { AbstractHelpGeneratorFactory } from "./abstract/AbstractHelpGeneratorFactory";
import { DefaultHelpGenerator } from "./DefaultHelpGenerator";
import { IHelpGeneratorParms } from "./doc/IHelpGeneratorParms";
/**
 * The default help generator factory - always supplies the default help generator.
 * @export
 * @class HelpGeneratorFactory
 * @extends {AbstractHelpGeneratorFactory}
 */
export declare class HelpGeneratorFactory extends AbstractHelpGeneratorFactory {
    /**
     * Get an instance of the help generator
     * @param {IHelpGeneratorFactoryParms} parms - See the interface for details
     * @returns {DefaultHelpGenerator}
     * @memberof HelpGeneratorFactory
     */
    protected getGenerator(parms: IHelpGeneratorParms): DefaultHelpGenerator;
}
