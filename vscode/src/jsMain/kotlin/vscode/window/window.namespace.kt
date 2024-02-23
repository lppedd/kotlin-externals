@file:JsModule("vscode")
@file:JsQualifier("window")

package vscode.window

import js.array.ReadonlyArray
import vscode.*

/**
 * Represents the grid widget within the main editor area
 */
external val tabGroups: TabGroups

/**
 * The currently active editor or `undefined`. The active editor is the one
 * that currently has focus or, when none has focus, the one that has changed
 * input most recently.
 */
external var activeTextEditor: TextEditor?

/**
 * The currently visible editors or an empty array.
 */
external var visibleTextEditors: ReadonlyArray<TextEditor>

/**
 * An [Event] which fires when the [vscode.window.activeTextEditor]
 * has changed. *Note* that the event also fires when the active editor changes
 * to `undefined`.
 */
external val onDidChangeActiveTextEditor: Event<TextEditor?>

/**
 * An [Event] which fires when the array of [vscode.window.visibleTextEditors]
 * has changed.
 */
external val onDidChangeVisibleTextEditors: Event<ReadonlyArray<TextEditor>>

/**
 * An [Event] which fires when the selection in an editor has changed.
 */
external val onDidChangeTextEditorSelection: Event<TextEditorSelectionChangeEvent>

/**
 * An [Event] which fires when the visible ranges of an editor has changed.
 */
external val onDidChangeTextEditorVisibleRanges: Event<TextEditorVisibleRangesChangeEvent>

/**
 * An [Event] which fires when the options of an editor have changed.
 */
external val onDidChangeTextEditorOptions: Event<TextEditorOptionsChangeEvent>

/**
 * An [Event] which fires when the view column of an editor has changed.
 */
external val onDidChangeTextEditorViewColumn: Event<TextEditorViewColumnChangeEvent>

/**
 * The currently visible [NotebookEditor] or an empty array.
 */
external val visibleNotebookEditors: ReadonlyArray<NotebookEditor>

/**
 * An [Event] which fires when the [vscode.window.visibleNotebookEditors]
 * has changed.
 */
external val onDidChangeVisibleNotebookEditors: Event<ReadonlyArray<NotebookEditor>>

/**
 * The currently active [NotebookEditor] or `undefined`. The active editor is the one
 * that currently has focus or, when none has focus, the one that has changed
 * input most recently.
 */
external val activeNotebookEditor: NotebookEditor?

/**
 * An [Event] which fires when the [vscode.window.activeNotebookEditor]
 * has changed. *Note* that the event also fires when the active editor changes
 * to `undefined`.
 */
external val onDidChangeActiveNotebookEditor: Event<NotebookEditor?>

/**
 * An [Event] which fires when the [NotebookEditor.selections]
 * have changed.
 */
external val onDidChangeNotebookEditorSelection: Event<NotebookEditorSelectionChangeEvent>

/**
 * An [Event] which fires when the [NotebookEditor.visibleRanges]
 * have changed.
 */
external val onDidChangeNotebookEditorVisibleRanges: Event<NotebookEditorVisibleRangesChangeEvent>

/**
 * The currently opened terminals or an empty array.
 */
external val terminals: ReadonlyArray<Terminal>

/**
 * The currently active terminal or `undefined`. The active terminal is the one that
 * currently has focus or most recently had focus.
 */
external val activeTerminal: Terminal?

/**
 * An [Event] which fires when the [vscode.window.activeTerminal]
 * has changed. *Note* that the event also fires when the active terminal changes
 * to `undefined`.
 */
external val onDidChangeActiveTerminal: Event<Terminal?>

/**
 * An [Event] which fires when a terminal has been created, either through the
 * [vscode.window.createTerminal] API or commands.
 */
external val onDidOpenTerminal: Event<Terminal>

/**
 * An [Event] which fires when a terminal is disposed.
 */
external val onDidCloseTerminal: Event<Terminal>

/**
 * An [Event] which fires when a [Terminal.state] has changed.
 */
external val onDidChangeTerminalState: Event<Terminal>

/**
 * Represents the current window's state.
 */
external val state: WindowState

/**
 * An [Event] which fires when the focus state of the current window
 * changes. The value of the event represents whether the window is focused.
 */
external val onDidChangeWindowState: Event<WindowState>

/**
 * The currently active color theme as configured in the settings. The active
 * theme can be changed via the `workbench.colorTheme` setting.
 */
external var activeColorTheme: ColorTheme

/**
 * An [Event] which fires when the active color theme is changed or has changes.
 */
external val onDidChangeActiveColorTheme: Event<ColorTheme>
