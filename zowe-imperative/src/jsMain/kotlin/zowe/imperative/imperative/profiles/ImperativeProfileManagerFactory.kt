@file:JsModule("@zowe/imperative")

package zowe.imperative.imperative.profiles

import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.cmd.profiles.CliProfileManager
import zowe.imperative.imperative.api.ImperativeApi
import zowe.imperative.profiles.abstract.AbstractProfileManagerFactory

/**
 * The imperative profile manager factory returns instances of the cli profile manager
 */
external class ImperativeProfileManagerFactory : AbstractProfileManagerFactory<ICommandProfileTypeConfiguration> {
  constructor(imperativeApi: ImperativeApi)

  /**
   * Returns a instance of the CliProfileManager
   *
   * @param type The profile type you want to manage.
   * @return The profile manager instance
   */
  override fun getManager(type: String): CliProfileManager
}
