package vscode

import kotlin.ts.Union4

typealias ConfigurationScope = Union4<Uri, TextDocument, WorkspaceFolder, Scope>
