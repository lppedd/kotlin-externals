/**
 * This class will allow imperative to intercept calls by plugins so that it can
 * provide them with the runtime instance of imperative / base cli when necessary.
 *
 * @future Currently this loader is only available from Imperative's internals but
 *         work could be done to make this a true standalone package that either
 *         Imperative depends on or ships as a separate folder under packages.
 *
 * @example <caption>Proper Use of the Module Loader</caption>
 * // Ideally this is the first thing that gets called by your application; however,
 * // the module loader can be created and destroyed at any point by your application.
 *
 * // Initializing the loader
 * PluginRequireProvider.createPluginHooks(["module-a", "module-b"]);
 *
 * // Now in all places of the application, module-a and module-b will be loaded
 * // from the package location of process.mainModule (I.E the Host Package). This
 * // is useful when the Host Package has some sort of plugin infrastructure that
 * // might require modules to be injected to the plugins.
 *
 * // So this will always be the Host Package module regardless of where it was
 * // called from.
 * require("module-a");
 *
 * // But this will act as normal
 * require("module-c");
 *
 * // It is not necessary to cleanup the module loader before exiting. Your
 * // application lifecycle may require it to be brought up and down during the
 * // course of execution. With this in mind, a method has been provided to remove
 * // the hooks created by `createPluginHooks`.
 *
 * // Calling this
 * PluginRequirePriovider.destroyPluginHooks();
 *
 * // Will now cause this to act as normal regardless of how it would have been
 * // injected before.
 * require("module-b");
 *
 */
export declare class PluginRequireProvider {
    private readonly modules;
    /**
     * Create hooks for the specified modules to be injected at runtime.
     *
     * @param modules An array of modules to inject from the host application.
     *
     * @throws {PluginRequireAlreadyCreatedError} when hooks have already been added.
     */
    static createPluginHooks(modules: string[]): void;
    /**
     * Restore the default node require hook.
     *
     * @throws {PluginRequireNotCreatedError} when hooks haven't been added.
     */
    static destroyPluginHooks(): void;
    /**
     * Reference to the static singleton instance.
     */
    private static mInstance;
    /**
     * This regular expression is used by the module loader to
     * escape any valid characters that might be present in provided
     * modules.
     */
    private static sanitizeExpression;
    /**
     * Reference to the original require function.
     */
    private origRequire;
    /**
     * Reference to the regular expression used to match modules.
     *
     * This property was added to make testing easier.
     */
    private readonly regex;
    /**
     * Construct the class and create hooks into require.
     * @param modules The modules that should be injected from the runtime instance
     */
    private constructor();
}
