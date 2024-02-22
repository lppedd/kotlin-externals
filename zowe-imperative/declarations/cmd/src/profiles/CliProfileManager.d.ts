import { BasicProfileManager, IProfileSaved, IProfileUpdated, IProfileValidated, ISaveProfileFromCliArgs, IUpdateProfileFromCliArgs, IValidateProfileForCLI } from "../../../profiles";
import { ICommandProfileTypeConfiguration } from "../doc/profiles/definition/ICommandProfileTypeConfiguration";
import { IDeleteProfile, IProfileDeleted, IProfileLoaded } from "../../../profiles/src/doc";
import { ICliLoadProfile } from "../doc/profiles/parms/ICliLoadProfile";
import { ICliLoadAllProfiles } from "../doc/profiles/parms/ICliLoadAllProfiles";
/**
 * A profile management API compatible with transforming command line arguments into
 * profiles
 */
export declare class CliProfileManager extends BasicProfileManager<ICommandProfileTypeConfiguration> {
    /**
     * NOTE: This is just a copy of BasicProfileManager.loadAll
     * REASON: We needed the Abstract profile manager to call the CLI profile manager to handle loading of secure properties
     * Loads all profiles from every type. Profile types are determined by reading all directories within the
     * profile root directory.
     * @returns {Promise<IProfileLoaded[]>} - The list of all profiles for every type
     */
    loadAll(params?: ICliLoadAllProfiles): Promise<IProfileLoaded[]>;
    /**
     * Overridden saveProfile functionality.
     * If CLI args are provided, profile fields are built from the args.
     * Otherwise BaseProfileManager functionality is used.
     * @param {ISaveProfileFromCliArgs} parms - parameters for the save, potentially including CLI args
     * @returns {Promise<IProfileSaved>} - promise which fulfills with the save results
     */
    protected saveProfile(parms: ISaveProfileFromCliArgs): Promise<IProfileSaved>;
    /**
     * Overridden updateProfile functionality
     * If CLI args are provided, profile fields are built from the arguments. Otherwise
     * the BaseProfileManager update functionality is used
     *
     * @param {IUpdateProfileFromCliArgs} parms - parameters, potentially including CLI args
     * @returns {Promise<IProfileUpdated>} - promise which contains the updated profile, path, and message
     *                                       when fulfilled
     */
    protected updateProfile(parms: IUpdateProfileFromCliArgs): Promise<IProfileUpdated>;
    /**
     * Overridden loadProfile functionality
     * After the BasicProfileManager loads the profile, we process the secured properties for the CLi to use
     *
     * @param {ICliLoadProfile} parms - Load control params - see the interface for full details
     * @returns {Promise<IProfileLoaded>} - Promise that is fulfilled when complete (or rejected with an Imperative Error)
     */
    protected loadProfile(parms: ICliLoadProfile): Promise<IProfileLoaded>;
    /**
     * Overridden loadProfile functionality
     * Before the BasicProfileManager deletes the profile, we remove the secure properties associated with the profile
     *
     * @param {IDeleteProfile} parms - Delete control params - see the interface for full details
     * @returns {Promise<IProfileDeleted>} - Promise that is fulfilled when complete (or rejected with an Imperative Error)
     */
    protected deleteProfile(parms: IDeleteProfile): Promise<IProfileDeleted>;
    /**
     * Validate a profile's structure, skipping the validation if we haven't built the
     * profile's fields from the CLI arguments yet.
     * @param {IValidateProfileForCLI} parms - validate profile parameters. if these don't
     *                                         have readyForValidation = true, validation is
     *                                         skipped
     * @returns {Promise<IProfileValidated>}
     */
    protected validateProfile(parms: IValidateProfileForCLI): Promise<IProfileValidated>;
    /**
     * After the DefaultCredentialManager reports an error resolution of recreating
     * a credential, add instruction to recreate the profile.
     *
     * @param {String} errDetails - The additional details of an error thrown
     *      by DefaultCredentialManager.
     *
     * @returns {string} An error details string that contains an instruction to
     *      recreate the profile (when appropriate).
     */
    private addProfileInstruction;
    /**
     * Helper routine to find nested properties
     * Inspired by the inner function of insertCliArgumentsIntoProfile
     *
     * @param {ICommandProfileProperty} prop - profile property
     * @param {string} propNamePath - Dot notation path of a property (e.g. my.nested.property)
     * @param {*} propValue - Current value of the property while traversing down the object tree
     * @param {SecureOperationFunction} secureOp - Function to be executed if we are supposed to process secure properties
     * @returns {Promise<any>} Processed version of a property
     */
    private findOptions;
    /**
     * Process and store all secure properties and replace them with a constant for display purposes
     * @param name - the name of the profile with which the secure properties are associated
     * @param {IProfile} profile - Profile contents to be processed
     * @return {Promise<IProfile>}
     */
    private processSecureProperties;
    /**
     * Update an existing profile with arguments from the user based on
     * the schema and configuration for this profile type
     * @param {IUpdateProfileFromCliArgs} parms - parameters including args
     * @param {IProfile} oldProfile - the pre-existing profile to update
     * @param {IProfile} newProfile - new profile which will have fields set from CLI args
     * @returns {Promise<IProfileUpdated>}  promise which provides the finished profile on fulfill
     */
    private updateProfileFromCliArgs;
    /**
     *
     * If a custom handler is provided for update, the handler will be loaded and invoked
     * in order to build the finished profile
     * @param {IProfile} oldProfile - the old profile to update
     * @param newProfile - new profile which may have fields populated, which will be updated from the CLI args
     * @param {yargs.Arguments} newArguments - CLi arguments specified by the user
     * @param merge - should the profiles be merged? (will be skipped if there is a custom update profile handler)
     * @returns {Promise<IProfile>} - promise which provides the finished profile on fulfill
     */
    private updateProfileFieldsFromCommandArguments;
    /**
     * Take command line arguments from the user and create a profile from them using the schema and configuration for
     * the profile type
     * @param {yargs.Arguments} profileArguments - CLI arguments specified by the user
     * @param {IProfile} starterProfile - the profile with name and type to use to start the profile creation
     * @returns {Promise<IProfile>} profile which provides the finished profile on fulfill
     */
    private createProfileFromCommandArguments;
    /**
     * Default style of building of profile fields to option definitions defined in the schema
     * Will only work if there is a one-to-one option definition mapping for schema fields
     * @param {yargs.Arguments} args - the arguments specified by the user
     * @param {IProfile} profile -  the profile so far, which will be updated
     */
    private insertCliArgumentsIntoProfile;
    /**
     * Build the "dependencies" field of a profile object from command line arguments
     * @param {yargs.Arguments} args - the command line arguments from the user
     * @param {IProfile} profile - the profile object so far.
     */
    private insertDependenciesIntoProfileFromCLIArguments;
}
