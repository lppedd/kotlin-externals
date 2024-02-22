import { ICommandDefinition } from "../doc/ICommandDefinition";
import { ImperativeConfig } from "../../../utilities/src/ImperativeConfig";
import { IHandlerResponseApi } from "../doc/response/api/handler/IHandlerResponseApi";
/**
 * Imperative web help generator. Accepts the command definitions and constructs
 * the full help text for the command node.
 *
 * @export
 * @class WebHelpGenerator
 */
export declare class WebHelpGenerator {
    /**
     * Specifies whether user's home directory should be redacted from help content
     * @memberof WebHelpGenerator
     */
    sanitizeHomeDir: boolean;
    /**
     * Imperative command tree to build help for
     * @private
     * @memberof WebHelpGenerator
     */
    private mFullCommandTree;
    /**
     * Imperative config containing data about the CLI
     * @private
     * @memberof WebHelpGenerator
     */
    private mConfig;
    /**
     * Output directory for HTML doc pages
     * @private
     * @memberof WebHelpGenerator
     */
    private mDocsDir;
    /**
     * Markdown-it module used to convert markdown to HTML
     * @private
     * @memberof WebHelpGenerator
     */
    private markdownIt;
    /**
     * List of nodes in command tree
     * @private
     * @memberof WebHelpGenerator
     */
    private treeNodes;
    /**
     * Key value list of commands and their aliases
     * @private
     * @memberof WebHelpGenerator
     */
    private aliasList;
    /**
     * Used to build single page version of web help
     * @private
     * @memberof WebHelpGenerator
     */
    private singlePageHtml;
    /**
     * Create an instance of WebHelpGenerator.
     * @param {ICommandDefinition} - Imperative command tree to build help for
     * @param {ImperativeConfig} - Imperative config containing data about the CLI
     * @param {string} - Output directory for web help files
     */
    constructor(fullCommandTree: ICommandDefinition, config: ImperativeConfig, webHelpDir: string);
    /**
     * Build web help files and copy dependencies to output folder
     * @param {IHandlerResponseApi} - Command response object to use for output
     */
    buildHelp(cmdResponse: IHandlerResponseApi): void;
    /**
     * Converts Markdown string to HTML string. Any HTML tags contained in the
     * input Markdown string will be escaped.
     * @param markdownContent String containing Markdown content
     * @returns String containing HTML content
     */
    private renderMarkdown;
    /**
     * Returns header HTML for help page
     * @private
     * @param title - Title string for the page
     */
    private genDocsHeader;
    /**
     * Returns footer HTML for help page
     * @private
     */
    private genDocsFooter;
    /**
     * Returns print button to show in header of help page
     * @private
     */
    private genPrintButton;
    /**
     * Builds breadcrumb of HTML links to show command ancestry
     * @private
     * @param {string} rootCommandName
     * @param {string} fullCommandName
     */
    private genBreadcrumb;
    /**
     * Builds list of groups/commands with HTML links added
     * @private
     * @param {DefaultHelpGenerator} helpGen
     * @param {string} fullCommandName
     */
    private buildChildrenSummaryTables;
    /**
     * Appends help content for individual command/group to single page HTML
     * @private
     * @param {ICommandDefinition} definition
     * @param {string} rootCommandName
     * @param {string} fullCommandName
     * @param {string} htmlContent
     */
    private appendToSinglePageHtml;
    /**
     * Generates HTML help page for Imperative command
     * @private
     * @param {ICommandDefinition} definition
     * @param {string} fullCommandName
     * @param {string} docsDir
     * @param {ITreeNode} parentNode
     */
    private genCommandHelpPage;
    /**
     * Builds table of contents for flat view
     * @private
     * @param node - Parent node whose children will be listed
     * @returns - HTML list of child nodes
     */
    private buildCmdTreeHtml;
    /**
     * Writes data for building web help command tree to JS file
     * @private
     */
    private writeTreeData;
}
