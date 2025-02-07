package game

object InputValidator {
    private const val DIGIT_PATTERN = "[1-9][0-9]*"

    fun validateCount(input: String) {
        require(input.isPositiveInteger()) { ErrorMessage.INVALID_INPUT_ERROR_MSG.message }
    }

    private fun String.isPositiveInteger() = this.matches(Regex(DIGIT_PATTERN))
}
