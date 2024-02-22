package nodejs

// Forward declaration for `NodeJS.EventEmitter` from node.d.ts.
// Required by Mocha.Runnable, Mocha.Runner, and Mocha.Suite.
// NOTE: Mocha *must not* have a direct dependency on @types/node.
external interface EventEmitter
