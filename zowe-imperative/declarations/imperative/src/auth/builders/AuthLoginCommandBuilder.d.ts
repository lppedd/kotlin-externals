import { AuthCommandBuilder } from "./AuthCommandBuilder";
import { ICommandDefinition } from "../../../../cmd";
/**
 * Used to build auth login command definitions.
 * Used automatically if you allow the "auth" command group to be generated
 */
export declare class AuthLoginCommandBuilder extends AuthCommandBuilder {
    /**
     * Gets the "action" that this command builder is building.
     * @return {string}: The "login" action string
     */
    getAction(): string;
    /**
     * Build the full command - includes action group and object command.
     * @return {ICommandDefinition}: The command definition.
     */
    buildFull(): ICommandDefinition;
    /**
     * Builds only the "auth" segment from the auth config.
     * @return {ICommandDefinition}
     */
    protected buildAuthSegmentFromConfig(): ICommandDefinition;
}
