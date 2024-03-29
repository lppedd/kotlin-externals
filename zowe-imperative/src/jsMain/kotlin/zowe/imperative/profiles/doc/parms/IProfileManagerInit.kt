
package zowe.imperative.profiles.doc.parms

import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration
import kotlin.js.plain.JsPlainObject

/**
 * Parameters passed on the "basic profile manager" "initialize()" API. The initialization API
 * creates the entire profile directory structure and persists the configuration documents for each
 * type in their respective meta profile. The configuration documents are persisted for two reasons:
 *
 * 1) To help "external" invocations of the profile manager avoid having to provide the
 *    configuration documents. This makes constructing apps and editor extensions that depend on
 *    profiles much simpler and protects the profiles.
 * 2) Ensures a consistency between versions and updates to the profile structure - we can compare
 *    the persisted profiles against the configuration documents supplied when Imperative is
 *    initialized.
 */
@JsPlainObject
external interface IProfileManagerInit {
  /**
   * The full set of profile "type" configuration documents - Normally supplied by the CLI
   * definition document. See the interface for full details.
   */
  var configuration: Array<IProfileTypeConfiguration>

  /**
   * The root directory for the profile manager - this is where all type directories will be
   * initialized. The root is normally supplied on the configuration document for an Imperative CLI.
   */
  var profileRootDirectory: String

  /**
   * If true, will re-initialize and profile type directories found. If false, any existing
   * definitions/types/metas are not touched - Can be called during Imperative init with false, to
   * ensure that nothing is overwritten, but additional types are added as supplied.
   */
  var reinitialize: Boolean?
}
