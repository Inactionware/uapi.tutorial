package uapi.tutorial.config;

import uapi.common.StringHelper;

public class Address {

    public String office;
    public String home;

    public String toString() {
        return StringHelper.makeString("office->{}, home->{}", office, home);
    }
}
