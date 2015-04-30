package angus.tools.code;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;

/** ������Ҫ�������������֤��
  * @author Angus Young all right reserve
  */
public class Code
{
	/** ���ɵ�����֤��ķ���
	  * @return String
	  */
	public String getSignCode()
	{
		Random random = new Random();
		//�趨�����ַ��ķ�Χ,48Ϊ����,65�Ǵ�д��ĸ 97Сд��ĸ
		int numF = 48;
		int wordF = 65;
		int wordf = 97;
		int x = random.nextInt(2);
		switch (x)
		{
			case 0:
			{
				char tmp = (char)(numF + random.nextInt(10));//��0��9���������һ������
				String code = String.valueOf(tmp);//ת�����ַ���
				return code;
			}
			case 1:
			{
				char tmp = (char)(wordf + random.nextInt(26));//��26����ĸ������һ����ĸ
				String code = String.valueOf(tmp);//ת�����ַ���
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

	/** ��ϵ����ַ�,���ؼӿո���֤����ַ���
	  * @return String
	  */
	public String getCode(int size)
	{
		new Random();
		String code = "";
		//��ϵ����ַ�
		for (int i = 0 ; i < size ; i++ )
		{
			String tmp = getSignCode();
			code += " " + tmp;//����ո�,�����ɵ�ͼƬ���Ӻÿ�			
		}
		//�������ɵ���֤��
		return code;
	}
	public static void main(String args[])
	{
	

		int width=72, height=20;
		BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();

		Random random = new Random();
		//������ɫ  
		g.setColor(new Color(210,220,220));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Arial Black",Font.PLAIN,17));
		//������ɫ
		g.setColor(new Color(170,190,170));
		//��������С����
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
