package zowe.imperative.profiles.validation.doc

/**
 * A function that takes a profile and calls a done callback with the result of the profile validation
 */
typealias IProfileValidationTaskFunction = (profile: Any?, done: (result: IProfileValidationTaskResult) -> Unit) -> Unit
