import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.exposedLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class MainTest {

    init {
        Database.connect("jdbc:h2:mem:sample;DB_CLOSE_DELAY=-1")
        transaction {
            SchemaUtils.createMissingTablesAndColumns(
                Parent
            )
        }
    }

    @Test
    fun upperCaseChild() {
        assertDoesNotThrow {
            transaction {
                SchemaUtils.createMissingTablesAndColumns(UpperCaseChild)
            }
        }
    }

    @Test
    fun lowerCaseChild() {
        assertDoesNotThrow {
            transaction {
                SchemaUtils.createMissingTablesAndColumns(LowerCaseChild)
            }
        }
    }

    @Test
    fun snakeCaseChild() {
        assertDoesNotThrow {
            transaction {
                SchemaUtils.createMissingTablesAndColumns(SnakeCaseChild)
            }
        }
    }

    @Test
    fun camelCaseChild() {
        val exception = assertThrows<NoSuchElementException> {
            transaction {
                SchemaUtils.createMissingTablesAndColumns(CamelCaseChild)
            }
        }
        exception.printStackTrace()
    }
}
