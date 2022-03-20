package com.example.webpos.dao;

import com.example.webpos.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(Product row);

    Product selectByPrimaryKey(String id);

    List<Product> selectAll();

    int updateByPrimaryKey(Product row);
}