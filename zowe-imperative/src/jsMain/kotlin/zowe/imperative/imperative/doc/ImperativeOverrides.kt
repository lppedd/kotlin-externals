package zowe.imperative.imperative.doc

import zowe.imperative.interfaces.doc.IConstructor
import zowe.imperative.security.DefaultCredentialManager
import zowe.imperative.security.abstract.AbstractCredentialManager
import zowe.imperative.security.doc.ICredentialManagerConstructor

/**
 * This interface defines all the overrideable properties of an Imperative application. Each key in
 * this interface must adhere to the [IOverridesRestriction] interface to ensure that each key
 * defines a constructor.
 *
 * It has been decided that all overridable fields allow for an undefined value. If the value is
 * defined, then it must accept either a string type or an [IConstructor] type.This interface
 * only requires that each key be an IConstructor type. The capability for string and undefined
 * types is added in the declaration of the [IImperativeOverrides] type.
 */
external interface ImperativeOverrides : IOverridesRestriction {
  /**
   * A class that your Imperative CLI app can provide us in place of our [DefaultCredentialManager],
   * so that you can meet your security requirements. The provided class
   * must extend Imperative's [AbstractCredentialManager].
   *
   * There are 2 ways that you can specify your credential manager to us:
   * 1. If you are within any code statements, you can directly provide a class
   *    that adheres to the [ICredentialManagerConstructor]
   *    - [IImperativeConfig.configurationModule]
   *    - [Imperative.init]
   * 2. You can also provide a string specifying the location of a module to load.
   *
   * ### Directly Providing a Class (Way #1)
   *
   * This method is fairly straight forward as all that you need to do is provide the class name of
   * a class that adheres to the [ICredentialManagerConstructor].
   *
   * ### Specifying the Location of a Class Module (Way #2)
   *
   * This method is a bit more complicated compared to Way #1, but it allows for your package.json
   * to contain all of your necessary config. The string parameter can either be an absolute path
   * (for those cases where you want to have a bit more control by using `__dirname`) or a relative
   * path.
   *
   * In the case that the string is a relative path, it __MUST__ be a path relative to the entry
   * point of your CLI. (__NOTE:__ In the case of a plugin, this is relative to your require entry
   * point)
   *
   * For example:
   *
   * __Assume__
   * - `/` is the root of your project
   * - `/lib/index.js` is the compiled entry point of your project.
   * - `/lib/overrides/OverrideCredentialManager.js` is the compiled location of your credential
   *   manager
   *
   * __Then__
   * - `IImperativeOverrides.CredentialManager = "./overrides/OverrideCredentialManager";`
   *
   * #### Expected Format of Module File
   *
   * Imperative will expect that the file specified in the location string exports a class that
   * extends the {@link AbstractCredentialManager}. This can be done in TypeScript in one of the
   * following ways:
   *
   * _Exporting an Anonymous Class_
   *
   * ```TypeScript
   * export = class extends AbstractCredentialManager {
   *   // Code goes here
   * };
   * ```
   *
   * _Exporting a Named Class_
   *
   * ```TypeScript
   * export = class CredentialManager extends AbstractCredentialManager {
   *   // Code goes here
   * };
   * ```
   *
   * _Using `module.exports` (Not preferred for TypeScript Users)_
   *
   * ```TypeScript
   * class CredentialManager extends AbstractCredentialManager {
   *   // Code goes here
   * }
   *
   * module.exports = CredentialManager;
   * ```
   */
  var CredentialManager: ICredentialManagerConstructor
}
