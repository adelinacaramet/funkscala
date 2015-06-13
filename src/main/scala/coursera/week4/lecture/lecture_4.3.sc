// Type Bounds

// S<: T  = S is a subtype of T
// S>: T  = S is a supertype of T, or T is a subtype of S

// def assertAllPos[S<: IntSet](r: S): S = ...
// [S>: NonEmpty <: IntSet]

// in Scala arrays are not covariant, List are
// because List are immutable, and Arrays are not