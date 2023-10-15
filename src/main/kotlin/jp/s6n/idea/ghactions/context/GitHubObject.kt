package jp.s6n.idea.ghactions.context

class GitHubObject : AbstractObject() {
    init {
        addProperty(
            "action", Property.Type.STRING,
            "The name of the action currently running, or the id of a step.",
        )
        addProperty(
            "action_path", Property.Type.STRING,
            "The path where an action is located.",
        )
        addProperty(
            "action_ref", Property.Type.STRING,
            "For a step executing an action, this is the ref of the action being executed.",
        )
        addProperty(
            "action_repository", Property.Type.STRING,
            "For a step executing an action, this is the owner and repository name of the action.",
        )
        addProperty(
            "action_status", Property.Type.STRING,
            "For a composite action, the current result of the composite action.",
        )
        addProperty(
            "actor", Property.Type.STRING,
            "The username of the user that triggered the initial workflow run.",
        )
        addProperty(
            "actor_id", Property.Type.STRING,
            "The account ID of the person or app that triggered the initial workflow run.",
        )
        addProperty(
            "api_url", Property.Type.STRING,
            "The URL of the GitHub REST API.",
        )
        addProperty(
            "base_ref", Property.Type.STRING,
            "The base_ref or target branch of the pull request in a workflow run.",
        )
        addProperty(
            "env", Property.Type.STRING,
            "Path on the runner to the file that sets environment variables from workflow commands.",
        )
        addProperty(
            "event", Property.Type.STRING,
            "The full event webhook payload.",
        )
        addProperty(
            "event_name", Property.Type.STRING,
            "The name of the event that triggered the workflow run.",
        )
        addProperty(
            "event_path", Property.Type.STRING,
            "The path to the file on the runner that contains the full event webhook payload.",
        )
        addProperty(
            "graphql_url", Property.Type.STRING,
            "The URL of the GitHub GraphQL API.",
        )
        addProperty(
            "head_ref", Property.Type.STRING,
            "The head_ref or source branch of the pull request in a workflow run.",
        )
        addProperty(
            "job", Property.Type.STRING,
            "The job_id of the current job.",
        )
        addProperty(
            "path", Property.Type.STRING,
            "Path on the runner to the file that sets system PATH variables from workflow commands.",
        )
        addProperty(
            "ref", Property.Type.STRING,
            "The fully-formed ref of the branch or tag that triggered the workflow run.",
        )
        addProperty(
            "ref_name", Property.Type.STRING,
            "The short ref name of the branch or tag that triggered the workflow run.",
        )
        addProperty(
            "ref_protected", Property.Type.BOOLEAN,
            "true if branch protections or rulesets are configured for the ref that triggered the workflow run.",
        )
        addProperty(
            "ref_type", Property.Type.STRING,
            "The type of ref that triggered the workflow run. Valid values are branch or tag."
        )
        addProperty(
            "repository", Property.Type.STRING,
            "The owner and repository name.",
        )
        addProperty(
            "repository_id", Property.Type.STRING,
            "The ID of the repository.",
        )
        addProperty(
            "repository_owner", Property.Type.STRING,
            "The repository owner's username.",
        )
        addProperty(
            "repository_owner_id", Property.Type.STRING,
            "The repository owner's account ID.",
        )
        addProperty(
            "repositoryUrl", Property.Type.STRING,
            "The Git URL to the repository.",
        )
        addProperty(
            "retention_days", Property.Type.STRING,
            "The number of days that workflow run logs and artifacts are kept.",
        )
        addProperty(
            "run_id", Property.Type.STRING,
            "A unique number for each workflow run within a repository.",
        )
        addProperty(
            "run_number", Property.Type.STRING,
            "A unique number for each run of a particular workflow in a repository.",
        )
        addProperty(
            "run_attempt", Property.Type.STRING,
            "A unique number for each attempt of a particular workflow run in a repository.",
        )
        addProperty(
            "secret_source", Property.Type.STRING,
            "The source of a secret used in a workflow.",
        )
        addProperty(
            "server_url", Property.Type.STRING,
            "The URL of the GitHub server.",
        )
        addProperty(
            "sha", Property.Type.STRING,
            "The commit SHA that triggered the workflow.",
        )
        addProperty(
            "token", Property.Type.STRING,
            "A token to authenticate on behalf of the GitHub App installed on your repository.",
        )
        addProperty(
            "triggering_actor", Property.Type.STRING,
            "The username of the user that initiated the workflow run.",
        )
        addProperty(
            "workflow", Property.Type.STRING,
            "The name of the workflow.",
        )
        addProperty(
            "workflow_ref", Property.Type.STRING,
            "The ref path to the workflow.",
        )
        addProperty(
            "workflow_sha", Property.Type.STRING,
            "The commit SHA for the workflow file.",
        )
        addProperty(
            "workspace", Property.Type.STRING,
            "The default working directory on the runner for steps, and the default location of your" +
                " repository when using the checkout action.",
        )
    }

    override fun name(): String = "github"

    companion object {
        val INSTANCE = GitHubObject()
    }
}
