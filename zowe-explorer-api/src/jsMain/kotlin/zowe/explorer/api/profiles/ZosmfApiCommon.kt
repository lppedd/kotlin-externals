@file:JsModule("@zowe/zowe-explorer-api")

package zowe.explorer.api.profiles

import js.promise.Promise
import zowe.imperative.cmd.doc.args.ICommandArguments
import zowe.imperative.profiles.doc.response.IProfileLoaded
import zowe.imperative.rest.session.Session

/**
 * An implementation of the Zowe Explorer API Common interface for zOSMF.
 */
abstract external class ZosmfApiCommon : ZoweExplorerApi.ICommon {
  constructor(profile: IProfileLoaded = definedExternally)

  override var profile: IProfileLoaded?

  override fun getProfileTypeName(): String

  override fun getSessionFromCommandArgument(cmdArgs: ICommandArguments): Session

  override fun getSession(profile: IProfileLoaded): Session

  fun getStatus(
    validateProfile: IProfileLoaded = definedExternally,
    profileType: String = definedExternally,
  ): Promise<String>

  override fun getStatus(
    profile: IProfileLoaded,
    profileType: Any?,
  ): Promise<String>

  override fun getTokenTypeName(): String

  override fun login(session: Session): Promise<String>

  override fun logout(session: Session): Promise<Unit>

  companion object {
    fun getProfileTypeName(): String
  }
}
