@file:JsModule("@zowe/core-for-zowe-sdk")

package zowe.sdk.core.apiml

import js.promise.Promise
import zowe.imperative.config.doc.IConfig
import zowe.imperative.error.ImperativeError
import zowe.imperative.rest.session.AbstractSession
import zowe.sdk.core.apiml.doc.IApimlProfileInfo
import zowe.sdk.core.apiml.doc.IApimlSvcAttrsLoaded

/**
 * Class to handle listing services on APIML gateway.
 */
external class Services {
  companion object {
    /**
     * Forms a list of APIML service attributes needed to query APIML for every
     * REST service for every loaded command group. This information can later
     * be used to create every connection profile required for every loaded
     * command group.
     *
     * @throws [ImperativeError] When Imperative.init() has not been called
     *                           before getPluginApimlConfigs().
     * @return The APIML service attributes needed to query APIML.
     */
    fun getPluginApimlConfigs(): Array<IApimlSvcAttrsLoaded>

    /**
     * Calls the services endpoint of the APIML gateway to obtain a list of
     * services that support Single Sign-On. This list is compared against a
     * list of APIML service attributes defined in CLI plug-in configs. When a
     * service's API ID is present in both lists, a profile info object is
     * generated to store CLI profile info for connecting to that service.
     *
     * @param session Session with APIML connection info
     * @param configs APIML service attributes defined by CLI plug-ins
     * @throws [ImperativeError] When session object is undefined or missing
     *                           authentication info, or the REST request fails
     * @return List of objects containing profile info for APIML services
     */
    fun getServicesByConfig(
      session: AbstractSession,
      configs: Array<IApimlSvcAttrsLoaded>,
    ): Promise<Array<IApimlProfileInfo>>

    /**
     * Converts apiml profile information to team config profile objects to be stored in a zowe.config.json file
     *
     * @param profileInfoList List of apiml profiles
     * @return List of config profile objects
     *
     * Example:
     * ```
     *  Input: IApimlProfileInfo[] = [
     *      {
     *          profName: 'zosmf',
     *          profType: 'zosmf',
     *          basePaths: [ '/zosmf/api/v1' ],
     *          pluginConfigs: Set(1) { [IApimlSvcAttrsLoaded] },
     *          conflictTypes: [ 'profType' ]
     *      },
     *      {
     *          profName: 'ibmzosmf',
     *          profType: 'zosmf',
     *          basePaths: [ '/ibmzosmf/api/v1' ],
     *          pluginConfigs: Set(1) { [IApimlSvcAttrsLoaded] },
     *          conflictTypes: [ 'profType' ]
     *      }
     *  ]
     *  Output: IConfig = {
     *      "profiles": {
     *          "zosmf": {
     *              "type": "zosmf",
     *              "properties": {
     *                  "basePath": "/zosmf/api/v1"
     *              }
     *          },
     *          "ibmzosmf": {
     *              "type": "zosmf",
     *              "properties": {
     *                  "basePath": "/ibmzosmf/api/v1"
     *              }
     *          }
     *      },
     *      "defaults": {
     *          // Multiple services were detected.
     *          // Uncomment one of the lines below to set a different default
     *          //"zosmf": "ibmzosmf"
     *          "zosmf": "zosmf"
     *      }
     *  }
     * ```
     */
    fun convertApimlProfileInfoToProfileConfig(profileInfoList: Array<IApimlProfileInfo>): IConfig
  }
}
