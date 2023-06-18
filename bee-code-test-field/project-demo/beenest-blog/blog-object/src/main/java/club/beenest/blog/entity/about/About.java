package club.beenest.blog.entity.about;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 关于我
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class About {
    /**
     * 物理主键
     */
    private Long id;

    private String nameEn;

    private String nameZh;

    private String value;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容信息
     */
    private String content;

    /**
     * 是否开启评论
     */
    private boolean commentEnable;
}
