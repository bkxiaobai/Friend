package angus.tools.file;

import org.apache.struts.upload.FormFile;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics;
import java.io.File;
import angus.tools.date.DateUtil;


/** 该类主要用于处理上传文件功能
  * @author Angus Young all right reserve
  */
public class Upload
{
	private String url;

	private String fileName;
	
	/** 上传文件方法
	  * @param FormFile file, 选定文件的实体
	  * @param request HttpServletRequest
	  * @param userName 用户的名称,String型
	  * @param webPath 服务器的绝对路径
	  * @param suffix 传入文件的后缀
	  */
	public void upload(FormFile file, String path, String suffix)
		throws Exception
	{
		
		//获取文件的大小
		byte[] content = file.getFileData();
		//以时间格式生成文件名
		String url = makeUrl(path, suffix);
		this.url = url;		
		//用输出流保存文件
		FileOutputStream fos = new FileOutputStream(url);
		//写入时间
		fos.write(content);
		//关闭输出流
		fos.close();
	}
	private String makeUrl(String path, String suffix)
	{
		File file = new File(path);
		file.mkdirs();
		this.fileName = DateUtil.getStringTime();
		return path + "\\" + this.fileName + suffix;
	}

	public String makeNewUrl(String path, String suffix, String other)
	{
		return path + "\\" + this.fileName + other + suffix;
	}

	/** 返回上传后文件的绝对URL
	  * @return String
	  */
	public String getUrl()
	{
		return this.url;
	}

	public String getFileName()
	{
		return this.fileName;
	}

	/** 用于生成上传完后的图片的副本
	  * @param url 原图的绝对URL
	  * @param newWidth 生成副本的新宽度
	  * @param newHeight 生成副本的新高度
	  * @param newUrl 生成副本的地址
	  * @param formatName 生成图片的格式
	  */
	public void makeImage(String url, int newWidth, int newHeight, String newUrl, String formatName)
		throws Exception
	{
		//读取图片
		BufferedImage bi = ImageIO.read(new File(url));
		//判断读入图片的宽和高
		if (bi.getHeight() > bi.getWidth())
		{
			//如果高比宽大,就交换两值,确保生成的图片的长个宽都在一个范围内
			int tmp = newWidth;
			newWidth = newHeight;
			newHeight = tmp;
		}
		//用Image里的方法对图片进行等比压缩,只要宽和高其一值为负,则以正的那个值为最大边进行等比压缩
		Image image2 = bi.getScaledInstance(newWidth, newHeight, Image.SCALE_AREA_AVERAGING);
		//获取压缩后图片的高和宽
		int height = image2.getHeight(null);
		int width = image2.getWidth(null);			
		//FileOutputStream fos = new FileOutputStream(new File(newUrl));
		//以新的高和宽构造一个新的缓存图片
		BufferedImage bi3 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi3.getGraphics();
		//在新的缓存图片中画图
		g.drawImage(image2, 0, 0, null);
		//构造IO流输出到文件
		FileOutputStream fos = new FileOutputStream(new File(newUrl));
		ImageIO.write(bi3, formatName, fos);
		fos.close();
	}

	/** 该方法是删除图片
	  * @param url 删除图片的绝对地址
	  * @param bigUrl 数据库中大图片的URL
	  * @param smallUrl 数据库小图片的URL
	  * @param realPath 服务器中的绝对路径
	  */
	public void deleteImage(String url, String bigUrl, String smallUrl, String realPath)
	{
		//构造三个文件对象,调用方法把所有对应的图片删除
		File fUrl = new File(realPath + "/" + url);
		File fBigUrl = new File(realPath + "/" + bigUrl);
		File fSmallUrl = new File(realPath + "/" + smallUrl);
		fUrl.delete();
		fBigUrl.delete();
		fSmallUrl.delete();
	}
}
