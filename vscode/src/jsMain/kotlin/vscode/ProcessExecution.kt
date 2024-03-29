@file:JsModule("vscode")

package vscode

/**
 * The execution of a task happens as an external process
 * without shell interaction.
 */
external class ProcessExecution {
  /**
   * Creates a process execution.
   *
   * @param process The process to start.
   * @param options Optional options for the started process.
   */
  constructor(process: String, options: ProcessExecutionOptions = definedExternally)

  /**
   * Creates a process execution.
   *
   * @param process The process to start.
   * @param args Arguments to be passed to the process.
   * @param options Optional options for the started process.
   */
  constructor(process: String, args: Array<String>, options: ProcessExecutionOptions = definedExternally)

  /**
   * The process to be executed.
   */
  var process: String

  /**
   * The arguments passed to the process. Defaults to an empty array.
   */
  var args: Array<String>

  /**
   * The process options used when the process is executed.
   * Defaults to undefined.
   */
  var options: ProcessExecutionOptions?
}
