package com.example.webpos.biz;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;

import java.util.List;

public interface PosService {
    public Cart getCart();

    public Cart newCart();

    public void checkout(Cart cart);

    public double total();

    public boolean add(Product product, int amount);

    public boolean add(String productId, int amount);

    public Cart emptyCart();

    public boolean delete(String productId);

    public boolean modify(String productId, int amount);

    public List<Product> products();
}
