import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//@IncludeTags({"","Circle"})
//@RunWith(JUnitPlatform.class)
//@ExcludeTags({"Math"})
class MathUtilsTest {
    private MathUtils mathUtils;
//  используются для рефлексии теста
    private TestInfo testInfo;
    private TestReporter testReporter;

//  этот метод должен быть статическим, так как он выполняется всего 1 раз
//  и даже перед созданием самого инстанса данного тест-класса
    @BeforeAll
    static void beforeAll() {
        System.out.println("Static method that runs @BeforeAll test methods");
    }

//  выполняется перед запуском каждого метода
    @BeforeEach
    void initialize(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Given test is run with @DisplayName: [" + testInfo.getDisplayName() +
                                        "] and following tags: [" + testInfo.getTags() + "]");
        System.out.println("@BeforeEach at work");
    }

    @Test
//  можно отметить тест тегом @Tag, чтобы потом, например, через конфиг
//  запускать только тесты, отмеченные данным тегом (еще можно через maven surefire plugin)
    @Tag("Math")
    void testAdd() {
        boolean condition = false;
        assumeTrue(condition);
        assertEquals(3,
                mathUtils.add(1, 2),
                () -> "The add() method should add two numbers"); // при использовании лямбды сообщение будет зафетчено
                                                                  // lazily, в данном случае только когда тест зафейлится
    }


    @Nested
//  @DisplayName используется для более информативного описания теста
    @DisplayName("Testing multiply method")
    @Tag("Math")
    class multiplyTest {

        @Test
        @DisplayName("Multiplying two positive numbers")
        void multiplyTest1() {
            assertEquals(9 , mathUtils.multiply(3, 3));
        }

        @Test
        @DisplayName("Multiplying two negative numbers")
        void multiplyTest2() {
            assertEquals(9 , mathUtils.multiply(-3, -3));
        }
    }

    @Test
    @DisplayName("Testing subtract method")
    @Tag("Math")
    void subtractTest() {
//      еще один способ (помимо @Nested) группировать тесты одного вида
        assertAll(
                () -> assertEquals(0 , mathUtils.subtract(-3, -3)),
                () -> assertEquals(0 , mathUtils.subtract(3, 3)),
                () -> assertEquals(6 , mathUtils.subtract(3, -3)),
                () -> assertEquals(-6 , mathUtils.subtract(-3, 3))
        );
    }


    @Test
    @DisplayName("Testing divide method")
    @Tag("Math")
    void testDivide() {
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(1, 0),
                "Divide by zero should throw exception");
    }

//  Тест можно повторять несколько раз, причем при разных повторениях выбирать разные ветки при помощи RepetitionInfo
    @RepeatedTest(3)
    @Tag("Circle")
    void testComputeCircleArea(RepetitionInfo repetitionInfo) {
        if (repetitionInfo.getCurrentRepetition() == 1) {
            System.out.println("Repetition 1");
        }
        if (repetitionInfo.getCurrentRepetition() == 2) {
            System.out.println("Repetition 2");
        }
        if (repetitionInfo.getCurrentRepetition() == 3) {
            double radius = 2;
            assertEquals(Math.PI * radius * radius,
                    mathUtils.computeCircleArea(radius),
                    "The computeCircleArea() method should return correct circle area");
        }
    }

    @Test
    @Disabled
    void shouldNotRun() {
        fail("This test should be disabled");
    }
}