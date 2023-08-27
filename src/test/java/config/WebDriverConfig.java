package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:webdriver.properties"})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.amazon.com")
    String baseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
}