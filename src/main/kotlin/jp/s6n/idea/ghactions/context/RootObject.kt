package jp.s6n.idea.ghactions.context

import jp.s6n.idea.ghactions.schema.Workflow

class RootObject(
    workflow: Workflow,
    jobName: String? = null,
) : AbstractObject() {
    init {
        add("github", GitHubObject)
        add("env", EnvObject)
        add("vars", VarsObject)
        add("jobs", JobsObject(workflow))
        add("runner", RunnerObject)
        add("secrets", SecretsObject.INSTANCE)
        add("strategy", StrategyObject)

        jobName?.let { workflow.jobs?.get(it) }?.let { job ->
            add("job", JobObject(job))

            job.needs?.let {
                add("needs", NeedsObject(workflow, it))
            }

            job.steps?.let {
                add("steps", StepsObject(it))
            }
        }
    }
}
