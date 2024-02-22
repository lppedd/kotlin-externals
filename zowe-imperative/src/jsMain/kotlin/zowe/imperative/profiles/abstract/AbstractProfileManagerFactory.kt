@file:JsModule("@zowe/imperative")

package zowe.imperative.profiles.abstract

import zowe.imperative.profiles.doc.api.IProfileManagerFactory
import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration

/**
 * Abstract profile manager (implemented by imperative, etc.)
 */
abstract external class AbstractProfileManagerFactory<T : IProfileTypeConfiguration> : IProfileManagerFactory<T> {
  /**
   * Returns and instance of the profile manager for the type specified.
   *
   * @param type the profile type
   * @return The manager
   */
  override fun getManager(type: String): AbstractProfileManager<T>
}
