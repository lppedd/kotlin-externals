import { IPartialCommandDefinition } from "../../IPartialCommandDefinition";
export interface ICommandProfileAuthConfig {
    /**
     * Name of the authentication service
     */
    serviceName: string;
    /**
     * Path to the handler for the authentication service.
     * The handler should inherit from Imperative BaseAuthHandler.
     */
    handler: string;
    /**
     * Command properties for `auth login <serviceName>`
     */
    login?: IPartialCommandDefinition;
    /**
     * Command properties for `auth logout <serviceName>`
     */
    logout?: IPartialCommandDefinition;
}
