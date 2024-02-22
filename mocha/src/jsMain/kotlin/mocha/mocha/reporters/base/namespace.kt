@file:JsModule("mocha")

package mocha.mocha.reporters.base

/**
 * Enables coloring by default
 *
 * See https://mochajs.org/api/module-base#.useColors
 */
external var useColors: Boolean

/**
 * Inline diffs instead of +/-
 *
 * See https://mochajs.org/api/module-base#.inlineDiffs
 */
external var inlineDiffs: Boolean

/**
 * Default color map
 *
 * See https://mochajs.org/api/module-base#.colors
 */
external val colors: ColorMap

/**
 * Default symbol map
 *
 * See https://mochajs.org/api/module-base#.symbols
 */
external val symbols: SymbolMap

/**
 * Expose terminal window size
 *
 * See https://mochajs.org/api/module-base#.window
 */
external val window: Window
