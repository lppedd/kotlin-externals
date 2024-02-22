import { ICommandDefinition } from "../../../../cmd";
import { Logger } from "../../../../logger/index";
import { IProfileTypeConfiguration } from "../../../../profiles";
/**
 * Generate a complete group of commands for maintaining configuration profiles
 * based on provided profile definitions.
 */
export declare class CompleteProfilesGroupBuilder {
    /**
     * Get the complete profile group of commands
     * @param {ICommandProfileTypeConfiguration[]} profiles - the profile configurations to convert to commands
     * @param {Logger} logger - logger to use in the builder classes
     * @returns {ICommandDefinition} - the complete profile group of commands
     */
    static getProfileGroup(profiles: IProfileTypeConfiguration[], logger: Logger): ICommandDefinition;
}
