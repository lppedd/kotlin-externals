package mocha.nodejs

import mocha.mocha.MochaGlobals

// Augments NodeJS's `global` object when node.d.ts is loaded
external interface Global : MochaGlobals
