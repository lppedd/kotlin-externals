import { IProfileManagerFactory } from "../../../../../profiles";
import { Logger } from "../../../../../logger";
import { ICommandDefinition } from "../../ICommandDefinition";
import { ICommandProfileTypeConfiguration } from "../definition/ICommandProfileTypeConfiguration";
/**
 * Control parameters for the command profile loader.
 * @export
 * @interface ICommandProfileLoaderParms
 */
export interface ICommandProfileLoaderParms {
    /**
     * The command definition document which contains the profile specifications for the command.
     * @type {ICommandDefinition}
     * @memberof ICommandProfileLoaderParms
     */
    commandDefinition: ICommandDefinition;
    /**
     * The profile Manager factory to create profile manager instances depending on the profile types required
     * by the command.
     * @type {IProfileManagerFactory<ICommandProfileTypeConfiguration>}
     * @memberof ICommandProfileLoaderParms
     */
    profileManagerFactory: IProfileManagerFactory<ICommandProfileTypeConfiguration>;
    /**
     * Optional logger instance - if not supplied, then Logger.getImperativeLogger() is used.
     * @type {Logger}
     * @memberof ICommandProfileLoaderParms
     */
    logger?: Logger;
}
