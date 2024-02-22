import { IPartialCommandDefinition } from "../../../cmd";
export interface IImperativeAuthGroupConfig {
    /**
     * Command definition for "auth" command group
     */
    authGroup?: IPartialCommandDefinition;
    /**
     * Command definition for "auth login" command group
     */
    loginGroup?: IPartialCommandDefinition;
    /**
     * Command definition for "auth logout" command group
     */
    logoutGroup?: IPartialCommandDefinition;
}
