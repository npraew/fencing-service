println("This is executed during the configuration phase.")
plugins{
    kotlin("jvm") version "1.9.10" apply false
    kotlin("multiplatform") version "1.9.10" apply false
    kotlin("plugin.serialization") version "1.9.10" apply false
    id("com.google.protobuf") version "0.8.19" apply false
}
