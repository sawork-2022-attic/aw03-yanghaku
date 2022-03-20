package com.example.webpos.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    /**
     * 定义的内部类, ItemEntry, 存储每个item的实体 (因为关系数据库item的表全是Product的索引)
     */
    static class ItemEntry {
        private final Product product;
        private final int quantity;

        public ItemEntry(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    private final List<ItemEntry> items = new ArrayList<>();

    public boolean addItem(Product product, int amount) {
        return items.add(new ItemEntry(product, amount));
    }

    public double getTotal() {
        double sum = 0;
        for (ItemEntry item : items) {
            sum += item.getQuantity() * item.getProduct().getPrice();
        }
        return sum;
    }

    public List<ItemEntry> getItems() {
        return items;
    }
}
