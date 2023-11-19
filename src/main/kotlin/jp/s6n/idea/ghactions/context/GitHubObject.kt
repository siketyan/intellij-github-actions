package jp.s6n.idea.ghactions.context

class GitHubObject : AbstractObject() {
    init {
        addProperty(
            "action", Item.Type.STRING,
            "The name of the action currently running, or the id of a step.",
        )
        addProperty(
            "action_path", Item.Type.STRING,
            "The path where an action is located.",
        )
        addProperty(
            "action_ref", Item.Type.STRING,
            "For a step executing an action, this is the ref of the action being executed.",
        )
        addProperty(
            "action_repository", Item.Type.STRING,
            "For a step executing an action, this is the owner and repository name of the action.",
        )
        addProperty(
            "action_status", Item.Type.STRING,
            "For a composite action, the current result of the composite action.",
        )
        addProperty(
            "actor", Item.Type.STRING,
            "The username of the user that triggered the initial workflow run.",
        )
        addProperty(
            "actor_id", Item.Type.STRING,
            "The account ID of the person or app that triggered the initial workflow run.",
        )
        addProperty(
            "api_url", Item.Type.STRING,
            "The URL of the GitHub REST API.",
        )
        addProperty(
            "base_ref", Item.Type.STRING,
            "The base_ref or target branch of the pull request in a workflow run.",
        )
        addProperty(
            "env", Item.Type.STRING,
            "Path on the runner to the file that sets environment variables from workflow commands.",
        )
        addProperty(
            "event", Item.Type.STRING,
            "The full event webhook payload.",
        )
        addProperty(
            "event_name", Item.Type.STRING,
            "The name of the event that triggered the workflow run.",
        )
        addProperty(
            "event_path", Item.Type.STRING,
            "The path to the file on the runner that contains the full event webhook payload.",
        )
        addProperty(
            "graphql_url", Item.Type.STRING,
            "The URL of the GitHub GraphQL API.",
        )
        addProperty(
            "head_ref", Item.Type.STRING,
            "The head_ref or source branch of the pull request in a workflow run.",
        )
        addProperty(
            "job", Item.Type.STRING,
            "The job_id of the current job.",
        )
        addProperty(
            "path", Item.Type.STRING,
            "Path on the runner to the file that sets system PATH variables from workflow commands.",
        )
        addProperty(
            "ref", Item.Type.STRING,
            "The fully-formed ref of the branch or tag that triggered the workflow run.",
        )
        addProperty(
            "ref_name", Item.Type.STRING,
            "The short ref name of the branch or tag that triggered the workflow run.",
        )
        addProperty(
            "ref_protected", Item.Type.BOOLEAN,
            "true if branch protections or rulesets are configured for the ref that triggered the workflow run.",
        )
        addProperty(
            "ref_type", Item.Type.STRING,
            "The type of ref that triggered the workflow run. Valid values are branch or tag."
        )
        addProperty(
            "repository", Item.Type.STRING,
            "The owner and repository name.",
        )
        addProperty(
            "repository_id", Item.Type.STRING,
            "The ID of the repository.",
        )
        addProperty(
            "repository_owner", Item.Type.STRING,
            "The repository owner's username.",
        )
        addProperty(
            "repository_owner_id", Item.Type.STRING,
            "The repository owner's account ID.",
        )
        addProperty(
            "repositoryUrl", Item.Type.STRING,
            "The Git URL to the repository.",
        )
        addProperty(
            "retention_days", Item.Type.STRING,
            "The number of days that workflow run logs and artifacts are kept.",
        )
        addProperty(
            "run_id", Item.Type.STRING,
            "A unique number for each workflow run within a repository.",
        )
        addProperty(
            "run_number", Item.Type.STRING,
            "A unique number for each run of a particular workflow in a repository.",
        )
        addProperty(
            "run_attempt", Item.Type.STRING,
            "A unique number for each attempt of a particular workflow run in a repository.",
        )
        addProperty(
            "secret_source", Item.Type.STRING,
            "The source of a secret used in a workflow.",
        )
        addProperty(
            "server_url", Item.Type.STRING,
            "The URL of the GitHub server.",
        )
        addProperty(
            "sha", Item.Type.STRING,
            "The commit SHA that triggered the workflow.",
        )
        addProperty(
            "token", Item.Type.STRING,
            "A token to authenticate on behalf of the GitHub App installed on your repository.",
        )
        addProperty(
            "triggering_actor", Item.Type.STRING,
            "The username of the user that initiated the workflow run.",
        )
        addProperty(
            "workflow", Item.Type.STRING,
            "The name of the workflow.",
        )
        addProperty(
            "workflow_ref", Item.Type.STRING,
            "The ref path to the workflow.",
        )
        addProperty(
            "workflow_sha", Item.Type.STRING,
            "The commit SHA for the workflow file.",
        )
        addProperty(
            "workspace", Item.Type.STRING,
            "The default working directory on the runner for steps, and the default location of your" +
                " repository when using the checkout action.",
        )
    }

    override fun name(): String = "github"

    override fun summary(): String = "The top-level context available during any job or step in a workflow."

    companion object {
        val INSTANCE = GitHubObject()
    }
}
