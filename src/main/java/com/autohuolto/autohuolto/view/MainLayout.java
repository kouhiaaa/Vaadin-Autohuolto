package com.autohuolto.autohuolto.view;

import com.vaadin.flow.component.ScrollOptions;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();

    }

    private void createHeader() {
        H1 logo = new H1("Autohuolto");
        logo.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");

        DrawerToggle toggle = new DrawerToggle();
        HorizontalLayout header = new HorizontalLayout(toggle, logo);
        header.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        header.setWidth("100%");
        header.setPadding(true);

        addToNavbar(header);
    }

    private void createDrawer() {
        addToDrawer(
                new RouterLink("Etusivu", MainView.class),
                new RouterLink("Huollot", HuoltoGridView.class),
                new RouterLink("Autot", DataGridView.class)
        );
    }


}
