package zowe.imperative.config.doc

external interface IConfigMergeOpts {
  /**
   * Indicates whether we should mask off secure properties. @defaultValue `false`
   */
  var maskSecure: Boolean?

  /**
   * Indicates whether we should exclude global layers. @defaultValue `false`
   */
  var excludeGlobalLayer: Boolean?

  /**
   * Indicates whether we should clone layers to prevent accidental edits. If maskSecure is true,
   * then it is implied that cloneLayers is true. @defaultValue `true`
   */
  var cloneLayers: Boolean?
}
