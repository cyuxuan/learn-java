package club.beenest.blog.entity.catagory;

import club.beenest.blog.entity.blog.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客分类
 *
 * @author 陈玉轩
 * @since 1.0
 */

public class Category {
    private Long id;

	/**
	 * 分类名称
	 */
    private String name;

	/**
	 * 该分类下的博客文章
	 */
    private List<Blog> blogs = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", name='" + name + '\'' +
				", blogs=" + blogs +
				'}';
	}
}
