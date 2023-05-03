package club.beenest.blog.support.util.upload.channel;

import club.beenest.blog.support.util.SpringContextUtils;
import club.beenest.blog.support.util.upload.constant.UploadConstants;

/**
 * 文件上传方式
 *
 * @author 陈玉轩
 * @since　1.0
 */
public class ChannelFactory {
	/**
	 * 创建文件上传方式
	 *
	 * @param channelName 方式名称
	 * @return 文件上传Channel
	 */
	public static FileUploadChannel getChannel(String channelName) {
		switch (channelName.toLowerCase()) {
			case UploadConstants.LOCAL:
				return SpringContextUtils.getBean(LocalChannel.class);
			case UploadConstants.GITHUB:
				return SpringContextUtils.getBean(GithubChannel.class);
			case UploadConstants.UPYUN:
				return SpringContextUtils.getBean(UpyunChannel.class);
		}
		throw new RuntimeException("Unsupported value in [application.properties]: [upload.channel]");
	}
}
