package zowe.imperative.profiles.doc.parms

import zowe.imperative.logger.Logger
import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration

/**
 * Constructor parameters for the Profile Manager - Populated by the Imperative API methods (if
 * invoked from your CLI app) OR you can invoke the manager directly (assuming you supply all
 * required parms).
 */
external interface IProfileManager<T : IProfileTypeConfiguration> {
  /**
   * The profiles directory (normally obtained from the Imperative config). The profile root
   * directory contains a list of type directories, within each will be the profiles of that type
   * and the meta file. The meta file for a type contains the default specifications and the profile
   * type configuration document. Use the "initialize" API method on the Profile Manager to create
   * the appropriate structure based on your configuration documents.
   */
  var profileRootDirectory: String

  /**
   * The profile type for this manager - the configuration document for the type can either be
   * supplied on the "typeConfigurations" property on this object OR the mananger will attempt to
   * extract it from the profile root directory type meta file. If the type configuration cannot be
   * located, an exception will be thrown.
   */
  var type: String

  /**
   * The logger object to use in the profile manager. Normally the imperative logger, but can be any
   * arbitrary log4js logger.
   */
  var logger: Logger?

  /**
   * Contains all profile type configuration documents - used to obtain the schema for the profile
   * type passed on the profile manager and for dependency loading of profiles of other types.
   *
   * If this parameter is NOT supplied to the constructor of the Profile Manager, the manager will
   * attempt to read the configurations from each of the profile type meta files when the object is
   * being instaitiated. If it fails to locate a configuration for the profile type specified,
   * manager creation will fail. You can either supply the configurations to the constructor OR
   * execute the "initialize" static API to create all type directories and their meta configuration
   * files.
   */
  var typeConfigurations: Array<T>?

  /**
   * Map of which profile types have been loaded so far, to avoid circular profile loads Used
   * internally by profile manager classes
   */
  var loadCounter: Map<String, Double>?

  /**
   * Product display name of CLI
   */
  var productDisplayName: String?
}
