/*
 * Copyright ©2023-2023 BeeNest Club. All rights reserved.
 */

package club.beenest.blog.support.basic.service;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class BasService<T> {
    public <R> PageInfo<T> selectForPage(int currentPage, int pageSize, ISelect iSelect) {
        // 执行分页查询
        Page<T> page = PageHelper.startPage(currentPage, pageSize).doSelectPage(iSelect);
        // 封装分页信息
        PageInfo<T> pageInfo = new PageInfo<>(page);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(currentPage);
        pageInfo.setTotal(page.getTotal());
        // 返回分页信息
        return pageInfo;
    }
}
