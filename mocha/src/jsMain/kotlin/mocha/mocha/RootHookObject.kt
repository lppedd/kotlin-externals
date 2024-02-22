package mocha.mocha

/**
 * An alternative way to define root hooks that works with parallel runs.
 *
 * Root hooks work with any interface, but the property names do not change.
 * In other words, if you are using the tdd interface, suiteSetup maps to beforeAll, and setup maps to beforeEach.
 *
 * As with other hooks, `this` refers to to the current context object.
 *
 * See https://mochajs.org/#root-hook-plugins
 */
external interface RootHookObject {
  /**
   * In serial mode, run after all tests end, once only.
   * In parallel mode, run after all tests end, for each file.
   */
  var afterAll: Any? // Func | AsyncFunc | Func[] | AsyncFunc[] | undefined

  /**
   * In serial mode (Mocha's default), before all tests begin, once only.
   * In parallel mode, run before all tests begin, for each file.
   */
  var beforeAll: Any? // Func | AsyncFunc | Func[] | AsyncFunc[] | undefined

  /**
   * In both modes, run after every test.
   */
  var afterEach: Any? // Func | AsyncFunc | Func[] | AsyncFunc[] | undefined

  /**
   * In both modes, run before each test.
   */
  var beforeEach: Any? // Func | AsyncFunc | Func[] | AsyncFunc[] | undefined
}
