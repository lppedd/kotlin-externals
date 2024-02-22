import { IHelpGeneratorParms } from "./IHelpGeneratorParms";
import { IHelpGenerator } from "./IHelpGenerator";
/**
 * Help generator factory interface - implemented by the AbstractHelpGeneratorFactory (which is then extended
 * to suit the needs of the implementation)
 * @export
 * @interface IHelpGeneratorFactory
 */
export interface IHelpGeneratorFactory {
    /**
     * Create an instance of the help generator for the command.
     * @param {IHelpGeneratorParms} parms - The generator parameters - See Interface for details.
     * @returns {IHelpGenerator}
     * @memberof IHelpGeneratorFactory
     */
    getHelpGenerator(parms: IHelpGeneratorParms): IHelpGenerator;
}
