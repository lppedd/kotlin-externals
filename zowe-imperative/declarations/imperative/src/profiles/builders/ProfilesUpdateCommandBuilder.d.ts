import { ProfilesCommandBuilder } from "./ProfilesCommandBuilder";
import { ICommandDefinition } from "../../../../cmd";
/**
 * Used to build profile update command definitions.
 * Used automatically if you allow the "profiles" command group to be generated
 */
export declare class ProfilesUpdateCommandBuilder extends ProfilesCommandBuilder {
    /**
     * Gets the "action" that this command builder is building.
     * @return {string}: The "create" action string
     */
    getAction(): string;
    /**
     * Build the full command - includes action group and object command.
     * @return {ICommandDefinition}: The command definition.
     */
    buildFull(): ICommandDefinition;
    /**
     * Builds only the "profile" segment from the profile schema.
     * @return {ICommandDefinition}
     */
    protected buildProfileSegmentFromSchema(): ICommandDefinition;
}
