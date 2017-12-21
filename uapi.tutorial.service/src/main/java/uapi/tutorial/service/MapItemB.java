package uapi.tutorial.service;

import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

@Service(IMapItem.class)
@Tag("MapBasedInjection")
public class MapItemB implements IMapItem {

    @Override
    public String getId() {
        return "MapItemB";
    }
}
