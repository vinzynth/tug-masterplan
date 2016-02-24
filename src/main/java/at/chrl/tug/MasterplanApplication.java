package at.chrl.tug;

import at.chrl.nutils.configuration.ConfigUtil;
import at.chrl.tug.masterplan.config.Masterplan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MasterplanApplication {

	public static void main(String[] args) {
        ConfigUtil.getInstance().loadAndExport(Masterplan.class);

        ConfigUtil.getInstance().getProperties(Masterplan.class).forEach((k,v) -> System.setProperty(k.toString(), v.toString()));

		SpringApplication.run(new Object[]{
                Masterplan.class,
                MasterplanApplication.class
        }, args);
	}
}
