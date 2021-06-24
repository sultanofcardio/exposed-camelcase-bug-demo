import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object Parent: IntIdTable() {
    val lowerCaseColumn = char("lowercase", 10).uniqueIndex()
    val upperCaseColumn = char("UPPERCASE", 10).uniqueIndex()
    val snakeCaseColumn1 = char("snake_case_1", 10).uniqueIndex()
    val snakeCaseColumn2 = char("SNAKE_CASE_2", 10).uniqueIndex()
    val camelCaseColumn = char("camelCase", 10).uniqueIndex()
}

object CamelCaseChild: IntIdTable() {
    val referencingColumn = reference("someName", Parent.camelCaseColumn)
}

object LowerCaseChild: IntIdTable() {
    val referencingColumn = reference("someName", Parent.lowerCaseColumn)
}

object UpperCaseChild: IntIdTable() {
    val referencingColumn = reference("someName", Parent.upperCaseColumn)
}

object SnakeCaseChild: IntIdTable() {
    val referencingColumn1 = reference("someName1", Parent.snakeCaseColumn1)
    val referencingColumn2 = reference("someName2", Parent.snakeCaseColumn2)
}

