package vscode

/**
 * Commenting range provider for a [CommentController].
 */
external interface CommentingRangeProvider {
  /**
   * Provide a list of ranges which allow new comment threads creation or null for a given document
   */
  fun provideCommentingRanges(
    document: TextDocument,
    token: CancellationToken,
  ): ProviderResult<Array<Range>>
}
