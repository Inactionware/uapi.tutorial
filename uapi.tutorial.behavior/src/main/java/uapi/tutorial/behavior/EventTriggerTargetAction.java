package uapi.tutorial.behavior;

import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Action
@Tag("EventTrigger")
public class EventTriggerTargetAction {

    @Inject
    protected ILogger _logger;

    @ActionDo
    public void execute(final TriggerEvent event) {
        this._logger.info("Receive an event from {}", event.sourceName());
    }
}
