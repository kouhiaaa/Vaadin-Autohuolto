package com.autohuolto.autohuolto.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "home", layout = MainLayout.class)
public class HomeView extends VerticalLayout {

    public HomeView() {
        Div introText = new Div();
        introText.setText("Welcome to the Autohuolto homepage! Here you can find information about our services.");

        add(introText);
    }
}
