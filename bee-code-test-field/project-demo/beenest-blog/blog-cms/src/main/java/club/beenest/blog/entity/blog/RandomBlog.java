package club.beenest.blog.entity.blog;

import java.util.Date;


/**
 * 随机获取blog
 *
 * @author 陈玉轩
 * @since 1.0
 */
public class RandomBlog {

    /**
     *
     **/
    private Long id;

    /**
     *文章标题
     **/
    private String title;

    /**
     *文章首图，用于随机文章展示
     **/
    private String firstPicture;

    /**
     *创建时间
     **/
    private Date createTime;

    /**
     *文章密码
     **/
    private String password;

    /**
     *是否私密文章
     **/
    private Boolean privacy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Boolean privacy) {
        this.privacy = privacy;
    }

    @Override
    public String toString() {
        return "RandomBlog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", createTime=" + createTime +
                ", password='" + password + '\'' +
                ", privacy=" + privacy +
                '}';
    }
}
