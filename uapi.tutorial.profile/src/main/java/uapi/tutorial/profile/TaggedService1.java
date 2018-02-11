package uapi.tutorial.profile;

import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("MyTag1")
public class TaggedService1 {

    @Inject
    protected ILogger _logger;

    @OnActivate
    public void onActivate() {
        this._logger.info("Tagged Service1 activated.");
    }
}
