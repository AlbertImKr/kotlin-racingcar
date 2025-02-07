package calculator

import calculator.CalculatorParser.getFirstValue
import calculator.CalculatorParser.getNextValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorParserTest {

    @ParameterizedTest
    @CsvSource(value = ["2 + 3 * 4 / 2:7", "3 + 4 / 5:5", "3 + 1:3"], delimiter = ':')
    fun `입력값을 공백을 기준으로 분리한다`(input: String, expect: Int) {
        // when
        val actual = CalculatorParser.split(input)

        // then
        assertThat(actual.size).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["1:3", "2:4", "3:5"], delimiter = ':')
    fun `연산자의 위치를 기준으로 다음 값을 int로 변환하고 가져온다`(currentIndex: Int, expect: Int) {
        // given
        val input = listOf("1", "2", "3", "4", "5")

        // when
        val actual = input.getNextValue(currentIndex)

        // then
        assertThat(actual).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["1", "2", "3", "4", "5"], delimiter = ':')
    fun `첫번째 값을 int로 변환하고 가져온다`(first: String) {
        // given
        val input = listOf(first, "2", "3", "4", "5")

        // when
        val actual = input.getFirstValue()

        // then
        assertThat(actual).isEqualTo(first.toInt())
    }
}
