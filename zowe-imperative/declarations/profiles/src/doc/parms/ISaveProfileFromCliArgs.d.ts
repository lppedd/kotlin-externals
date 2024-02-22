import { Arguments } from "yargs";
import { ISaveProfile } from "./ISaveProfile";
/**
 * Parameters for creating a profile from command line arguments - normally invoked from a command handler that
 * is pre-built by imperative.
 * @export
 * @interface ICreateProfileFromArgs
 */
export interface ISaveProfileFromCliArgs extends ISaveProfile {
    /**
     * The Yargs style arguments - supplied from the command invocation.
     * @type {Arguments}
     * @memberof ISaveProfileFromCliArgs
     */
    args?: Arguments;
}
