package com.travel.mapper;

import com.travel.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

public interface GoodsMapper {
    //查询商品
    List<Goods> getGoodsListByPage(HashMap<String, Object> map);

    //增加商品
    boolean insertGoods(Goods goods);

    //修改商品
    boolean updateGoods(Goods goods);

    //删除商品
    boolean deleteGoods(String id);

}