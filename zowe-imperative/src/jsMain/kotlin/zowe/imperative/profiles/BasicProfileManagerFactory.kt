@file:JsModule("@zowe/imperative")

package zowe.imperative.profiles

import zowe.imperative.profiles.abstract.AbstractProfileManagerFactory
import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration

/**
 * A basic profile mananger factory - returns instances of profile
 * managers depending on the types passed.
 */
external class BasicProfileManagerFactory : AbstractProfileManagerFactory<IProfileTypeConfiguration> {
  /**
   * Creates an instance of BasicProfileManagerFactory.
   *
   * @param profilesRootDirectory The root directory to find your profiles
   */
  constructor(
    profilesRootDirectory: String,
    typeConfigurations: Array<IProfileTypeConfiguration> = definedExternally,
  )

  /**
   * Returns a new instance of the basic profile manager for the type.
   *
   * @param type the profile type to manager.
   * @return The profile manager instance for the type.
   */
  override fun getManager(type: String): BasicProfileManager<IProfileTypeConfiguration>
}
