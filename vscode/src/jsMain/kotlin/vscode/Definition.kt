package vscode

/**
 * The definition of a symbol represented as one or many [Location]s.
 * For most programming languages there is only one location at which a symbol is
 * defined.
 */
typealias Definition = Union<Location, Array<Location>> // Location | Location[]
