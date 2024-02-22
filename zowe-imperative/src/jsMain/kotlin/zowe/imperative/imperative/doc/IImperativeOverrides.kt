package zowe.imperative.imperative.doc

// TODO(Edoardo): fix this mess

/**
 * @file This file types everything for Imperative Override capabilities.
 *
 * Based on architectural decisions and ease of development, all future additions to the {@link
 * ImperativeOverrides} object must represent one of the following 2 types:
 * - **{@link IConstructor}** - This is a reference to a class constructor that will be used by the
 *   {@link OverridesLoader} when creating the various overrides factories.
 * - **string** - An absolute or relative path to an import module from which either the {@link
 *   OverridesLoader} or the {@link PluginManagementFacility} will load before using the constructor
 *   in a factory. If defined in this manner, all type checks will be lost and we gain the ability
 *   to reside in a static file.
 *
 * Available overrides are defined by the {@link ImperativeOverrides} interface. The interface
 * requires all keys to be a constructor based on the usage of this interface. The type {@link
 * IImperativeOverrides} is what enforces that each constructor key on ImperativeOverrides to also
 * allow strings and undefined values.
 */

/**
 * All of the Default Imperative classes that can be changed by your Imperative CLI app.
 *
 * A plugin can also define overrides through the same means as an Imperative CLI app. When
 * additional overrides provided by plugins are present, Imperative will favor those classes over
 * ones provided by your application.
 *
 * Whether you are defining an Imperative Plugin or an Imperative CLI app, all keys in this object
 * are expected to be a class constructor or of type string.
 * - A class constructor will be instantiated directly from imperative with no additional work by
 *   the provider. (Assuming it is properly defined for the specific key)
 * - A string will trigger imperative to load the module before instantiating it.
 *     - If the string is absolute, nothing special happens.
 *     - If the string is relative, then imperative will base the load on a well known location
 *       depending on if it is a plugin provided override or base cli provided override.
 *         - For Imperative Plugins: The module is located relative to the packages default import
 *           path (e.g `require('package-name')`)
 *         - For Imperative CLI Apps: The module is located relative to the main entry point of your
 *           application
 *
 * When defining the location of an overrides as a string, it must adhere to the following format.
 * Otherwise Imperative will not be able to load the class.
 *
 * _Exporting an Anonymous Class_
 *
 * ```TypeScript
 * export = class {
 *   // Code goes here
 * };
 * ```
 *
 * _Exporting a Named Class_
 *
 * ```TypeScript
 * export = class YourOverridesClass {
 *   // Code goes here
 * };
 * ```
 *
 * _Using `module.exports` (Not preferred for TypeScript Users)_
 *
 * ```TypeScript
 * class YourOverridesClass {
 *   // Code goes here
 * }
 *
 * module.exports = YourOverridesClass;
 * ```
 *
 * @see {@link ImperativeOverrides} for documentation on the available keys.
 */
typealias IImperativeOverrides = ConstructorOrString<ImperativeOverrides>
