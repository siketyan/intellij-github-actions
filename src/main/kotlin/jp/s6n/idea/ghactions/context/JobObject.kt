package jp.s6n.idea.ghactions.context

import jp.s6n.idea.ghactions.schema.Job

class JobObject(
    job: Job,
) : AbstractObject() {
    class ServicesObject(
        services: Map<String, Job.Container>,
    ) : AbstractObject() {
        class ServiceItem(
            service: Job.Container,
        ) : AbstractObject() {
            class PortsObject(
                ports: List<Int>,
            ) : AbstractObject() {
                init  {
                    ports.forEach {
                        addProperty(it.toString(), Item.Type.STRING)
                    }
                }

                override fun summary(): String = "The exposed ports of the service container."
            }

            init {
                addProperty(
                    "id", Item.Type.STRING,
                    "The ID of the service container.",
                )
                addProperty(
                    "network", Item.Type.STRING,
                    "The ID of the service container network.",
                )

                service.ports?.let {
                    add("ports", PortsObject(it))
                }
            }
        }

        init {
            services.forEach { (id, service) ->
                add(id, ServiceItem(service))
            }
        }

        override fun summary(): String = "The service containers created for a job."
    }

    init {
        add("container", JobContainerObject.INSTANCE)

        addProperty(
            "status", Item.Type.STRING,
            "The current status of the job."
        )

        job.services?.let {
            add("services", ServicesObject(it))
        }
    }

    override fun summary(): String = "Information about the currently running job."
}
