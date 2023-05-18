package club.beenest.blog.entity.visit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 城市访客数量
 *
 * @author 陈玉轩
 * @since 1.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityVisitor {
	/**
	 * 城市名称
	 */
    private String city;
	/**
	 * 独立访客数量
	 */
    private Integer uv;
}
