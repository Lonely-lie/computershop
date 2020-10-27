package com.example.computershop.mapper;

import com.example.computershop.domain.entity.ProductType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//@Mapper
public interface ProductTypeMapper {
    //获取分类数据，list
    List<ProductType> list(@Param("offset") int offset, @Param("size") int size);
    //获取分类数据总数量
    int listCount();
    //后台插入新商品类型
    int insert(ProductType productType);
    //后台更新商品类型
    int update(ProductType productType);
    //后台后台删除商品类型
    int deleteUpdate(ProductType productType);



    //首页获取商品类型集合
    List<ProductType> listAll();//获取商品类型不需要分页

    ProductType findByOne(int tid);//根据商品类型ID找到商品类型对象
}
