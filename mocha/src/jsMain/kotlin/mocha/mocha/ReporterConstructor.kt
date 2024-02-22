package mocha.mocha

import mocha.mocha.reporters.Base

// TODO(Edoardo): this should represent a constructor, but it doesn't work as expected with all Base types
typealias ReporterConstructor = (runner: Runner, options: MochaOptions<Any?>) -> Base
