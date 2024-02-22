package zowe.explorer.api.tree

import vscode.TreeItem
import zowe.imperative.profiles.doc.response.IProfileLoaded

/**
 * APIs that allow accessing the Zowe Explorer tree.
 * (Currently being explored and can at any time.)
 *
 * To use you need to retrieve and cast the Zowe Extender object that implements it:
 *
 * Example:
 * ```
 * const explorerApi = extensions.getExtension('zowe.vscode-extension-for-zowe');\
 * if (explorerApi && explorerApi.exports) {\
 *   // Cast the returned object to the IApiRegisterClient interface\
 *   const importedApi: ZoweExplorerApi.IApiRegisterClient = explorerApi.exports;\
 *   const extenderTreeApi = (importedApi as unknown) as ZoweExplorerTreeApi;\
 *   // create an instance of my API and register it with Zowe Explorer\
 *   importedApi.registerUssApi(new MyZoweExplorerAppUssApi());\
 *   window.showInformationMessage(\
 *     'Zowe Explorer was augmented for MyApp support. Please, refresh your explorer views.');\
 *   } else {\
 *   window.showInformationMessage(\
 *     'Zowe VS Extension was not found: either not install or older version.');\
 * }
 * ```
 */
external interface ZoweExplorerTreeApi {
  /**
   * Used by other VS Code Extensions to access the primary profile.
   *
   * @param primaryNode represents the Tree item that is being used
   * @return The requested profile
   */
  fun getProfile(primaryNode: TreeItem): IProfileLoaded
}
