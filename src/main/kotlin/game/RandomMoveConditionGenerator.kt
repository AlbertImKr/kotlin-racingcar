package game

class RandomMoveConditionGenerator : MoveConditionGenerator {
    private val minValue = 0
    private val maxValue = 9

    override fun generate(): Int {
        return (minValue..maxValue).random()
    }
}
