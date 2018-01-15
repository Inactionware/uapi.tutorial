package uapi.tutorial.config;

import uapi.common.StringHelper;

public class User {

    public String name;
    public Address address;

    public String toString() {
        return StringHelper.makeString("name: {}, address: {}", name, address);
    }
}
