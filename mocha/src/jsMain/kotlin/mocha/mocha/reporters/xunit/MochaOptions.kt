package mocha.mocha.reporters.xunit

import mocha.mocha.MochaOptions

external interface MochaOptions : MochaOptions<ReporterOptions?> {
  override var reporterOptions: ReporterOptions?
}
