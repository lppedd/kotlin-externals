import { IProfileValidationReport } from "../doc/IProfileValidationReport";
import { IProfileValidationPlan } from "../doc/IProfileValidationPlan";
import { VALIDATION_OUTCOME } from "../doc/IProfileValidationTask";
import { IPromiseWithProgress } from "../../../../operations";
import { ICommandOptionDefinition } from "../../../../cmd";
import { IProfile } from "../../doc/definition/IProfile";
/**
 * API for going through the full validation test for a Brightside CLI profile
 * and producing validation report
 */
export declare class ProfileValidator {
    /**
     * The key used to access the filename for the type containing the profile
     * validation plan object. On your profile validation command definition,
     * specify the filename in   .customize[CUSTOMIZE_PLAN_KEY]
     * @type {string}
     */
    static readonly CUSTOMIZE_PLAN_KEY = "validationPlanModule";
    /**
     * The command line option for printing the validation plan only
     */
    static get PRINT_PLAN_OPTION(): ICommandOptionDefinition;
    /**
     *  Produce a profile validation report for a specific profile
     * @param {IProfile} profile the profile to validate
     * @param {IProfileValidationPlan} plan - the profile validation testing plan
     * @param productDisplayName - the display name for your CLI
     * @returns {IPromiseWithProgress<IProfileValidationReport>} a promise of the validation report, with an additional field
     *                              that can be used to create a progress bar or track progress in another UI
     */
    static validate(profile: IProfile, plan: IProfileValidationPlan, productDisplayName: string): IPromiseWithProgress<IProfileValidationReport>;
    /**
     * Get a printed/tabular version of your validation report
     * @param {IProfileValidationReport} report - your completed validation result
     * @param plan - the validation plan to use
     * @param productDisplayName - the display name for your CLI used in the final result text
     * @param primaryHighlightColor - color used to highlight headings and tables (used with chalk package)
     * @param profileName - the name of the profile that was validated
     * @param profileType - the type of the profile that was validated
     * @returns {string} - the formatted report
     */
    static getTextDisplayForReport(report: IProfileValidationReport, plan: IProfileValidationPlan, productDisplayName: string, primaryHighlightColor: string, profileName: string, profileType: string): string;
    /**
     * Get a printed/tabular version of your validation plan,
     * so that the user can see what steps the Brightside CLI will take to validate their profile
     * @param {IProfileValidationPlan} plan - the plan for profile validation
     * @param profile - the profile that would be validated - used only in this case to show a summary of the profile's contents
     * @param primaryHighlightColor - primary highlight color for use with chalk
     * @returns {string} - the formatted report
     */
    static getTextDisplayForPlan(plan: IProfileValidationPlan, profile: IProfile, primaryHighlightColor: string): string;
    /**
     * Get a more readable version of the outcome
     * @param {VALIDATION_OUTCOME} outcome - the outcome to convert to readable version
     * @returns {string} - full version of the outcome
     */
    static outcomeToString(outcome: VALIDATION_OUTCOME): string;
    /**
     * Get the total number of each type of profile validation outcome
     * @param {IProfileValidationReport} report - the report from which
     * @returns {{succeeded: number, undetermined: number, failed: number}} - total count
     *                                   of what has succeeded, undetermined, failed
     */
    private static countOutcomes;
}
