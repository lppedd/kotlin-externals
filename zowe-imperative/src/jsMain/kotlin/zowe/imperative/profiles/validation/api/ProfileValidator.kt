@file:JsModule("@zowe/imperative")

package zowe.imperative.profiles.validation.api

import zowe.imperative.cmd.doc.option.ICommandOptionDefinition
import zowe.imperative.operations.doc.IPromiseWithProgress
import zowe.imperative.profiles.doc.definition.IProfile
import zowe.imperative.profiles.validation.doc.IProfileValidationPlan
import zowe.imperative.profiles.validation.doc.IProfileValidationReport
import zowe.imperative.profiles.validation.doc.ValidationOutcome

/**
 * API for going through the full validation test for a Brightside CLI profile and producing
 * validation report
 */
external class ProfileValidator {
  companion object {
    /**
     * The key used to access the filename for the type containing the profile validation plan
     * object. On your profile validation command definition, specify the
     * filename in `.customize`[CUSTOMIZE_PLAN_KEY]
     */
    @JsString("validationPlanModule")
    val CUSTOMIZE_PLAN_KEY: String

    /**
     * The command line option for printing the validation plan only
     */
    val PRINT_PLAN_OPTION: ICommandOptionDefinition

    /**
     * Produce a profile validation report for a specific profile
     *
     * @param profile the profile to validate
     * @param plan the profile validation testing plan
     * @param productDisplayName the display name for your CLI
     * @return a promise of the validation report,
     *   with an additional field that can be used to create a progress bar or track progress in
     *   another UI
     */
    fun validate(
      profile: IProfile,
      plan: IProfileValidationPlan,
      productDisplayName: String,
    ): IPromiseWithProgress<IProfileValidationReport>

    /**
     * Get a printed/tabular version of your validation report
     *
     * @param report your completed validation result
     * @param plan the validation plan to use
     * @param productDisplayName the display name for your CLI used in the final result text
     * @param primaryHighlightColor color used to highlight headings and tables (used with chalk package)
     * @param profileName the name of the profile that was validated
     * @param profileType the type of the profile that was validated
     * @return the formatted report
     */
    fun getTextDisplayForReport(
      report: IProfileValidationReport,
      plan: IProfileValidationPlan,
      productDisplayName: String,
      primaryHighlightColor: String,
      profileName: String,
      profileType: String,
    ): String

    /**
     * Get a printed/tabular version of your validation plan, so that the user can see what steps
     * the Brightside CLI will take to validate their profile
     *
     * @param plan the plan for profile validation
     * @param profile the profile that would be validated - used only in this case to show a
     *   summary of the profile's contents
     * @param primaryHighlightColor primary highlight color for use with chalk
     * @return the formatted report
     */
    fun getTextDisplayForPlan(
      plan: IProfileValidationPlan,
      profile: IProfile,
      primaryHighlightColor: String,
    ): String

    /**
     * Get a more readable version of the outcome
     *
     * @param outcome the outcome to convert to readable version
     * @return full version of the outcome
     */
    fun outcomeToString(outcome: ValidationOutcome): String
  }
}
