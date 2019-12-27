package c.gingdev.cursedpuppy.utils

infix fun <T> T?.NotNull(f: (T) -> Unit): T? {
    if (this != null) {
        f(this)
    }
    return this
}

infix fun <T> T?.IsNull(f: () -> Unit): T? {
    if (this == null) {
        f()
    }
    return this
}