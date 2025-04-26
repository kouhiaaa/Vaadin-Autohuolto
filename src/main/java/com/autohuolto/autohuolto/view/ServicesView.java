package com.autohuolto.autohuolto.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "services", layout = MainLayout.class)
public class ServicesView extends VerticalLayout {

    public ServicesView() {
        Div serviceText = new Div();
        serviceText.setText("Here are the services we offer. We specialize in car maintenance and repairs.");

        add(serviceText);

    }
}
