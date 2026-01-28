# Null Pointer Demo

A small Java 17 project you can use to teach NullPointerException: reproducible failures, stack traces, and practical fixes.

## Quick start
- Run the demo program (prints examples but keeps running): `mvn exec:java`
- Run the tests that prove expected failures and fixes: `mvn test`
- Build only: `mvn package`

## What to show in your video
1. **Reproduce the problem**: `NullPointerExamples.triggerNpeWithNullCall()` throws immediately; use the stack trace to point to the null dereference.
2. **Check inputs**: `safeLength` returns zero for null instead of crashing.
3. **Fail fast**: `lengthWithRequireNonNull` throws with a clear message.
4. **Nested nulls**: `userCityUnsafe` vs `userCitySafe` and `userCityWithOptional` show the difference between unchecked chaining and guarded access.
5. **Unit tests as guardrails**: `NullPointerExamplesTest` asserts both the failure mode and the safe behavior.

## Project layout
- `src/main/java/com/example/npe` contains the demo classes and the CLI entry point `Main`.
- `src/test/java/com/example/npe` contains JUnit 5 tests that drive the teaching examples.
