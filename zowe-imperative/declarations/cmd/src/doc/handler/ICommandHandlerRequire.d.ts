import { ICommandHandlerConstructor } from "./ICommandHandlerConstructor";
/**
 * This interface defines what the expected module.exports variable should be
 * for any defined handlers by an implementing cli.
 */
export interface ICommandHandlerRequire {
    /**
     * In TypeScript, doing an 'export default class' puts the export in exports.default. This takes
     * advantage of TypeScript language constructs and cleans up the code a bit.
     */
    default: ICommandHandlerConstructor;
}
