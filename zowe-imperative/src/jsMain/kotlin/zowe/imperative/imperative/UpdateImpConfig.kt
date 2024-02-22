@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative

import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration

/**
 * This class is used to update the imperative config object, that was initially loaded by the
 * Imperative module. It exists in a separate module to avoid cyclic dependencies that would occur
 * if the functions lived in the Imperative module.
 */
external class UpdateImpConfig {
  companion object {
    /**
     * Add a new command group by inserting it to the definitions list of the loaded config.
     *
     * @param cmdDefToAdd command definition group to to be added.
     */
    fun addCmdGrp(cmdDefToAdd: ICommandDefinition)

    /**
     * Add a new set of profiles by inserting them into the profiles of the loaded config.
     *
     * @param profiles Array of profiles to be added.
     */
    fun addProfiles(profiles: Array<ICommandProfileTypeConfiguration>)
  }
}
