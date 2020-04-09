/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.service;

import com.example.shici.entity.dto.Category;
import com.example.shici.entity.common.CommonPageable;

import java.util.List;

public interface CategoryDao {

    /**
     * 创建标签
     *
     * @param category
     */
    Category createCategory(Category category);

    /**
     * 根据用户名查询对象
     *
     * @return
     */
    List<Category> getCategoryList(CommonPageable page);

    /**
     * 更新
     *
     * @param category
     */
    long updateCategory(Category category);

    /**
     * 删除对象
     *
     * @param id
     */
    void deleteCategoryById(Long id);
}
