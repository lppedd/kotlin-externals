package vscode

import seskar.js.JsIntValue

/**
 * Defines how an argument should be quoted if it contains
 * spaces or unsupported characters.
 */
@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
sealed external interface ShellQuoting {
  companion object {
    /**
     * Character escaping should be used. This for example
     * uses \ on bash and ` on PowerShell.
     */
    @JsIntValue(1)
    val Escape: ShellQuoting

    /**
     * Strong string quoting should be used. This for example
     * uses " for Windows cmd and ' for bash and PowerShell.
     * Strong quoting treats arguments as literal strings.
     * Under PowerShell echo 'The value is $(2 * 3)' will
     * print `The value is $(2 * 3)`
     */
    @JsIntValue(2)
    val Strong: ShellQuoting

    /**
     * Weak string quoting should be used. This for example
     * uses " for Windows cmd, bash and PowerShell. Weak quoting
     * still performs some kind of evaluation inside the quoted
     * string.  Under PowerShell echo "The value is $(2 * 3)"
     * will print `The value is 6`
     */
    @JsIntValue(3)
    val Weak: ShellQuoting
  }
}
