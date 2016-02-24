package at.chrl.tug.masterplan.ui

import at.chrl.tug.masterplan.data.Catalogue
import com.vaadin.annotations.Theme
import com.vaadin.annotations.Title
import com.vaadin.server.Responsive
import com.vaadin.server.Sizeable
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.*
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
class MasterplanUI() : com.vaadin.ui.UI() {

    override fun init(request: VaadinRequest?) {
        locale = Locale.GERMAN;

        Responsive.makeResponsive(this);
        setSizeFull();

        addStyleName(ValoTheme.UI_WITH_MENU);

        this.content = updateContent();
    }

    fun updateContent(): Component{
        val main = HorizontalLayout();
        main.setSizeFull();


        val left = VerticalLayout();
        val right = VerticalLayout();
        left.setHeight(100f, Sizeable.Unit.PERCENTAGE);
        right.setHeight(100f, Sizeable.Unit.PERCENTAGE);
        left.setWidthUndefined();


        val c = CheckComponent();
        c.setSizeFull();
        left.addComponent(c);
        right.addComponent(Label("blub"))

        main.addComponents(left, right);
        main.setExpandRatio(left, 0.25f);
        main.setExpandRatio(right, 0.75f);

        return main;
    }
}

class CheckComponent : VerticalLayout() {

    val statusMap : HashMap<Catalogue, StatusComponent> = HashMap();

    init {
        val l = Label("Wahlfachkataloge:");
        this.addComponent(l);

        l.setHeight(10f, Sizeable.Unit.PERCENTAGE);


        val g = Grid();

        g.setSizeFull();

        g.addColumn("Katalog", String::class.java);
        g.addColumn("Titel", String::class.java);
        g.addColumn("Status", String::class.java);

        Arrays.stream(Catalogue.values())
            .forEach { c ->
                /*
                val lay = HorizontalLayout();
                lay.setSizeFull();
                lay.setWidthUndefined();
                val s = Label(c.name);
                s.setWidthUndefined();

                lay.addComponent(s);
                val t = Label(c.title);
                t.setWidthUndefined();
                lay.addComponent(t);
                */
                val stat = StatusComponent();
                statusMap.put(c, stat);
                /*
                stat.setWidthUndefined();
                lay.addComponent(stat);

                lay.setExpandRatio(stat, 0.4f);
                lay.setExpandRatio(t, 0.5f);
                lay.setExpandRatio(s, 0.1f);

                this.addComponent(lay);
                */

                g.addRow(c.name, c.title, "Status");
            };

        this.addComponent(g);
    }

}

class StatusComponent : HorizontalLayout(){

    init {
        this.addComponent(Label("Status"));
    }
}
