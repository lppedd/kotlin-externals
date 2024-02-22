import { IPartialCommandDefinition } from "../../IPartialCommandDefinition";
export interface ICommandProfileAutoInitConfig {
    /**
     * Path to the handler for the authentication service.
     * The handler should inherit from Imperative BaseAuthHandler.
     */
    handler: string;
    /**
     * The provider giving connection information and details for the automatically generated config
     */
    provider: string;
    /**
     * Command properties for `config auto-init`
     */
    autoInit?: IPartialCommandDefinition;
    /**
     * The type of profile associated with the provider, if any
     */
    profileType?: string;
}
