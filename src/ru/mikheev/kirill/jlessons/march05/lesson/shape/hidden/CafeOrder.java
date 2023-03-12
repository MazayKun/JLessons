package ru.mikheev.kirill.jlessons.march05.lesson.shape.hidden;

public class CafeOrder {

    private StringBuilder order = new StringBuilder("");
    private boolean isOrderEnded = false;

    public CafeOrder addSalad(String saladName) {
        order.append(saladName)
                .append(", ");
        return this;
    }


    public CafeOrder addMainDish(String dishName) {
        order.append(dishName)
                .append(", ");
        return this;
    }

    public void endOrder() {
        isOrderEnded = true;
        order.delete(order.lastIndexOf(","), order.length());
    }

    @Override
    public String toString() {
        if(!isOrderEnded)  endOrder();
        return order.toString();
    }
}
