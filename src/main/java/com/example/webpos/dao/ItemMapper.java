package com.example.webpos.dao;

import com.example.webpos.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    int deleteByPrimaryKey(String product);

    int insert(Item row);

    Item selectByPrimaryKey(String product);

    List<Item> selectAll();

    int updateByPrimaryKey(Item row);

    void deleteAll();
}