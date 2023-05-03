package club.beenest.blog.support.util.upload.channel;

import club.beenest.blog.support.util.upload.UploadUtils;

/**
 * 文件上传方式
 *
 * @author 陈玉轩
 * @since　1.0
 */
public interface FileUploadChannel {
	/**
	 * 通过指定方式上传文件
	 *
	 * @param image 需要保存的图片
	 * @return 访问图片的URL
	 * @throws Exception
	 */
	String upload(UploadUtils.ImageResource image) throws Exception;
}
