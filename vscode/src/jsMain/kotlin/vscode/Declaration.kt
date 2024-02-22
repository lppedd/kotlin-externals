package vscode

/**
 * The declaration of a symbol representation as one or many [Location]s
 * or [LocationLink]s.
 */
typealias Declaration = Union3<Location, Array<Location>, Array<LocationLink>> // Location | Location[] | LocationLink[]
