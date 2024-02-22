import { ICommandDefinition, ICommandProfileTypeConfiguration } from "../../cmd";
/**
 * This class is used to update the imperative config object, that was initially
 * loaded by the Imperative module. It exists in a separate module to avoid
 * cyclic dependencies that would occur if the functions lived in the
 * Imperative module.
 */
export declare class UpdateImpConfig {
    /**
     * Add a new command group by inserting it to the definitions list of the loaded config.
     * @param {ICommandDefinition} cmdDefToAdd - command definition group to to be added.
     */
    static addCmdGrp(cmdDefToAdd: ICommandDefinition): void;
    /**
     * Add a new set of profiles by inserting them into the profiles of the loaded config.
     * @param {ICommandProfileTypeConfiguration[]} profiles
     *    Array of profiles to be added.
     */
    static addProfiles(profiles: ICommandProfileTypeConfiguration[]): void;
}
