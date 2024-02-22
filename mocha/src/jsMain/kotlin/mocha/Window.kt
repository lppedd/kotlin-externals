package mocha

import mocha.mocha.MochaGlobals

// Augments the DOM `Window` object when lib.dom.d.ts is loaded.
external interface Window : MochaGlobals
