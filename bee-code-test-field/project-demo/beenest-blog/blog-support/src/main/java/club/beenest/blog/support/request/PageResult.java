package club.beenest.blog.support.request;

import java.util.List;

/**
 * 分页结果
 *
 * @param <T>
 */

public class PageResult<T> {
    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 数据
     */
    private List<T> list;

    public PageResult(Integer totalPage, List<T> list) {
        this.totalPage = totalPage;
        this.list = list;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
