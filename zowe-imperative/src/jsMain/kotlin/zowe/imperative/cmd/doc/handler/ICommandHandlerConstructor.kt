package zowe.imperative.cmd.doc.handler

/**
 * This type is here so that we can indicate an object from a
 * require can be instantiated.
 */
typealias ICommandHandlerConstructor = () -> ICommandHandler // new () => ICommandHandler
