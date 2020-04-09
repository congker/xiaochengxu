/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.entity.common;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class CommonPageable implements Pageable {
    PageModel page;

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public long getOffset() {
        return (page.getPagenumber() - 1) * page.getPagesize();
    }

    @Override
    public int getPageNumber() {
        return page.getPagenumber();
    }

    @Override
    public int getPageSize() {
        return page.getPagesize();
    }


    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Sort getSort() {
        return page.getSort();
    }

}
