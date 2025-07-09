@file:OptIn(ExperimentalUuidApi::class)

package ulid.internal

import ulid.ULID
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

internal class ULIDConverter : ULID.Converter {
  /**
   * Generate a [ULID] from given Uuid.
   *
   * @param uuid A kotlin Uuid
   */
  override fun fromUuid(uuid: Uuid): ULID = uuid.toLongs {
    mostSignificantBits, leastSignificantBits ->
    ULIDValue(mostSignificantBits, leastSignificantBits)
  }

  /**
   * Return this [ULID] as [ulidString].
   */
  override fun toUuid(ulid: ULID): Uuid = Uuid.fromLongs(
    ulid.mostSignificantBits,
    ulid.leastSignificantBits
  )

  companion object {

    /**
     * Default implementation instance of [ULID.Converter].
     */
    val DefaultConverter = ULIDConverter()
  }
}