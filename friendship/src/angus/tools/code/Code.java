package angus.tools.code;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;

/** 本类主要用于随机生成验证码
  * @author Angus Young all right reserve
  */
public class Code
{
	/** 生成单个验证码的方法
	  * @return String
	  */
	public String getSignCode()
	{
		Random random = new Random();
		//设定生成字符的范围,48为数字,65是大写字母 97小写字母
		int numF = 48;
		int wordF = 65;
		int wordf = 97;
		int x = random.nextInt(2);
		switch (x)
		{
			case 0:
			{
				char tmp = (char)(numF + random.nextInt(10));//从0到9中随机生成一个数字
				String code = String.valueOf(tmp);//转换成字符串
				return code;
			}
			case 1:
			{
				char tmp = (char)(wordf + random.nextInt(26));//从26个字母中生成一个字母
				String code = String.valueOf(tmp);//转换成字符串
				return code;
			}
			case 2:
			{
				char tmp=(char)(wordF + random.nextInt(26));
				String code = String.valueOf(tmp);
				return code;
			}
			default: return null;
		}
		
	}

	/** 组合单个字符,返回加空格验证码的字符串
	  * @return String
	  */
	public String getCode(int size)
	{
		new Random();
		String code = "";
		//组合单个字符
		for (int i = 0 ; i < size ; i++ )
		{
			String tmp = getSignCode();
			code += " " + tmp;//加入空格,让生成的图片更加好看			
		}
		//返回生成的验证码
		return code;
	}
	public static void main(String args[])
	{
	

		int width=72, height=20;
		BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();

		Random random = new Random();
		//背景颜色  
		g.setColor(new Color(210,220,220));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Arial Black",Font.PLAIN,17));
		//线条颜色
		g.setColor(new Color(170,190,170));
		//背景画的小线条
		for (int i=0;i<200;i++)
		{
		        int x = random.nextInt(width);
		        int y = random.nextInt(height);
		        int xl = random.nextInt(10);
		        int yl = random.nextInt(10);
		        g.drawLine(x,y,x+xl,y+yl);
		}
		Code c = new Code();
		String code = c.getCode(4);
		String[] arr = code.split("\\s");
		for (int i = 0 ; i < arr.length ; i++)
		{
		}
//
		 g.setColor(new Color(190,70,50));
		
//		 System.out.println(checkCode);
		 g.drawString(code,-4,15);


		 g.dispose();
		 ImageOutputStream out;
		 try 
		 {
			 out=ImageIO.createImageOutputStream(new File("D:/a.jpg"));
			 ImageIO.write(image, "JPEG",out);
		 } 
		 catch (IOException e1)
		 {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 } 	
		 //int a=Integer.parseInt("A");
		 int a = 'a';
		 System.out.println(a);
		
	}
}
