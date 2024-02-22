@file:JsModule("vscode")

package vscode.env

import vscode.*

/**
 * The application name of the editor, like 'VS Code'.
 */
external val appName: String

/**
 * The application root folder from which the editor is running.
 *
 * *Note* that the value is the empty string when running in an
 * environment that has no representation of an application root folder.
 */
external val appRoot: String

/**
 * The hosted location of the application
 * On desktop this is 'desktop'
 * In the web this is the specified embedder i.e. 'github.dev', 'codespaces', or 'web' if the embedder
 * does not provide that information
 */
external val appHost: String

/**
 * The custom uri scheme the editor registers to in the operating system.
 */
external val uriScheme: String

/**
 * Represents the preferred user-language, like `de-CH`, `fr`, or `en-US`.
 */
external val language: String

/**
 * The system clipboard.
 */
external val clipboard: Clipboard

/**
 * A unique identifier for the computer.
 */
external val machineId: String

/**
 * A unique identifier for the current session.
 * Changes each time the editor is started.
 */
external val sessionId: String

/**
 * Indicates that this is a fresh install of the application.
 * `true` if within the first day of installation otherwise `false`.
 */
external val isNewAppInstall: Boolean

/**
 * Indicates whether the users has telemetry enabled.
 * Can be observed to determine if the extension should send telemetry.
 */
external val isTelemetryEnabled: Boolean

/**
 * An [Event] which fires when the user enabled or disables telemetry.
 * `true` if the user has enabled telemetry or `false` if the user has disabled telemetry.
 */
external val onDidChangeTelemetryEnabled: Event<Boolean>

/**
 * An [Event] which fires when the default shell changes. This fires with the new
 * shell path.
 */
external val onDidChangeShell: Event<String>

/**
 * The name of a remote. Defined by extensions, popular samples are `wsl` for the Windows
 * Subsystem for Linux or `ssh-remote` for remotes using a secure shell.
 *
 * *Note* that the value is `undefined` when there is no remote extension host but that the
 * value is defined in all extension hosts (local and remote) in case a remote extension host
 * exists. Use [Extension.extensionKind] to know if
 * a specific extension runs remote or not.
 */
external val remoteName: String?

/**
 * The detected default shell for the extension host, this is overridden by the
 * `terminal.integrated.defaultProfile` setting for the extension host's platform. Note that in
 * environments that do not support a shell the value is the empty string.
 */
external val shell: String

/**
 * The UI kind property indicates from which UI extensions
 * are accessed from. For example, extensions could be accessed
 * from a desktop application or a web browser.
 */
external val uiKind: UIKind

/**
 * The current log level of the editor.
 */
external val logLevel: LogLevel

/**
 * An [Event] which fires when the log level of the editor changes.
 */
external val onDidChangeLogLevel: Event<LogLevel>
