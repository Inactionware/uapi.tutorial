package uapi.tutorial.behavior;

import uapi.app.AppStartupEvent;
import uapi.behavior.IExecutionContext;
import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Action
@Tag("EventTrigger")
public class EventTriggerSourceAction {

    @Inject
    protected ILogger _logger;

    @ActionDo
    public void execute(final AppStartupEvent event, final IExecutionContext execCtx) {
        this._logger.info("Raise an event from {}", execCtx.responsibleName());
        execCtx.fireEvent(new TriggerEvent(execCtx.responsibleName()));

    }
}
