@file:JsModule("@zowe/imperative")

package zowe.imperative.config

import js.promise.Promise
import zowe.imperative.cmd.doc.profiles.definition.ICommandProfileTypeConfiguration
import zowe.imperative.config.doc.IConfig
import zowe.imperative.config.doc.IConfigBuilderOpts
import zowe.imperative.config.doc.IConfigConvertResult
import zowe.imperative.imperative.doc.IImperativeConfig

external class ConfigBuilder {
  companion object {
    /**
     * Build a new Config object from an Imperative CLI app configuration.
     *
     * @param impConfig The Imperative CLI app configuration.
     * @param opts Options to control aspects of the builder.
     */
    fun build(
      impConfig: IImperativeConfig,
      opts: IConfigBuilderOpts = definedExternally,
    ): Promise<IConfig>

    fun buildDefaultProfile(
      profile: ICommandProfileTypeConfiguration,
      opts: IConfigBuilderOpts = definedExternally,
    ): ConfigBuilderBuildDefaultProfileResult

    /**
     * Convert existing v1 profiles to a Config object and report any conversion failures.
     *
     * @param profilesRootDir Root directory where v1 profiles are stored.
     * @return Results object including new config and error details for profiles that failed to convert.
     */
    fun convert(profilesRootDir: String): Promise<IConfigConvertResult>
  }
}
