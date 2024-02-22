package vscode

import kotlin.ts.Union4

/**
 * Represents the different types of debug adapters
 */
typealias DebugAdapterDescriptor = Union4<DebugAdapterExecutable, DebugAdapterServer, DebugAdapterNamedPipeServer, DebugAdapterInlineImplementation> // DebugAdapterExecutable | DebugAdapterServer | DebugAdapterNamedPipeServer | DebugAdapterInlineImplementation
