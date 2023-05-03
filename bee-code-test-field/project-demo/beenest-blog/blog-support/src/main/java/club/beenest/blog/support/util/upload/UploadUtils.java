package club.beenest.blog.support.util.upload;


import club.beenest.blog.support.exception.BadRequestException;
import club.beenest.blog.support.util.upload.channel.ChannelFactory;
import club.beenest.blog.support.util.upload.channel.FileUploadChannel;
import club.beenest.blog.support.util.upload.constant.UploadConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 图片下载保存工具类
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Component
@DependsOn("springContextUtils")
public class UploadUtils {
	private static RestTemplate restTemplate;

	private static FileUploadChannel uploadChannel;

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		UploadUtils.restTemplate = restTemplate;
	}

	@Value("${upload.channel}")
	public void setNotifyChannel(String channelName) {
		UploadUtils.uploadChannel = ChannelFactory.getChannel(channelName);
	}

	public static class ImageResource {
		byte[] data;
		//图片拓展名 jpg png
		String type;

		public ImageResource() {
		}

		public ImageResource(byte[] data, String type) {
			this.data = data;
			this.type = type;
		}

		public byte[] getData() {
			return data;
		}

		public void setData(byte[] data) {
			this.data = data;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	/**
	 * 通过指定方式存储图片
	 *
	 * @param image 需要保存的图片
	 * @throws Exception
	 */
	public static String upload(ImageResource image) throws Exception {
		return uploadChannel.upload(image);
	}

	/**
	 * 从网络获取图片数据
	 *
	 * @param url 图片URL
	 * @return
	 */
	public static ImageResource getImageByRequest(String url) {
		ResponseEntity<byte[]> responseEntity = restTemplate.getForEntity(url, byte[].class);
		if (UploadConstants.IMAGE.equals(responseEntity.getHeaders().getContentType().getType())) {
			return new ImageResource(responseEntity.getBody(), responseEntity.getHeaders().getContentType().getSubtype());
		}
		throw new BadRequestException("response contentType unlike image");
	}
}
