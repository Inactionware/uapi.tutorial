package uapi.tutorial.config;

import uapi.common.CollectionHelper;
import uapi.config.IConfigValueParser;
import uapi.rx.Looper;
import uapi.service.annotation.Service;
import uapi.service.annotation.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Tag("CustomizedConfig")
@Service(IConfigValueParser.class)
public class UserParser implements IConfigValueParser {

    private static final String[] supportedTypesIn  = new String[] { List.class.getCanonicalName() };
    private static final String[] supportedTypesOut = new String[] { List.class.getCanonicalName() };

    @Override
    public boolean isSupport(String inType, String outType) {
        return CollectionHelper.isContains(supportedTypesIn, inType) && CollectionHelper.isContains(supportedTypesOut, outType);
    }

    @Override
    public String getName() {
        return UserParser.class.getCanonicalName();
    }

    @Override
    public List<User> parse(Object value) {
        List<Map> usersCfg = (List) value;
        List<User> users = new ArrayList<>();
        Looper.on(usersCfg).foreach(userCfg -> {
            String name = userCfg.get("name").toString();
            Map addresses = (Map) userCfg.get("addresses");
            String addrOffice = addresses.get("office").toString();
            String addrHome = addresses.get("home").toString();
            User user = new User();
            user.name = name;
            user.address = new Address();
            user.address.office = addrOffice;
            user.address.home = addrHome;
            users.add(user);
        });
        return users;
    }
}
