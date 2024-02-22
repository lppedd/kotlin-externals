import { ICommandDefinition } from "../../doc/ICommandDefinition";
/**
 * The input parameters to the help generator - the command definition and the tree.
 * @export
 * @interface IHelpGeneratorParms
 */
export interface IHelpGeneratorParms {
    /**
     * The command node for the command currently being issued.
     * @type {ICommandDefinition}
     * @memberof IHelpGeneratorFactoryParms
     */
    commandDefinition: ICommandDefinition;
    /**
     * The entire command tree (which includes the command node for the command being issued)
     * @type {ICommandDefinition}
     * @memberof IHelpGeneratorFactoryParms
     */
    fullCommandTree: ICommandDefinition;
    /**
     * The description text for what "experimental" means in the context of your CLI
     * @type {string}
     * @memberof IHelpGeneratorParms
     */
    experimentalCommandsDescription?: string;
    /**
     * The indicator that the given help generator should skip introducing breaks based on terminal width
     * @type {boolean}
     * @memberof IHelpGeneratorParms
     */
    skipTextWrap?: boolean;
}
