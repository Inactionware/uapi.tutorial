package uapi.tutorial.service;

/**
 * A greeting interface to return greeting message
 */
public interface IGreeting {

    /**
     * Say hello to somebody
     *
     * @param   name
     *          The name to say hello
     * @return  Greeting message
     */
    String sayHello(String name);
}
