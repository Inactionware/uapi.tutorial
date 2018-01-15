package uapi.tutorial.config;

import uapi.config.annotation.Config;
import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

import java.util.List;

@Tag("CustomizedConfig")
@Service(autoActive = true)
public class CustomizedConfigService {

    @Config(path="cfg.users", parser=UserParser.class)
    protected List<User> _users;

    @Inject
    protected ILogger _logger;

    @OnActivate
    public void onActivate() {
        this._logger.info("The user is {}", this._users);
    }
}
