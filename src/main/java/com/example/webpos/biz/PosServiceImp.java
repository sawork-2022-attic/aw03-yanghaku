package com.example.webpos.biz;

import com.example.webpos.dao.ItemMapper;
import com.example.webpos.dao.ProductMapper;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Item;
import com.example.webpos.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosServiceImp implements PosService {

    private ItemMapper itemMapper;

    private ProductMapper productMapper;

    private Cart cart;


    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Autowired
    public void setItemMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public Cart getCart() { // 查询数据库, 更新内存中的cart
        cart.getItems().clear();
        List<Item> items = itemMapper.selectAll();
        for (Item item : items) {
            Product product = productMapper.selectByPrimaryKey(item.getProduct());
            cart.addItem(product, item.getQuantity());
        }
        return cart;
    }

    @Override
    public Cart newCart() { // 空了当前的购物车, 然后将修改写入数据库
        cart.getItems().clear();
        itemMapper.deleteAll();
        return cart;
    }

    @Override
    public void checkout(Cart cart) {

    }

    @Override
    public double total() {
        return this.cart.getTotal();
    }

    @Override
    public boolean add(Product product, int amount) {
        return add(product.getId(), amount);
    }

    @Override
    public boolean add(String productId, int amount) {
        if (amount <= 0) return false;

        Item item;
        // 如果已经有了, 那么就加 amount
        if ((item = itemMapper.selectByPrimaryKey(productId)) != null) {
            item.setQuantity(item.getQuantity() + amount);
            itemMapper.updateByPrimaryKey(item);
        } else {
            item = new Item();
            item.setProduct(productId);
            item.setQuantity(amount);
            itemMapper.insert(item);
        }
        this.cart = getCart(); // 更新内存中的购物车
        return true;
    }

    @Override
    public Cart emptyCart() {
        return newCart();
    }

    @Override
    public boolean delete(String productId) {
        itemMapper.deleteByPrimaryKey(productId);
        this.cart = getCart(); // 更新内存中的购物车
        return true;
    }

    @Override
    public boolean modify(String productId, int amount) {
        if (amount < 0) return false;
        if (amount == 0) return delete(productId);
        Item item = new Item();
        item.setProduct(productId);
        item.setQuantity(amount);
        itemMapper.updateByPrimaryKey(item);
        return true;
    }

    @Override
    public List<Product> products() {
        return productMapper.selectAll();
    }
}
