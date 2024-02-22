package vscode

/**
 * Represents the different types of debug adapters
 */
typealias DebugAdapterDescriptor = Union4<DebugAdapterExecutable, DebugAdapterServer, DebugAdapterNamedPipeServer, DebugAdapterInlineImplementation> // DebugAdapterExecutable | DebugAdapterServer | DebugAdapterNamedPipeServer | DebugAdapterInlineImplementation
