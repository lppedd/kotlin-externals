@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.auth.builders

import js.objects.Record
import zowe.imperative.cmd.doc.ICommandDefinition
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileAuthConfig
import zowe.imperative.imperative.doc.IImperativeAuthGroupConfig
import zowe.imperative.logger.Logger

/**
 * Generate a complete group of commands for logging in and out of services based on provided auth definitions.
 */
external class CompleteAuthGroupBuilder {
  companion object {
    /**
     * Get the complete auth group of commands
     *
     * @param authConfigs mapping of profile types to auth configs
     * @param logger logger to use in the builder classes
     * @param authGroupConfig config that allows command definitions to be overridden
     * @return the complete profile group of commands
     */
    fun getAuthGroup(
      authConfigs: Record<String, Array<ICommandProfileAuthConfig>>,
      logger: Logger,
      authGroupConfig: IImperativeAuthGroupConfig = definedExternally,
    ): ICommandDefinition
  }
}
