## Jetbrains Exposed - CamelCase Foreign Key Bug Demo

This is a really simple demo of [this issue]() in Jetbrains Exposed.

When creating an entity with a foreign key that references a column using a camel-case name, a `NoSuchElementException`
is thrown.

You can demo this by cloning the repo and running

```shell
./gradlew clean test --info
```

Which should print approximately the following stack trace:

<details>
<summary>Stack trace</summary>

```text
java.util.NoSuchElementException: Collection contains no element matching the predicate.
	at org.jetbrains.exposed.sql.statements.jdbc.JdbcDatabaseMetadataImpl$tableConstraints$1$1.invoke(JdbcDatabaseMetadataImpl.kt:235)
	at org.jetbrains.exposed.sql.statements.jdbc.JdbcDatabaseMetadataImpl$tableConstraints$1$1.invoke(JdbcDatabaseMetadataImpl.kt:190)
	at org.jetbrains.exposed.sql.statements.jdbc.JdbcDatabaseMetadataImplKt.iterate(JdbcDatabaseMetadataImpl.kt:226)
	at org.jetbrains.exposed.sql.statements.jdbc.JdbcDatabaseMetadataImpl.tableConstraints(JdbcDatabaseMetadataImpl.kt:190)
	at org.jetbrains.exposed.sql.vendors.VendorDialect$fillConstraintCacheForTables$1.invoke(Default.kt:706)
	at org.jetbrains.exposed.sql.vendors.VendorDialect$fillConstraintCacheForTables$1.invoke(Default.kt:706)
	at org.jetbrains.exposed.sql.statements.jdbc.JdbcConnectionImpl.metadata(JdbcConnectionImpl.kt:51)
	at org.jetbrains.exposed.sql.Database.metadata$exposed_core(Database.kt:29)
	at org.jetbrains.exposed.sql.vendors.VendorDialect.fillConstraintCacheForTables(Default.kt:706)
	at org.jetbrains.exposed.sql.vendors.VendorDialect.columnConstraints(Default.kt:685)
	at org.jetbrains.exposed.sql.SchemaUtils.addMissingColumnsStatements(SchemaUtils.kt:150)
	at org.jetbrains.exposed.sql.SchemaUtils.createMissingTablesAndColumns(SchemaUtils.kt:247)
	at org.jetbrains.exposed.sql.SchemaUtils.createMissingTablesAndColumns$default(SchemaUtils.kt:235)
	at MainTest$camelCaseChild$exception$1$1.invoke(MainTest.kt:42)
	at MainTest$camelCaseChild$exception$1$1.invoke(MainTest.kt:41)
	at org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt.inTopLevelTransaction$run(ThreadLocalTransactionManager.kt:173)
	at org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt.access$inTopLevelTransaction$run(ThreadLocalTransactionManager.kt:1)
	at org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt$inTopLevelTransaction$1.invoke(ThreadLocalTransactionManager.kt:194)
	at org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt.keepAndRestoreTransactionRefAfterRun(ThreadLocalTransactionManager.kt:202)
	at org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt.inTopLevelTransaction(ThreadLocalTransactionManager.kt:193)
	at org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt$transaction$1.invoke(ThreadLocalTransactionManager.kt:151)
	at org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt.keepAndRestoreTransactionRefAfterRun(ThreadLocalTransactionManager.kt:202)
	at org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt.transaction(ThreadLocalTransactionManager.kt:123)
	at org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt.transaction(ThreadLocalTransactionManager.kt:121)
	at org.jetbrains.exposed.sql.transactions.ThreadLocalTransactionManagerKt.transaction$default(ThreadLocalTransactionManager.kt:120)
	at MainTest$camelCaseChild$exception$1.invoke(MainTest.kt:41)
	at MainTest$camelCaseChild$exception$1.invoke(MainTest.kt:40)
	at MainTest$inlined$sam$i$org_junit_jupiter_api_function_Executable$0.execute(Assertions.kt)
	at org.junit.jupiter.api.AssertThrows.assertThrows(AssertThrows.java:55)
	at org.junit.jupiter.api.AssertThrows.assertThrows(AssertThrows.java:37)
	at org.junit.jupiter.api.Assertions.assertThrows(Assertions.java:2952)
	at MainTest.camelCaseChild(MainTest.kt:49)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:686)
	at org.junit.jupiter.engine.execution.MethodInvocation.proceed(MethodInvocation.java:60)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$ValidatingInvocation.proceed(InvocationInterceptorChain.java:131)
	at org.junit.jupiter.engine.extension.TimeoutExtension.intercept(TimeoutExtension.java:149)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestableMethod(TimeoutExtension.java:140)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestMethod(TimeoutExtension.java:84)
	at org.junit.jupiter.engine.execution.ExecutableInvoker$ReflectiveInterceptorCall.lambda$ofVoidMethod$0(ExecutableInvoker.java:115)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.lambda$invoke$0(ExecutableInvoker.java:105)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$InterceptedInvocation.proceed(InvocationInterceptorChain.java:106)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.proceed(InvocationInterceptorChain.java:64)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.chainAndInvoke(InvocationInterceptorChain.java:45)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.invoke(InvocationInterceptorChain.java:37)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:104)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:98)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$6(TestMethodTestDescriptor.java:205)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:201)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:137)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:71)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:135)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
	at java.util.ArrayList.forEach(ArrayList.java:1259)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
	at java.util.ArrayList.forEach(ArrayList.java:1259)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:108)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:88)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:54)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:67)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:52)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:96)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:75)
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.processAllTestClasses(JUnitPlatformTestClassProcessor.java:99)
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.access$000(JUnitPlatformTestClassProcessor.java:79)
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.stop(JUnitPlatformTestClassProcessor.java:75)
	at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.stop(SuiteTestClassProcessor.java:61)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
	at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:33)
	at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:94)
	at com.sun.proxy.$Proxy2.stop(Unknown Source)
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.stop(TestWorker.java:133)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
	at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:182)
	at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:164)
	at org.gradle.internal.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:414)
	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
	at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:56)
	at java.lang.Thread.run(Thread.java:748)

```

</details>

## Sample code

```kotlin
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
```

And the code that tests it:

```kotlin
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

```