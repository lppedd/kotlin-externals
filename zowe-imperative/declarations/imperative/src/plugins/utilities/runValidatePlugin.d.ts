/**
 * Run another instance of the host CLI command to validate a plugin that has
 * just been installed. We use a separate process instead of an API call
 * because when the user re-installs an existing plugin we cannot validate
 * if the plugin has conflicting command names because the plugin has
 * already been incorporated into the Imperative command tree, and thus it
 * could conflict with its own commands. However, if we run a validate command
 * in a new process, we start with a clean slate and we get accurate results.
 *
 * @param pluginName - The name of a plugin to be validated.
 *
 * @returns - The text output of the validate plugin command.
 */
export declare function runValidatePlugin(pluginName: string): string;
