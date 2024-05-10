@file:JsModule("vscode")
@file:JsQualifier("workspace")

package vscode.workspace

import vscode.FileSystemWatcher
import vscode.GlobPattern

/**
 * Creates a file system watcher that is notified on file events (create, change, delete)
 * depending on the parameters provided.
 *
 * By default, all opened [vscode.workspace.workspaceFolders] will be watched
 * for file changes recursively.
 *
 * Additional paths can be added for file watching by providing a {@link RelativePattern} with
 * a `base` path to watch. If the path is a folder and the `pattern` is complex (e.g. contains
 * `**` or path segments), it will be watched recursively and otherwise will be watched
 * non-recursively (i.e. only changes to the first level of the path will be reported).
 *
 * *Note* that paths must exist in the file system to be watched. File watching may stop when
 * the watched path is renamed or deleted.
 *
 * If possible, keep the use of recursive watchers to a minimum because recursive file watching
 * is quite resource intense.
 *
 * Providing a `string` as `globPattern` acts as convenience method for watching file events in
 * all opened workspace folders. It cannot be used to add more folders for file watching, nor will
 * it report any file events from folders that are not part of the opened workspace folders.
 *
 * Optionally, flags to ignore certain kinds of events can be provided.
 *
 * To stop listening to events the watcher must be disposed.
 *
 * *Note* that file events from recursive file watchers may be excluded based on user configuration.
 * The setting `files.watcherExclude` helps to reduce the overhead of file events from folders
 * that are known to produce many file changes at once (such as `node_modules` folders). As such,
 * it is highly recommended to watch with simple patterns that do not require recursive watchers
 * where the exclude settings are ignored and you have full control over the events.
 *
 * *Note* that symbolic links are not automatically followed for file watching unless the path to
 * watch itself is a symbolic link.
 *
 * *Note* that file changes for the path to be watched may not be delivered when the path itself
 * changes. For example, when watching a path `/Users/somename/Desktop` and the path itself is
 * being deleted, the watcher may not report an event and may not work anymore from that moment on.
 * The underlying behaviour depends on the path that is provided for watching:
 * * if the path is within any of the workspace folders, deletions are tracked and reported unless
 *   excluded via `files.watcherExclude` setting
 * * if the path is equal to any of the workspace folders, deletions are not tracked
 * * if the path is outside of any of the workspace folders, deletions are not tracked
 *
 * If you are interested in being notified when the watched path itself is being deleted, you have
 * to watch it's parent folder. Make sure to use a simple `pattern` (such as putting the name of the
 * folder) to not accidentally watch all sibling folders recursively.
 *
 * *Note* that the file paths that are reported for having changed may have a different path casing
 * compared to the actual casing on disk on case-insensitive platforms (typically macOS and Windows
 * but not Linux). We allow a user to open a workspace folder with any desired path casing and try
 * to preserve that. This means:
 * * if the path is within any of the workspace folders, the path will match the casing of the
 *   workspace folder up to that portion of the path and match the casing on disk for children
 * * if the path is outside of any of the workspace folders, the casing will match the case of the
 *   path that was provided for watching
 * In the same way, symbolic links are preserved, i.e. the file event will report the path of the
 * symbolic link as it was provided for watching and not the target.
 *
 * ### Examples
 *
 * The basic anatomy of a file watcher is as follows:
 *
 * ```ts
 * const watcher = vscode.workspace.createFileSystemWatcher(new vscode.RelativePattern(<folder>, <pattern>));
 *
 * watcher.onDidChange(uri => { ... }); // listen to files being changed
 * watcher.onDidCreate(uri => { ... }); // listen to files/folders being created
 * watcher.onDidDelete(uri => { ... }); // listen to files/folders getting deleted
 *
 * watcher.dispose(); // dispose after usage
 * ```
 *
 * #### Workspace file watching
 *
 * If you only care about file events in a specific workspace folder:
 *
 * ```ts
 * vscode.workspace.createFileSystemWatcher(new vscode.RelativePattern(vscode.workspace.workspaceFolders[0], '**​&#47;*.js'));
 * ```
 *
 * If you want to monitor file events across all opened workspace folders:
 *
 * ```ts
 * vscode.workspace.createFileSystemWatcher('**​&#47;*.js');
 * ```
 *
 * *Note:* the array of workspace folders can be empty if no workspace is opened (empty window).
 *
 * #### Out of workspace file watching
 *
 * To watch a folder for changes to *.js files outside the workspace (non recursively), pass in a `Uri` to such
 * a folder:
 *
 * ```ts
 * vscode.workspace.createFileSystemWatcher(new vscode.RelativePattern(vscode.Uri.file(<path to folder outside workspace>), '*.js'));
 * ```
 *
 * And use a complex glob pattern to watch recursively:
 *
 * ```ts
 * vscode.workspace.createFileSystemWatcher(new vscode.RelativePattern(vscode.Uri.file(<path to folder outside workspace>), '**​&#47;*.js'));
 * ```
 *
 * Here is an example for watching the active editor for file changes:
 *
 * ```ts
 * vscode.workspace.createFileSystemWatcher(new vscode.RelativePattern(vscode.window.activeTextEditor.document.uri, '*'));
 * ```
 *
 * @param globPattern A [GlobPattern] that controls which file events the watcher should report.
 * @param ignoreCreateEvents Ignore when files have been created.
 * @param ignoreChangeEvents Ignore when files have been changed.
 * @param ignoreDeleteEvents Ignore when files have been deleted.
 * @return A new file system watcher instance. Must be disposed when no longer needed.
 */
external fun createFileSystemWatcher(
  globPattern: GlobPattern,
  ignoreCreateEvents: Boolean = definedExternally,
  ignoreChangeEvents: Boolean = definedExternally,
  ignoreDeleteEvents: Boolean = definedExternally,
): FileSystemWatcher
