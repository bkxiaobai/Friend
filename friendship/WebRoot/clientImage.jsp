<%@ page contentType="image/jpeg;charset=gbk" import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*,angus.tools.code.*" %>

<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);

int width=72, height=20;
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

Graphics g = image.getGraphics();

Random random = new Random();

g.setColor(new Color(210,220,220));
g.fillRect(0, 0, width, height);
g.setFont(new Font("Arial Black",Font.PLAIN,17));

g.setColor(new Color(170,190,170));
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
String checkCode = "";
for (int i = 0 ; i < arr.length ; i++)
{
	checkCode += arr[i];
}
g.setColor(new Color(190,70,50));
g.drawString(code,-4,15);
session.setAttribute("checkCode",checkCode);
g.dispose();
//要是不写下面两句会报一个异常response.getOutputStream()与response.getWriter()不能同时调用
out.clear();
out = pageContext.pushBody();
ImageIO.write(image, "JPEG", response.getOutputStream());
out.close();
%>