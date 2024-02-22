import { IUpdateProfile } from "./IUpdateProfile";
import { Arguments } from "yargs";
/**
 * TODO - wasn't this moved???
 * @export
 * @interface IUpdateProfileFromCliArgs
 * @extends {IUpdateProfile}
 */
export interface IUpdateProfileFromCliArgs extends IUpdateProfile {
    args: Arguments;
}
