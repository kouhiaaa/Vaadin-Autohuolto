package com.autohuolto.autohuolto.view;

import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class FooterView extends VerticalLayout {

    public FooterView() {
        Footer footer = new Footer();
        footer.add("© 2025 Autohuolto");
        add(footer);
    }
}
