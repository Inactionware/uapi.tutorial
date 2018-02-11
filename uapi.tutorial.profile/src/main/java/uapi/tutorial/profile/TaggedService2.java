package uapi.tutorial.profile;

import uapi.log.ILogger;
import uapi.service.annotation.Inject;
import uapi.service.annotation.OnActivate;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(autoActive = true)
@Tag("MyTag2")
public class TaggedService2 {

    @Inject
    protected ILogger _logger;

    @OnActivate
    public void onActivate() {
        this._logger.info("Tagged Service2 activated.");
    }
}
