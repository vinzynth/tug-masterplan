package at.chrl.tug.masterplan.config;

import at.chrl.nutils.configuration.ConfigUtil;
import at.chrl.nutils.configuration.Property;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by ChRL on 24.02.16.
 * Project: masterplan
 * Package: at.chrl.tug.masterplan.config
 * <p>
 * <br>
 */
@Configuration
public class Masterplan {

    @Property(key = "spring.datasource.url", defaultValue = "jdbc:mysql://srv06.bravestone.at/test")
    public static String DATASOURCE_URL;

    @Property(key = "spring.datasource.username", defaultValue = "root")
    public static String DATASOURCE_USERNAME;

    @Property(key = "spring.datasource.password", defaultValue = "")
    public static String DATASOURCE_PASSWORD;

    @Property(key = "spring.datasource.driver-class-name", defaultValue = "com.mysql.jdbc.Driver")
    public static String DATASOURCE_DRIVER_CLASS_NAME;

    @Property(key = "hibernate.hbm2ddl.auto", defaultValue = "update")
    public static String HIBERNATE_HBM_TO_DDL;

    @Bean
    public PropertySource masterplanProperties(){
        return new PropertySource("masterplanProperties") {
            @Override
            public Object getProperty(String name) {
                return ConfigUtil.getInstance().getProperties(Masterplan.class).get(name);
            }
        };
    }

    @Bean
    public DataSource dataSource(){
        return new HikariDataSource(hikareConfig());
    }

    @Bean
    public HikariConfig hikareConfig() {
        final HikariConfig config = new HikariConfig();
        config.setDriverClassName(Masterplan.DATASOURCE_DRIVER_CLASS_NAME);
        config.setJdbcUrl(Masterplan.DATASOURCE_URL);
        config.setUsername(Masterplan.DATASOURCE_USERNAME);
        config.setPassword(Masterplan.DATASOURCE_PASSWORD);
        return config;
    }

}
