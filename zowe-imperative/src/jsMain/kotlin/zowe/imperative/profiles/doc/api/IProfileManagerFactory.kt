package zowe.imperative.profiles.doc.api

import zowe.imperative.profiles.abstract.AbstractProfileManager
import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration

/**
 * Profile manager factory inteface - implemented by the abstract profile manager in this profiles
 * package and created by Imperative and other packages that need to influence the way the profile
 * manager is allocated, configured.
 */
external interface IProfileManagerFactory<T : IProfileTypeConfiguration> {
  /**
   * Returns an instance of the profile manager specific to the "type" passed - types are defined by
   * Imeprative configuration/init
   *
   * @param type The profile type.
   * @return An instance of the profile manager.
   */
  fun getManager(type: String): AbstractProfileManager<T>
}
