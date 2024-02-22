import { ICommandDefinition } from "../../../../cmd";
import { Logger } from "../../../../logger/index";
import { ICommandProfileAuthConfig } from "../../../../cmd/src/doc/profiles/definition/ICommandProfileAuthConfig";
import { IImperativeAuthGroupConfig } from "../../doc/IImperativeAuthGroupConfig";
/**
 * Generate a complete group of commands for logging in and out of services
 * based on provided auth definitions.
 */
export declare class CompleteAuthGroupBuilder {
    /**
     * Get the complete auth group of commands
     * @param {[key: string]: ICommandProfileAuthConfig} authConfigs - mapping of profile types to auth configs
     * @param {Logger} logger - logger to use in the builder classes
     * @param {IImperativeAuthGroupConfig} authGroupConfig - config that allows command definitions to be overridden
     * @returns {ICommandDefinition} - the complete profile group of commands
     */
    static getAuthGroup(authConfigs: {
        [key: string]: ICommandProfileAuthConfig[];
    }, logger: Logger, authGroupConfig?: IImperativeAuthGroupConfig): ICommandDefinition;
    private static defaultAuthGroup;
    private static defaultLoginGroup;
    private static defaultLogoutGroup;
}
