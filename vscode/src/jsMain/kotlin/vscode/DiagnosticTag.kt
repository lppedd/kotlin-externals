package vscode

import seskar.js.JsIntValue

/**
 * Additional metadata about the type of a diagnostic.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface DiagnosticTag {
  companion object {
    /**
     * Unused or unnecessary code.
     *
     * Diagnostics with this tag are rendered faded out. The amount of fading
     * is controlled by the `"editorUnnecessaryCode.opacity"` theme color. For
     * example, `"editorUnnecessaryCode.opacity": "#000000c0"` will render the
     * code with 75% opacity. For high contrast themes, use the
     * `"editorUnnecessaryCode.border"` theme color to underline unnecessary code
     * instead of fading it out.
     */
    @JsIntValue(1)
    val Unnecessary: DiagnosticTag

    /**
     * Deprecated or obsolete code.
     *
     * Diagnostics with this tag are rendered with a strike through.
     */
    @JsIntValue(2)
    val Deprecated: DiagnosticTag
  }
}
