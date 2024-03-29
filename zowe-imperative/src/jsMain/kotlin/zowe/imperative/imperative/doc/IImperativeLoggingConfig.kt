package zowe.imperative.imperative.doc

external interface IImperativeLoggingConfig {
  /**
   * Specify a log level name. An app's logging object is accessible via the
   * Imperative.api.appLogging object.
   *
   * Default will direct log output to ~/.<app-name>/logs/<app-name>.log
   *
   * <app-name> is controlled via "name" setting in IImperativeConfig.
   */
  var logFile: String?

  /**
   * Select a specific log level setting, for example, if a log setting of "fatal" is used, only
   * "fatal" level messages will appear within the log. However, if "debug" level messages are
   * selected, "debug", "info", "warn", "error", and "fatal" messages will appear within the log.
   *
   * Accepted values are: trace, debug, info, warn, error, fatal
   *
   * Default: debug
   */
  var level: String?

  /**
   * "imperative", "app", and "console" are reserved. Use this field to create additional log API
   * entities. There is no default. This field is required when defining extra entries, and its
   * content is ignored for predefined loggers (imperative, console, and app loggers)
   */
  var apiName: String?
}
