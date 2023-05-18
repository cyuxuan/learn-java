package club.beenest.blog.entity.visit;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 访问记录
 *
 * @author 陈玉轩
 * @since 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VisitRecord {
    private Long id;

	/**
	 * 访问量
	 */
    private Integer pv;

	/**
	 *独立用户
	 */
    private Integer uv;

	/**
	 *日期
	 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;

    public VisitRecord(Integer pv, Integer uv, Date date) {
        this.pv = pv;
        this.uv = uv;
        this.date = date;
    }
}
