@file:OptIn(ExperimentalUuidApi::class)

package ulid

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.uuid.ExperimentalUuidApi

class TestULIDConverter {

    @Test
    fun `test ULID conversion from and to Uuid`() {
        val ulid = ULID.nextULID()

        val uuid = ULID.Converter.toUuid(ulid)
        val reconvertedUlid = ULID.Converter.fromUuid(uuid)

        assertEquals(ulid, reconvertedUlid)
    }
}
