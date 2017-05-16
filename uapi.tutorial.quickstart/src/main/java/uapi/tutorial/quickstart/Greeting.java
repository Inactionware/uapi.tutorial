package uapi.tutorial.quickstart;

import uapi.app.AppStartupEvent;
import uapi.behavior.ActionIdentify;
import uapi.behavior.ActionType;
import uapi.behavior.IExecutionContext;
import uapi.behavior.annotation.Action;
import uapi.behavior.annotation.ActionDo;
import uapi.common.StringHelper;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

/**
 * A Greeting will output hello word to the logger
 */
@Service
@Action
@Tag("BabyHello")
public class Greeting {

    public static final ActionIdentify actionId = ActionIdentify.parse(
            StringHelper.makeString("{}@{}", Greeting.class.getName(), ActionType.ACTION));

    @Inject
    protected ILogger _logger;

    @ActionDo
    public void say(AppStartupEvent event, IExecutionContext execCtx) {
        this._logger.info("Hello World form {}", execCtx.responsibleName());
    }
}
