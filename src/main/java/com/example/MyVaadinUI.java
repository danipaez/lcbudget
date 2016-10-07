package com.example;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

@SpringUI
 public class MyVaadinUI extends UI {
    private CustomerService service = CustomerService.getInstance();
    private Grid grid = new Grid();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        grid.setColumns("firstName", "lastName", "email");
        // add Grid to the layout
        layout.addComponent(grid);

        updateList();

        layout.setMargin(true);
        setContent(layout);
    }

    public void updateList() {
        // fetch list of Customers from service and assign it to Grid
        List<Customer> customers = service.findAll();
        grid.setContainerDataSource(new BeanItemContainer<>(Customer.class, customers));
    }
}