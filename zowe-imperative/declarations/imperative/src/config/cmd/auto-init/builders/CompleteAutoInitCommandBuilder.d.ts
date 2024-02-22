import { ICommandDefinition } from "../../../../../../cmd";
import { Logger } from "../../../../../../logger/index";
import { ICommandProfileAutoInitConfig } from "../../../../../../cmd/src/doc/profiles/definition/ICommandProfileAutoInitConfig";
/**
 * Generate a complete command for automatic initialization of a user configuration
 */
export declare class CompleteAutoInitCommandBuilder {
    /**
     * Get the complete auth group of commands
     * @param {ICommandProfileAutoInitConfig} autoInitConfig - mapping of profile types to auto init configs
     * @param {Logger} logger - logger to use in the builder classes
     * @returns {ICommandDefinition} - the complete profile group of commands
     */
    static getAutoInitCommand(autoInitConfig: ICommandProfileAutoInitConfig, logger: Logger): ICommandDefinition;
}
