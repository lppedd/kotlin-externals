@file:JsModule("@zowe/imperative")

package zowe.imperative.profiles.utils

import zowe.imperative.profiles.doc.config.IProfileTypeConfiguration
import zowe.imperative.profiles.doc.definition.IMetaProfile
import zowe.imperative.profiles.doc.definition.IProfile

/**
 * Profile IO methods for writing/reading profiles to disk.
 * The profile managers never invoke "fs" directly.
 * All "fs" calls are wrapped here and errors are transformed to ImperativeError
 * for error handling/flow throughout Imperative.
 */
external class ProfileIO {
  companion object {
    /**
     * The yamljs package requires you to indicate the depth for conversion to yaml. Set to max
     * of 9999.
     */
    val MAX_YAML_DEPTH: Int

    /**
     * Creates the full set of directories indicated by the path. Used to create the profile root
     * directory and type directories.
     *
     * @param path The directory path to create - creates all necessary subdirectories.
     */
    fun createProfileDirs(path: String)

    /**
     * Read the profile meta file using Yaml "safeLoad" (ensures that no code executes, etc. during
     * the load). The meta profile file for a type contains the default profile specification. The
     * meta profile is ALWAYS in YAML format (controlled exclusively by the Imperative framework).
     *
     * @param path The path to the meta profile
     */
    fun <T : IProfileTypeConfiguration> readMetaFile(path: String): IMetaProfile<T>

    /**
     * Accepts a profile object and writes the profile to the specified location (and optionally
     * converts the profile to YAML format - the default for Imperative profiles).
     *
     * @param fullFilePath the fully qualified profile path, file, & extension.
     * @param profile the profile object to write to disk.
     */
    fun writeProfile(
      fullFilePath: String,
      profile: IProfile,
    )

    /**
     * Delete the profile and ensure it is gone.
     *
     * @param name the profile object - really only used for error messages
     * @param fullFilePath the full file path to delete
     */
    fun deleteProfile(
      name: String,
      fullFilePath: String,
    )

    /**
     * Checks if the file specified exists.
     *
     * @param path The file path
     * @return the path to the existing file or NULL if not found
     */
    fun exists(path: String): String

    /**
     * Converts the meta to yaml and writes to disk
     *
     * @param meta The meta profile contents to write to disk
     * @param path The path to the meta profile
     */
    fun writeMetaFile(
      meta: IMetaProfile<IProfileTypeConfiguration>,
      path: String,
    )

    /**
     * Extracts the profile name from the file path/name
     *
     * @param file the file path to extract the profile name
     * @param ext the extension of the file
     * @return the profile name
     */
    fun fileToProfileName(
      file: String,
      ext: String,
    ): String

    /**
     * Accepts the profiles root directory and returns all directories within. The directories
     * within the root directory are all assumed to be profile type directories (potentially
     * containing a meta file and profiles of that type).
     *
     * @param profileRootDirectory The profiles root directory to obtain all profiles from.
     * @return The list of profiles returned or a blank array
     */
    fun getAllProfileDirectories(profileRootDirectory: String): Array<String>

    /**
     * Accepts the profile directory location for a type, reads all filenames, and returns a list of
     * profile names that are present within the directory (excluding the meta profile)
     *
     * @param profileTypeDir The directory for the type
     * @param ext the extension for the profile files (normally YAML)
     * @param metaNameForType the meta name for this type
     * @return A list of all profile names (without path/ext)
     */
    fun getAllProfileNames(
      profileTypeDir: String,
      ext: String,
      metaNameForType: String,
    ): Array<String>

    /**
     * Read a profile from disk. Profiles are always assumed to be YAML (YAML "safeLoad" is invoked
     * to perform the load).
     *
     * @param filePath Path to the profile.
     * @param type The profile type; used to populate the "type" in the profile object
     *   (type property not persisted on disk).
     * @return The profile object.
     */
    fun readProfileFile(
      filePath: String,
      type: String,
    ): IProfile
  }
}
