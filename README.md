**Concepts Learnt**

**Optional Class in Java**
`Optional<T>` is a container class introduced in Java 8 to handle cases where a value may or may not be present(null-safe operations)
It forces devs to explicitly handle the absence of a value rather than dealing with `NullPointerException`.

Key Methods of Optional

    Optional.of(value) → Wraps a non-null value.

    Optional.empty() → Represents an absent value.

    Optional.ofNullable(value) → Wraps a value that may be null.

    isPresent() → Returns true if a value exists.

    isEmpty() → Returns true if no value exists (Java 11+).

    orElse(default) → Returns the value or a default if absent.

    orElseThrow() → Throws an exception if the value is absent.

When Should You Use Optional?

✅ Appropriate Use Cases:

    When a method may or may not return a value (e.g., searching for a record).

    When you want to force callers to handle null cases explicitly.

    When chaining operations (e.g., .map(), .filter()).

❌ Avoid Using Optional:

    As a field in an entity (not serializable).

    As a method parameter (confusing API design).

    When simpler alternatives exist (e.g., existsById()).

**Understanding `@Transactional`**

A Spring annotation that declares a method/class should run within a database transaction.
Ensures ACID(Atomicity, Consistency, Isolation, Durability) properties.

**Why Use It?**
* Atomicity: If an exception occurs, all changes are rolled back.

* Consistency: Ensures the database remains in a valid state.

* Avoids partial updates (e.g., if saving fails midway).

**Where to Use It?**
*Service Layer (not controllers or repositories).

* Methods that modify data (save, update, delete).


