package uapi.tutorial.behavior;

import uapi.app.AppStartupEvent;
import uapi.behavior.ActionIdentify;
import uapi.behavior.IExecutionContext;
import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service
@Action
@Tag("SimpleBehavior")
public class SimpleAction {

    public static final ActionIdentify actionId = ActionIdentify.toActionId(SimpleAction.class);

    @Inject
    protected ILogger _logger;

    @ActionDo
    public void execute(AppStartupEvent event, IExecutionContext execCtx) {
        this._logger.info("Execute in SimpleAction by {}.", execCtx.behaviorName());
    }
}
