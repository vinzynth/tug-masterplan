package at.chrl.tug.masterplan.ui

import com.vaadin.annotations.Theme
import com.vaadin.annotations.Title
import com.vaadin.server.Responsive
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Component
import com.vaadin.ui.Label
import com.vaadin.ui.themes.ValoTheme
import java.util.*

/**
 * Created by ChRL on 24.02.16.
 * Project: masterplan
 * Package: at.chrl.tug.masterplan.ui
 * <p>
 * <br>
 */
@SpringUI
@Theme("valo")
@Title("ICE Curriculum Builder")
class MasterplanUI(content: Component?) : com.vaadin.ui.UI(content) {

    override fun init(request: VaadinRequest?) {
        locale = Locale.GERMAN;

        Responsive.makeResponsive(this);
        setSizeFull();

        addStyleName(ValoTheme.UI_WITH_MENU);

        this.content = Label("Test");
    }

}
