package mocha.mocha.reporters.progress

import mocha.mocha.MochaOptions

external interface MochaOptions : MochaOptions<ReporterOptions?> {
  override var reporterOptions: ReporterOptions?
}
