package ui;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import model.PizzaOrder;
import dao.PizzaOrderDAO;
import util.TotalBillCalculator;

import java.util.List;

public class PizzaOrderingScene {

    public Scene createScene() {
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        TextField nameField = new TextField();
        nameField.setPromptText("Customer Name");

        TextField mobileField = new TextField();
        mobileField.setPromptText("Mobile Number");

        ComboBox<String> sizeBox = new ComboBox<>();
        sizeBox.getItems().addAll("S", "M", "L", "XL");
        sizeBox.setPromptText("Select Pizza Size");

        Spinner<Integer> toppingsSpinner = new Spinner<>(0, 10, 0);
        toppingsSpinner.setEditable(true);

        Button placeOrderBtn = new Button("Place Order");
        Button viewOrdersBtn = new Button("View Orders");

        placeOrderBtn.setOnAction(e -> {
            try {
                String name = nameField.getText();
                String mobile = mobileField.getText();
                String size = sizeBox.getValue();
                int toppings = toppingsSpinner.getValue();

                double total = TotalBillCalculator.calculateTotal(size, toppings);
                PizzaOrder order = new PizzaOrder(0, name, mobile, size, toppings, total);
                PizzaOrderDAO dao = new PizzaOrderDAO();
                dao.insertOrder(order);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Order Placed");
                alert.setContentText("Total Bill: $" + total);
                alert.showAndWait();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        viewOrdersBtn.setOnAction(e -> showOrders());

        layout.getChildren().addAll(nameField, mobileField, sizeBox, toppingsSpinner, placeOrderBtn, viewOrdersBtn);
        return new Scene(layout, 400, 400);
    }

    private void showOrders() {
        try {
            PizzaOrderDAO dao = new PizzaOrderDAO();
            List<PizzaOrder> orders = dao.getAllOrders();

            StringBuilder sb = new StringBuilder("Stored Pizza Orders:\n\n");
            for (PizzaOrder order : orders) {
                sb.append("ID: ").append(order.getId())
                  .append(" | Name: ").append(order.getCustomerName())
                  .append(" | Size: ").append(order.getPizzaSize())
                  .append(" | Toppings: ").append(order.getToppings())
                  .append(" | Total: $").append(order.getTotalBill())
                  .append("\n");
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pizza Orders");
            alert.setHeaderText(null);
            alert.setContentText(sb.toString());
            alert.setResizable(true);
            alert.getDialogPane().setPrefWidth(380);
            alert.showAndWait();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
