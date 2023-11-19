package jp.s6n.idea.ghactions.context

class StrategyObject : AbstractObject() {
    init {
        addProperty(
            "fail-fast", Property.Type.BOOLEAN,
            "When this evaluates to true, all in-progress jobs are canceled if any job in a matrix fails.",
        )
        addProperty(
            "job-matrix", Property.Type.INTEGER,
            "The index of the current job in the matrix.",
        )
        addProperty(
            "job-total", Property.Type.INTEGER,
            "The total number of jobs in the matrix.",
        )
        addProperty(
            "max-parallel", Property.Type.INTEGER,
            "The maximum number of jobs that can run simultaneously when using a matrix job strategy.",
        )
    }

    override fun name(): String = "strategy"

    companion object {
        val INSTANCE = StrategyObject()
    }
}
