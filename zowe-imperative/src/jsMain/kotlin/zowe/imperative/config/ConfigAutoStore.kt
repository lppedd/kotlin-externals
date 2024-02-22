@file:JsModule("@zowe/imperative")

package zowe.imperative.config

import js.array.JsTuple2
import js.objects.Record
import js.promise.Promise
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.cmd.doc.handler.IHandlerParameters
import zowe.imperative.config.doc.IConfigAutoStoreStoreSessCfgPropsOpts
import zowe.imperative.imperative.auth.handlers.AbstractAuthHandler

/**
 * Class to manage automatic storage of properties in team config.
 */
external class ConfigAutoStore {
  companion object {
    /**
     * Finds the profile where auto-store properties should be saved.
     *
     * @param params CLI handler parameters object
     * @param profileProps List of properties required in the profile schema
     * @return Tuple containing profile type and name, or undefined if no profile was found
     */
    fun findActiveProfile(
      params: IHandlerParameters,
      profileProps: Array<String>,
    ): JsTuple2<String, String>?

    /**
     * Finds the token auth handler class for a team config profile.
     *
     * @param profilePath JSON path of profile
     * @param cmdArguments CLI arguments which may specify a profile
     * @return Auth handler class or undefined if none was found
     */
    fun findAuthHandlerForProfile(
      profilePath: String,
      cmdArguments: ICommandArguments,
    ): AbstractAuthHandler?

    /**
     * Stores session config properties into a team config profile.
     *
     * @param params CLI handler parameters object
     * @param sessCfg Session config containing properties to store
     * @param propsToStore Names of properties that should be stored
     */
    fun storeSessCfgProps(
      params: IHandlerParameters,
      sessCfg: Record<String, Any>,
      propsToStore: Array<String>,
    ): Promise<Unit>

    /**
     * Stores session config properties into a team config profile.
     *
     * @param opts Set of options required to store session config properties
     */
    fun _storeSessCfgProps(opts: IConfigAutoStoreStoreSessCfgPropsOpts): Promise<Unit>
  }
}
