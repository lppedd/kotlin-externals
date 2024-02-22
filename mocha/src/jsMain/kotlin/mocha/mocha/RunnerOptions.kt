package mocha.mocha

external interface RunnerOptions {
  /** Whether to delay execution of root suite until ready. */
  var delay: Boolean?

  /** Whether to report tests without running them. */
  var dryRun: Boolean?

  /** Whether to clean references to test fns and hooks when a suite is done. */
  var cleanReferencesAfterRun: Boolean?
}
