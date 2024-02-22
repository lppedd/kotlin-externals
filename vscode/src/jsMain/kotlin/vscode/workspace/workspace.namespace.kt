@file:JsModule("vscode")

package vscode.workspace

import js.array.ReadonlyArray
import vscode.*

/**
 * A [FileSystem] instance that allows to interact with local and remote
 * files, e.g. `vscode.workspace.fs.readDirectory(someUri)` allows to retrieve all entries
 * of a directory or `vscode.workspace.fs.stat(anotherUri)` returns the meta data for a
 * file.
 */
external val fs: FileSystem

/**
 * The uri of the first entry of [vscode.workspace.workspaceFolders]
 * as `string`. `undefined` if there is no first entry.
 *
 * Refer to https://code.visualstudio.com/docs/editor/workspaces for more information
 * on workspaces.
 */
@Deprecated("Use vscode.workspace.workspaceFolders instead", ReplaceWith("workspaceFolders"))
external val rootPath: String?

/**
 * List of workspace folders (0-N) that are open in the editor. `undefined` when no workspace
 * has been opened.
 *
 * Refer to https://code.visualstudio.com/docs/editor/workspaces for more information
 * on workspaces.
 */
external val workspaceFolders: ReadonlyArray<WorkspaceFolder>?

/**
 * The name of the workspace. `undefined` when no workspace
 * has been opened.
 *
 * Refer to https://code.visualstudio.com/docs/editor/workspaces for more information on
 * the concept of workspaces.
 */
external val name: String?

/**
 * The location of the workspace file, for example:
 *
 * `file:///Users/name/Development/myProject.code-workspace`
 *
 * or
 *
 * `untitled:1555503116870`
 *
 * for a workspace that is untitled and not yet saved.
 *
 * Depending on the workspace that is opened, the value will be:
 *  - `undefined` when no workspace is opened
 *  - the path of the workspace file as `Uri` otherwise. if the workspace
 * is untitled, the returned URI will use the `untitled:` scheme
 *
 * The location can e.g. be used with the `vscode.openFolder` command to
 * open the workspace again after it has been closed.
 *
 * **Example:**
 * ```typescript
 * vscode.commands.executeCommand('vscode.openFolder', uriOfWorkspace);
 * ```
 *
 * Refer to https://code.visualstudio.com/docs/editor/workspaces for more information on
 * the concept of workspaces.
 *
 * **Note:** it is not advised to use `workspace.workspaceFile` to write
 * configuration data into the file. You can use `workspace.getConfiguration().update()`
 * for that purpose which will work both when a single folder is opened as
 * well as an untitled or saved workspace.
 */
external val workspaceFile: Uri?

/**
 * An event that is emitted when a workspace folder is added or removed.
 *
 * **Note:** this event will not fire if the first workspace folder is added, removed or changed,
 * because in that case the currently executing extensions (including the one that listens to this
 * event) will be terminated and restarted so that the (deprecated) `rootPath` property is updated
 * to point to the first workspace folder.
 */
external val onDidChangeWorkspaceFolders: Event<WorkspaceFoldersChangeEvent>

/**
 * All text documents currently known to the editor.
 */
external val textDocuments: ReadonlyArray<TextDocument>

/**
 * An event that is emitted when a [TextDocument] is opened or when the language id
 * of a text document has been changed ([vscode.languages.setTextDocumentLanguage]).
 *
 * To add an event listener when a visible text document is opened, use the [TextEditor] events in the
 * [vscode.window] namespace. Note that:
 *
 * - The event is emitted before the [TextDocument] is updated in the [vscode.window.activeTextEditor]
 * - When a [TextDocument] is already open (e.g.: open in another [vscode.window.visibleTextEditors]) this event is not emitted
 */
external val onDidOpenTextDocument: Event<TextDocument>

/**
 * An event that is emitted when a [TextDocument] is disposed or when the language id
 * of a text document has been changed ([vscode.languages.setTextDocumentLanguage]).
 *
 * *Note 1:* There is no guarantee that this event fires when an editor tab is closed, use the
 * [vscode.window.onDidChangeVisibleTextEditors]-event to know when editors change.
 *
 * *Note 2:* A document can be open but not shown in an editor which means this event can fire
 * for a document that has not been shown in an editor.
 */
external val onDidCloseTextDocument: Event<TextDocument>

/**
 * An event that is emitted when a [TextDocument] is changed. This usually happens
 * when the [TextDocument.getText] changes but also when other things like the
 * [TextDocument.isDirty]-state changes.
 */
external val onDidChangeTextDocument: Event<TextDocumentChangeEvent>

/**
 * An event that is emitted when a [TextDocument] will be saved to disk.
 *
 * *Note 1:* Subscribers can delay saving by registering asynchronous work. For the sake of data integrity the editor
 * might save without firing this event. For instance when shutting down with dirty files.
 *
 * *Note 2:* Subscribers are called sequentially and they can [TextDocumentWillSaveEvent.waitUntil] saving
 * by registering asynchronous work. Protection against misbehaving listeners is implemented as such:
 *  - there is an overall time budget that all listeners share and if that is exhausted no further listener is called
 *  - listeners that take a long time or produce errors frequently will not be called anymore
 *
 * The current thresholds are 1.5 seconds as overall time budget and a listener can misbehave 3 times before being ignored.
 */
external val onWillSaveTextDocument: Event<TextDocumentWillSaveEvent>

/**
 * An event that is emitted when a [TextDocument] is saved to disk.
 */
external val onDidSaveTextDocument: Event<TextDocument>

/**
 * All notebook documents currently known to the editor.
 */
external val notebookDocuments: ReadonlyArray<NotebookDocument>

/**
 * An event that is emitted when a [NotebookDocument] has changed.
 */
external val onDidChangeNotebookDocument: Event<NotebookDocumentChangeEvent>

/**
 * An event that is emitted when a [NotebookDocument] will be saved to disk.
 *
 * *Note 1:* Subscribers can delay saving by registering asynchronous work. For the sake of data integrity the editor
 * might save without firing this event. For instance when shutting down with dirty files.
 *
 * *Note 2:* Subscribers are called sequentially and they can [NotebookDocumentWillSaveEvent.waitUntil] saving
 * by registering asynchronous work. Protection against misbehaving listeners is implemented as such:
 *  - there is an overall time budget that all listeners share and if that is exhausted no further listener is called
 *  - listeners that take a long time or produce errors frequently will not be called anymore
 *
 * The current thresholds are 1.5 seconds as overall time budget and a listener can misbehave 3 times before being ignored.
 */
external val onWillSaveNotebookDocument: Event<NotebookDocumentWillSaveEvent>

/**
 * An event that is emitted when a [NotebookDocument] is saved.
 */
external val onDidSaveNotebookDocument: Event<NotebookDocument>

/**
 * An event that is emitted when a [NotebookDocument] is opened.
 */
external val onDidOpenNotebookDocument: Event<NotebookDocument>

/**
 * An event that is emitted when a [NotebookDocument] is disposed.
 *
 * *Note 1:* There is no guarantee that this event fires when an editor tab is closed.
 *
 * *Note 2:* A notebook can be open but not shown in an editor which means this event can fire
 * for a notebook that has not been shown in an editor.
 */
external val onDidCloseNotebookDocument: Event<NotebookDocument>

/**
 * An event that is emitted when files are being created.
 *
 * *Note 1:* This event is triggered by user gestures, like creating a file from the
 * explorer, or from the [vscode.workspace.applyEdit]-api. This event is *not* fired when
 * files change on disk, e.g triggered by another application, or when using the
 * [FileSystem]-api.
 *
 * *Note 2:* When this event is fired, edits to files that are are being created cannot be applied.
 */
external val onWillCreateFiles: Event<FileWillCreateEvent>

/**
 * An event that is emitted when files have been created.
 *
 * *Note:* This event is triggered by user gestures, like creating a file from the
 * explorer, or from the [vscode.workspace.applyEdit]-api, but this event is *not* fired when
 * files change on disk, e.g triggered by another application, or when using the
 * [FileSystem]-api.
 */
external val onDidCreateFiles: Event<FileCreateEvent>

/**
 * An event that is emitted when files are being deleted.
 *
 * *Note 1:* This event is triggered by user gestures, like deleting a file from the
 * explorer, or from the [vscode.workspace.applyEdit]-api, but this event is *not* fired when
 * files change on disk, e.g triggered by another application, or when using the
 * [FileSystem]-api.
 *
 * *Note 2:* When deleting a folder with children only one event is fired.
 */
external val onWillDeleteFiles: Event<FileWillDeleteEvent>

/**
 * An event that is emitted when files have been deleted.
 *
 * *Note 1:* This event is triggered by user gestures, like deleting a file from the
 * explorer, or from the [vscode.workspace.applyEdit]-api, but this event is *not* fired when
 * files change on disk, e.g triggered by another application, or when using the
 * [FileSystem]-api.
 *
 * *Note 2:* When deleting a folder with children only one event is fired.
 */
external val onDidDeleteFiles: Event<FileDeleteEvent>

/**
 * An event that is emitted when files are being renamed.
 *
 * *Note 1:* This event is triggered by user gestures, like renaming a file from the
 * explorer, and from the [vscode.workspace.applyEdit]-api, but this event is *not* fired when
 * files change on disk, e.g triggered by another application, or when using the
 * [FileSystem]-api.
 *
 * *Note 2:* When renaming a folder with children only one event is fired.
 */
external val onWillRenameFiles: Event<FileWillRenameEvent>

/**
 * An event that is emitted when files have been renamed.
 *
 * *Note 1:* This event is triggered by user gestures, like renaming a file from the
 * explorer, and from the [vscode.workspace.applyEdit]-api, but this event is *not* fired when
 * files change on disk, e.g triggered by another application, or when using the
 * [FileSystem]-api.
 *
 * *Note 2:* When renaming a folder with children only one event is fired.
 */
external val onDidRenameFiles: Event<FileRenameEvent>

/**
 * An event that is emitted when the [WorkspaceConfiguration] changed.
 */
external val onDidChangeConfiguration: Event<ConfigurationChangeEvent>

/**
 * When true, the user has explicitly trusted the contents of the workspace.
 */
external val isTrusted: Boolean

/**
 * Event that fires when the current workspace has been trusted.
 */
external val onDidGrantWorkspaceTrust: Event<Unit>
