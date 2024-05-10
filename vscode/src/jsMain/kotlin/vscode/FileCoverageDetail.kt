package vscode

import kotlin.ts.Union

typealias FileCoverageDetail = Union<StatementCoverage, DeclarationCoverage>
