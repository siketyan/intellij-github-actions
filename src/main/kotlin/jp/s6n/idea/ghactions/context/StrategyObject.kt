package jp.s6n.idea.ghactions.context

class StrategyObject : AbstractObject() {
    init {
        addProperty(
            "fail-fast", Item.Type.BOOLEAN,
            "When this evaluates to true, all in-progress jobs are canceled if any job in a matrix fails.",
        )
        addProperty(
            "job-matrix", Item.Type.INTEGER,
            "The index of the current job in the matrix.",
        )
        addProperty(
            "job-total", Item.Type.INTEGER,
            "The total number of jobs in the matrix.",
        )
        addProperty(
            "max-parallel", Item.Type.INTEGER,
            "The maximum number of jobs that can run simultaneously when using a matrix job strategy.",
        )
    }

    override fun name(): String = "strategy"

    override fun summary(): String = "Information about the matrix execution strategy for the current job."

    companion object {
        val INSTANCE = StrategyObject()
    }
}
