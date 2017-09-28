package axoniqhack.display;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
public class DisplayApplication extends Application {

    private final static AtomicReference<GUI> gui = new AtomicReference<GUI>();

    public void init() {
        ConfigurableApplicationContext context = SpringApplication.run(DisplayApplication.class, new String[0]);
        GUI gui = new GUI();
        context.getAutowireCapableBeanFactory().autowireBean(gui);
        this.gui.set(gui);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.gui.get().start(primaryStage);
    }

    public static GUI getGui() {
        return gui.get();
    }
}