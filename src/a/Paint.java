package a;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;




public class Paint   implements Serializable {//m500+  旗幟   
	
	BufferedImage  a,img,bi,bi2,flag[],flagz ;
	Graphics g;
	ImageIcon d ;
	String ea;
	//private static final long serialVersionUID = 2;
	int color=0;
	
	 BufferedImage pic[],m_tr[],house,light,extinction;
	 BufferedImage m_tr2[][];
	 
	 
	Paint(){
		
		ea="fild/";
	//	a=new BufferedImage (100, 50,BufferedImage.TYPE_INT_ARGB);
		//d=new  ImageIcon(a);
		//g=new ;
	//	g = a.getGraphics(); 
		flag=new BufferedImage[1010];
		//ea=a14.a140.ea;
		
		pic=new  BufferedImage[1001];
		m_tr=new  BufferedImage[21];
		m_tr2=new BufferedImage[21][21];
		
		try {					
			pic[1] = ImageIO.read(new File(ea+"m18.png"));	
		} catch (IOException e2) {					
			e2.printStackTrace();
		}
		
		try {					
			pic[2] = ImageIO.read(new File(ea+"m18_r.png"));	
		} catch (IOException e2) {					
			e2.printStackTrace();
		}
		
		try {					
			pic[3] = ImageIO.read(new File(ea+"m18_r2.png"));	
		} catch (IOException e2) {					
			e2.printStackTrace();
		}
		
		try {					
			pic[4] = ImageIO.read(new File(ea+"m18_m.png"));	
		} catch (IOException e2) {					
			e2.printStackTrace();
		}
		
		for(int i=0;i<4;i++) {
			try {					
				m_tr[i] = ImageIO.read(new File(ea+"m_tr"+i+".png"));	
			} catch (IOException e2) {					
				e2.printStackTrace();
			}
			
			for(int j=0;j<7;j++)
			{
				try {					
					m_tr2[i][j] = ImageIO.read(new File(ea+"m_tr"+i+"_"+j+".png"));	
				} catch (IOException e2) {					
					e2.printStackTrace();
				}
			}
		}
		

		try {					
			house = ImageIO.read(new File(ea+"house.png"));	
		} catch (IOException e2) {					
			e2.printStackTrace();
		}
		
		try {					
			light = ImageIO.read(new File(ea+"light.png"));	
		} catch (IOException e2) {					
			e2.printStackTrace();
		}
		
		try {					
			extinction = ImageIO.read(new File(ea+"extinction.png"));	
		} catch (IOException e2) {					
			e2.printStackTrace();
		}
		
	
		
	}
	
    void createmap(int k ,int x,int y) {
		
		BufferedImage a=new BufferedImage (100, 50,BufferedImage.TYPE_INT_ARGB);
		
		g = a.getGraphics(); 
		
		Color cc[]=new Color[] {
				new  Color(205, 245, 245),//天藍
				new Color(1, 33, 105),//藍
				new  Color(13, 101, 3),//深綠
				new  Color(25, 145, 12),//印度綠
				new  Color(255, 204, 0),//德國金
				new Color(246, 161, 34),//橘
				new Color(207, 20, 43),//聯合旗紅
				new Color(249, 73, 73),//奧地利紅		
				new Color(255, 255, 255),//白	
				new Color(0, 0, 0),//白	
				new  Color(60, 170, 220),//天藍
		};
		int cn=10;
		
		g.clearRect(0, 0, 100, 50);
		
		g.setColor(cc[k]); 
		//畫矩形 
		g.fillRect( 0, 0, 100, 50); 
		System.out.print("image:"+k+" x="+x+" "+y);
	//	map[x][y]=a;
	}
    
	void createone(int k)
	{
		BufferedImage a=new BufferedImage (100, 50,BufferedImage.TYPE_INT_ARGB);
		
		g = a.getGraphics(); 
		
		Color cc[]=new Color[] {
				new  Color(135, 206, 235),//天藍
				new Color(1, 33, 105),//藍
				new  Color(13, 101, 3),//深綠
				new  Color(25, 145, 12),//印度綠
				new  Color(255, 204, 0),//德國金
				new Color(246, 161, 34),//橘
				new Color(207, 20, 43),//聯合旗紅
				new Color(249, 73, 73),//奧地利紅		
				new Color(255, 255, 255),//白	
				new Color(0, 0, 0),//白	
				new  Color(60, 170, 220),//天藍
		};
		
		
		int cn=10;
		
		g.clearRect(0, 0, 100, 50);
		
		g.setColor(cc[k]); 
		//畫矩形 
		g.fillRect( 0, 0, 100, 50); 
		img=a;
	
		
		 
	}
	void createrealmap() {
	
    BufferedImage a=new BufferedImage (100, 50,BufferedImage.TYPE_INT_ARGB);
    Color cc[]=new Color[] {
			new  Color(135, 206, 235),//天藍
			new Color(1, 33, 105),//藍1
			new  Color(13, 101, 3),//深綠2
			new  Color(19, 136, 8),//印度綠3
			new  Color(255, 204, 0),//德國金4
			new Color(246, 161, 34),//橘5
			new Color(207, 20, 43),//聯合旗紅6
			new Color(249, 73, 73),//奧地利紅7		
			new Color(255, 255, 255),//白	8
			new Color(0, 0, 0),//9
			new  Color(135, 206, 235),//天10
	};
    
    int color=1;int k=1;
    
    
    color=2;k=82;
  //  a14.a1.c[a14.a1.cn]=new Country(k,"尚比亞",color);a14.a1.cn++;
   // a14.a1.c[k].set(5,1,0) ;
    for(int i=38;i<41;i++) {
    	for(int j=34;j<40;j++){
    		createmap(color,i,j);
    		//a14.a1.mapcountry[i][j]=k;
    	} }
    
   
    
   // a14.a1.start();
		
		//g.setColor(cc[0]);
	//	g.fillRect( 0, 0, 100, 50); 
		
		
		
	}
	int c1,c2,cg;
	
	
	void createnew(int k ,int x,int y) {
		
		BufferedImage a=new BufferedImage (100, 50,BufferedImage.TYPE_INT_ARGB);
		
		g = a.getGraphics(); 
		
		Color cc[]=new Color[] {Color.WHITE,
				Color.BLACK,
				new Color(1, 33, 105),//藍
				new  Color(135, 206, 235),//天藍
				new  Color(13, 101, 3),//深綠
				new  Color(19, 136, 8),//印度綠
				new  Color(255, 204, 0),//德國金
				new Color(246, 161, 34),//橘
				new Color(207, 20, 43),//聯合旗紅
				new Color(249, 73, 73),//奧地利紅
				
				
		};
		int cn=10;
		
		g.clearRect(0, 0, 100, 50);
		
		c1=(int)(Math.random()*12121)%cn;
		
		g.setColor(cc[c1]); 
		//畫矩形 
		g.fillRect( 0, 0, 100, 50); 
		
		c2=(int)(Math.random()*12171)%cn;
		
		while(c2==c1||c2-c1==1||c1-c2==1)
			c2=(int)(Math.random()*12171)%cn;
		
		int g0=(int)(Math.random()*179211)%4;
		g.setColor(cc[c2]); 
		
	   
		if(g0==0)
		{
			g.fillRect( 0, 20,100,10); 
			g.fillRect( 45, 0,10 ,50); 
		}
		else if(g0==1)
		{
			g.fillRect( 0, 20,100,10); 
			g.fillRect( 35, 0,10 ,50); 
		}
		else if(g0==2)
		{
			g.fillRect( 0,0,100 ,15); 	
			g.fillRect( 0,35,100 ,15); 	
		}
		else
		{
			g.fillRect( 0,25,100 ,25); 			
		}
	
		cg=g0;

		
		flag[k]=a;
	}
	
	
	

	

}
