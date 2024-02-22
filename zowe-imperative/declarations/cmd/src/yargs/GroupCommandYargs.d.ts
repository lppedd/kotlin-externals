import { AbstractCommandYargs, YargsCommandCompleted } from "./AbstractCommandYargs";
/**
 * Imperative define group command to Yargs - defines the group and it's children to Yargs.
 */
export declare class GroupCommandYargs extends AbstractCommandYargs {
    /**
     * Define the group and its children to Yargs.
     * @param {YargsCommandCompleted} commandExecuted: The callback when this command is executed.
     */
    defineCommandToYargs(commandExecuted: YargsCommandCompleted): void;
}
