package mocha.mocha

import kotlin.js.RegExp
import kotlin.ts.Union

/**
 * Options to pass to Mocha.
 */
external interface MochaOptions<T : Any?> {
  /** Propagate uncaught errors? */
  var allowUncaught: Boolean?

  /** Force `done` callback or promise? */
  var asyncOnly: Boolean?

  /** bail on the first test failure. */
  var bail: Boolean?

  /** Check for global variable leaks? */
  var checkLeaks: Boolean?

  /** Color TTY output from reporter */
  var color: Boolean?

  /** Delay root suite execution? */
  var delay: Boolean?

  /** Show diff on failure? */
  var diff: Boolean?

  /** Report tests without running them? */
  var dryRun: Boolean?

  /** Test filter given string. */
  var fgrep: String?

  /** Tests marked `only` fail the suite? */
  var forbidOnly: Boolean?

  /** Pending tests fail the suite? */
  var forbidPending: Boolean?

  /** Full stacktrace upon failure? */
  var fullTrace: Boolean?

  /** Variables expected in global scope. */
  var globals: Array<String>?

  /** Test filter given regular expression. */
  var grep: Union<String, RegExp>? // string | RegExp | undefined

  /** Enable desktop notifications? */
  var growl: Boolean?

  /** Display inline diffs? */
  var inlineDiffs: Boolean?

  /** Invert test filter matches? */
  var invert: Boolean?

  /** Disable syntax highlighting? */
  var noHighlighting: Boolean?

  /** Reporter name or constructor. */
  var reporter: Union<String, ReporterConstructor>? // string | ReporterConstructor | undefined

  /** Reporter settings object. */
  var reporterOptions: T

  /** Number of times to retry failed tests. */
  var retries: Int?

  /** Slow threshold value. */
  var slow: Int?

  /** Timeout threshold value. */
  var timeout: Union<Number, String>? // number | string | undefined

  /** Interface name. */
  var ui: Interface?

  /** Run jobs in parallel */
  var parallel: Boolean?

  /** Max number of worker processes for parallel runs. */
  var jobs: Int?

  /** Hooks to bootstrap the root suite with. */
  var rootHooks: RootHookObject?

  /** Pathname of `rootHooks` plugin for parallel runs. */
  var require: Array<String>?

  /** Should be `true` if `Mocha` process is running in a worker process. */
  var isWorker: Boolean?
}
