package a;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Toolkit;  
import java.awt.datatransfer.Clipboard;  
import java.awt.datatransfer.ClipboardOwner;  
import java.awt.datatransfer.StringSelection;  
import java.awt.datatransfer.Transferable;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.event.KeyAdapter;  
import java.awt.event.KeyEvent;  
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class a15 extends JFrame   implements Serializable {
	
	
	//private static final long serialVersionUID = 178;
	public static int a[][],an;
	static String as[]= new String [40];
    String ea;
	public static int g0;
	public static String y0[]= new String [20];
	protected JPanel p;
	
	static JButton bu[]=new JButton[20];
	static int bb[][]=new int [22][5];
	static String bbs[]= new String [22];
	
	 static JTextArea ba[]=new JTextArea[24];
		static int bba[][]=new int [24][5];
		static String bbas[]= new String [50];
		 static JScrollPane bag[] = new JScrollPane[25];
	
	static JLabel bl[]=new JLabel[51];
	static int bbl[][]=new int [51][6];
	static String bbls[]= new String [51];
	
	static  JTextField bt[]= new JTextField [20];
	static int bbt[][]=new int [30][6];
	static String bbts[]= new String [30];
	
	
	static public int dx=0,dy=0;
	 
	JLabel dd;
	Image img,bi,bi2,tmp;
	 JLabel lb ;
	Graphics g,gt;
	 ImageIcon d ;
 
	//static key kk;
	 a15()
	 {
	 
		 Scanner scanner = new Scanner(System.in);
		 System.out.print((int)(Math.random()*100000002)%1111149);
		 System.out.print("Please input your name: ");
	    
	 
		 g0=0;//C:/Users/User/eclipse-workspace/a9/
		 	ea="fild/";
		 	//aa=this;
		 	p = new JPanel();
		 	setContentPane(p);
	 	
		 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	setBounds(0,0,1220,650);
		 	setTitle("tt");
		 	setVisible(true);
	  
		 	// setLayout(new GridLayout(1));
		 	setLayout(null);
	  
	
	  
		 	a=new int [40][5];
		 	an=0;
	 
		 	img = createImage(1220, 650);
		 	tmp = createImage(1220, 650);
		 	g = img.getGraphics(); //
		 	gt = tmp.getGraphics();
		 	d = new ImageIcon(img);
	
		 
		  
		 
		 for(int z=0;z<51;z++)
		 {
			 bl[z]= new JLabel();
		 }

		 for(int z=0;z<=22;z++)
		 {
			 ba[z]= new JTextArea(300,400);
			 bag[z]=new JScrollPane( );  
			 ba[z].setLineWrap(true); //�E���۰ʴ���\��

		
			  ba[z].setOpaque(false);  	

		
			  
		 }
		 
		 for(int z=0;z<20;z++)
		 {
			 bu[z]= new JButton();
		 }
		 for(int z=0;z<20;z++)
		 {
			 bt[z]= new  JTextField (10);
		 }
			
		 
		  bu[0].addActionListener(new ActionListener() {// 
				public void actionPerformed(ActionEvent e) {
					g0=0;
				}
			});	  
		  bu[1].addActionListener(new ActionListener() {// 
				public void actionPerformed(ActionEvent e) {
					g0=1;
				}
			});	 
		  bu[2].addActionListener(new ActionListener() {// 
				public void actionPerformed(ActionEvent e) {
					g0=2;
				}
			});	 
		  bu[3].addActionListener(new ActionListener() {// 
				public void actionPerformed(ActionEvent e) {
					g0=3;
				}
			});
		  bu[4].addActionListener(new ActionListener() {// 
				public void actionPerformed(ActionEvent e) {
					g0=4;
				}
			});	  
		  bu[5].addActionListener(new ActionListener() {// 
				public void actionPerformed(ActionEvent e) {
					g0=5;
				}
			});	  
		  bu[6].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=6;
				}
			});	 
		  bu[7].addActionListener(new ActionListener() {// 
				public void actionPerformed(ActionEvent e) {
					g0=7;
				}
			});	 
		  bu[8].addActionListener(new ActionListener() {// 
				public void actionPerformed(ActionEvent e) {
					g0=8;
				}
			});
		  bu[9].addActionListener(new ActionListener() {// 
				public void actionPerformed(ActionEvent e) {
					g0=9;
				}
			});	  
		  bu[10].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=10;
				}
			});	 
		  bu[11].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=11;
				}
			});	 
		  bu[12].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=12;
				}
			});	 
		  bu[13].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=13;
				}
			});	 
		  bu[14].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=14;
				}
			});	 
		  bu[15].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=15;
				}
			});	 
		  bu[16].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=16;
				}
			});	 
		  bu[17].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=17;
				}
			});	 
		  bu[18].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=18;
				}
			});	 
		  bu[19].addActionListener(new ActionListener() {// bt1�ƥ󪺰ʧ@
				public void actionPerformed(ActionEvent e) {
					g0=19;
				}
			});	 

		  
		  bt[1].addActionListener( new ActionListener(){
		    	 public  void  actionPerformed (ActionEvent ev) {
		    	  y0[1]=bt[1].getText();	
		    	}
		    });
		  bt[2].addActionListener( new ActionListener(){
		    	 public  void  actionPerformed (ActionEvent ev) {
		    	  y0[2]=bt[2].getText();	 	}
		    });
		  bt[3].addActionListener( new ActionListener(){
		    	 public  void  actionPerformed (ActionEvent ev) {
		    	  y0[3]=bt[3].getText();	
		    	}
		    });
		  bt[4].addActionListener( new ActionListener(){
		    	 public  void  actionPerformed (ActionEvent ev) {
		    	  y0[4]=bt[4].getText();	
		    	}
		    });
		  bt[5].addActionListener( new ActionListener(){
		    	 public  void  actionPerformed (ActionEvent ev) {
		    	  y0[5]=bt[5].getText();	
		    	}
		    });
		  
		  	  
		
		  
		  for(int x=1;x<20;x++)
		  {
			  p.add(bu[x]);
			  bu[x].setFont(new java.awt.Font(null, 1, 15)); 
		  }
 
		
		
		  for(int x=11;x<=20;x++)
		  {
			  p.add(bl[x]);
			//  p.add(bl[x]);  bl[x].setForeground(Color.white); 
			   bl[x].setFont(new java.awt.Font(null, 1, 14)); 
		  }
		  for(int x=0;x<=10;x++)
		  {
			  p.add(bl[x]); // bl[x].setForeground(Color.white); 
			  bl[x].setFont(new java.awt.Font(null, 1, 14));    	
		  }
		  for(int x=21;x<=30;x++)
		  {
			  p.add(bl[x]);
			  bl[x].setFont(new java.awt.Font(null, 1, 14)); 
			// bl[x].setForeground(Color.white); 
		  }
		  
		  for(int x=31;x<=42;x++)
		  {
			  p.add(bl[x]);
			  bl[x].setForeground(Color.white); 
			  bl[x].setFont(new java.awt.Font(null, 1, 13));    	
		  }
		  
		  for(int x=43;x<50;x++)
		  {
			  p.add(bl[x]);  bl[x].setForeground(Color.white); 
			  bl[x].setFont(new java.awt.Font(null, 1, 23)); 	
		  }
		  for(int x=49;x<50;x++)
		  {
			  p.add(bl[x]);  bl[x].setForeground(Color.black); 
			  bl[x].setFont(new java.awt.Font(null, 1, 27)); 	
		  }
  
  
		  for(int x=1;x<20;x++)
		  {
			  p.add(bt[x]);	
			  bt[x].setEditable(true);
			  bt[x].setSize(100, 40);
			  bt[x].setFont(new java.awt.Font(null, 1, 18)); 
		  }
		
		  for(int x=1;x<=8;x++)
		  {
			  p.add(ba[x]);
			 p.add(bag[x]);//, BorderLayout.CENTER  
			  ba[x].setFont(new java.awt.Font(null, 1, 15)); 
		  }
		
		  for(int x=9;x<=10;x++)
		  {
			  p.add(ba[x]);
			 p.add(bag[x]);//, BorderLayout.CENTER  
			  ba[x].setFont(new java.awt.Font(null, 1, 24)); 
		  }
		  for(int x=11;x<=20;x++)
		  {
			  p.add(ba[x]);
			 p.add(bag[x]);//, BorderLayout.CENTER  
			  ba[x].setFont(new java.awt.Font(null, 1, 15)); 
			  ba[x].setForeground(Color.white);   
		  }
		  String cl[]= {"","西歐","東歐","拉丁美洲","伊斯蘭文化(中東與北非)","南非洲","中亞","南亞","東南亞","東亞","大洋洲土著"};
		  String la[]= {"","英語","法語","西班牙語","德語","葡萄牙語","阿拉伯語","俄語","漢語","波斯語",""};
	  		
		  addMouseListener(new MouseAdapter(){
		         public void mouseReleased(MouseEvent e){  //實做滑鼠的放開事件


		        	 int x,y,g=0;
		        	 //g.drawImage(a15.paint.ex[x],810+x*16,50,15,15,null);	// dd.setBounds(0,0,1050+i/2,600);
		     		
		        	x=e.getX();
		        	y=e.getY();
		        	a15.a1.hx=x;
		        	a15.a1.hy=y;
		        	if(state==1)
		        	{
		        		//g.drawImage(bi2,10+x*20,10+z*20,18,18,null);
		        		a1.mapx=(x-10)/20;
		        		a1.mapy=(y-10)/20-1;
		        	}
		        	
		        	if(state==2)
		        	{
		        		//g.drawImage(bi2,10+x*20,10+z*20,18,18,null);
		        		a1.mx=(x-10)/40;
		        		a1.my=(y-10)/40-1;
		        	}
		        		

		          //  a15.cleanbl(1);
		        //	a15.setbl(1,850,100, 1200, 50, 1, "位置: "+x+" "+y+" mapx="+a1.mapx+" mapy="+a1.mapy);
		        		  
		        		    
		           
		         }
		   });
		 
		  dd=new JLabel(d);
		
		
		
	//ns1= new ns();
	
		 
		  
Thread t= new Thread(//**************�h������	 
		 new Runnable(){
			 public void run(){	 
				 try {
					 int j=1;
					 System.out.print("tt");
					
				     for (int i = 0; i < 700;i++) {
				    	
				    	 paint(g);
				    	// j++;
				    	 
				    	 //dd.setText(d);
				    	
				    	 //img = createImage(1150, 620);
				 		 //g = img.getGraphics(); //
				 		// d = new ImageIcon(img);
				 		 
				    	// dd.setIcon(d);
				    	 
				    	 
				    	// dd=new JLabel(d);
				    	 p.add(dd);
				    	 dd.setBounds(0,0,1220,650);
				    	 dd.setVisible(true);
				    	 p.updateUI();
				    	// dd.setBounds(0,0,1150,600);
				    	// dd.revalidate();
				    	
			    		
				    	 if(i>13)
				    		 i-=2; 
				    	
				    	 for(int z=0;z<20;z++)
				    	 {				    		 
				    		 if(bb[z][0]==1)
				    		 {
				    			 bu[z].setText(bbs[z]);
				    			 bu[z].setBounds(bb[z][1],bb[z][2],bb[z][3],bb[z][4]); 
				    		}
				    	 }
				    	 for(int z=1;z<50;z++)
				    	 {
				    		 if(bbl[z][0]==1)
				    		 {
				    			 bl[z].setText(bbls[z]); 
				    			 bl[z].setBounds((bbl[z][1]),(bbl[z][2]),(bbl[z][3]),(bbl[z][4]));
				    		 }	
				    	 }	
				    	 for(int z=1;z<20;z++)
				    	 {
				    		 if(bbt[z][0]==1)
				    		 {
				    			 bt[z].setBounds(bbt[z][1],bbt[z][2],bbt[z][3],bbt[z][4]);
				    		 }	
				    	 }
				    	 for(int z=1;z<=20;z++)
				    	 {
				    		 if(bba[z][0]==1)
				    		 {
				    			ba[z].setText(bbas[z]);
				    			 //ba[z].setSize(bba[z][4], bba[z][3]);
				    			bag[z].setBounds(bba[z][1],bba[z][2],bba[z][3],bba[z][4]);
				    			bag[z].setOpaque(false);  	
				  				bag[z].getViewport().setOpaque(false);  
				    			ba[z].setBounds(bba[z][1],bba[z][2],bba[z][3],bba[z][4]);
				    		 }			    			 
				    	 }	
				    	 
				    
				    	 Thread.sleep(250);
				     }	 
			 
			 } catch (Exception e) {
			     e.printStackTrace();
			 } 	 } } );    

		 

a15.clean();
//f=new file();
a15.setbl(1,900,100, 200, 50, 1, "位置: ");
t.start();
//t2.start();
System.out.print("start");



 }
 
 

static int keystate=0,keydelay=0,nstart=0,state=1;

public void paint(Graphics g1){
	
	
	if(state==1)
		pa1(g);
	else if(state==2)
	pa2(g);
	
	//pa2(g);
	
	
	//g1.clearRect(0, 0,1600, 850);
	//g1.clearRect(800, 0,1500, 800);
	//g1.clearRect(0, 0,1600, 800);	
	//g1.drawImage(d, 0, 0, null);
}

int pp[][]=new int[111][111];
public void pa10(Graphics g)
{
	g.clearRect(0, 0,1220, 600);

	for(int z=0;z<30;z++)
	{
		if(a[z][0]==0)
			continue;
		try {
		
			bi = ImageIO.read(new File(ea+as[z]+".png"));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		g.drawImage(bi, a[z][1],a[z][2],a[z][3],a[z][4],null);	
		//System.out.print("pa2  a["+z+"][1]="+a[z][1]+" \n");  

	}

	
}
int p2[][]=new int[104][104];

int k,k2;


int close=0;
void cleansceen()
{
	g.clearRect(0, 0,1220, 600);
	for(int x=0;x<12;x++)
	{
		for(int z=0;z<10;z++)
		{
			pp[x][z]=-5;
		}
	}
	
}
void start()
{
	
		try {
			//	System.out.print("pa"+a15.a1.map[a15.a1.mapx+x][a15.a1.mapy+z]);
		
			bi = ImageIO.read(new File(ea+"talk.png"));		
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		g.drawImage(bi,0,0,1200,580,null);	// dd.setBounds(0,0,1050+i/2,600);
		
	
}

public void pa1(Graphics g)// 大地圖
{
	int k=0,k2,gg,g2;
	
	//System.out.print("pa0 \n");  
	
	gt.clearRect(0, 0,1220, 650);
	
	for(int x=0;x<40;x++)
	{
		for(int z=0;z<30;z++)
		{		
			if(a1.bigmap[x][z]>=10) {
				gg=a1.tr[a1.bigmap[x][z]-10].language_gf;
				g2=a1.lg[a1.tr[a1.bigmap[x][z]-10].language_f].id;
				
				bi2 = paint.m_tr[gg%4];	
				
				if(a1.tr[a1.bigmap[x][z]-10].language_gf!=a1.tr[a1.bigmap[x][z]-10].language_f)
					bi2 = paint.m_tr2[gg%4][g2%7];	
					
				gt.drawImage(bi2,10+x*20,10+z*20,19,19,null);
				if(a1.tr[a1.bigmap[x][z]-10].live<0)
				{
					bi2 = paint.extinction;
					gt.drawImage(bi2,10+x*20,10+z*20,19,19,null);
				}
			}
			else { 
				
				if(a1.bigmap[x][z]==2)
					bi2 = paint.pic[4];	
				else if(a1.landmap[x][z]==1)
					bi2 = paint.pic[1];	
				else if(a1.landmap[x][z]==2)
					bi2 = paint.pic[2];	
				else if(a1.landmap[x][z]==3)
					bi2 = paint.pic[3];	
	
				gt.drawImage(bi2,10+x*20,10+z*20,19,19,null);	// dd.setBounds(0,0,1050+i/2,600);	
			}
			
			
		}
			
	}
	try {
		
		bi = ImageIO.read(new File(ea+"talk.png"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	gt.drawImage(bi, 750,0,600,700,null);	
	
	
	g.clearRect(0, 0,1220, 650);
	g.drawImage(tmp, 0,0,1220,650,null);	
	
	//System.out.print("print pp"+dx+" "+dy+"\n");  

}

public void pa2(Graphics g)//中地圖
{
	int k=0,k2;
		
	//System.out.print("pa0 \n");  
	//g.clearRect(0, 0,1220, 650);
	gt.clearRect(0, 0,1220, 650);
	for(int x=0;x<15;x++)
	{
		for(int z=0;z<15;z++)
		{		
			
			bi2 = paint.pic[1];	
	
			
			gt.drawImage(bi2,10+x*40,10+z*40,38,38,null);	// dd.setBounds(0,0,1050+i/2,600);	
			
			if(a15.a1.c_tri>=0)
			{
				if(a15.a1.tr[a15.a1.c_tri].house_n[x*15+z]>0) {
					
					bi2 = paint.house;
					gt.drawImage(bi2,10+x*40,10+z*40,38,38,null);	// dd.setBounds(0,0,1050+i/2,600);
			
					if(a15.a1.tr[a15.a1.c_tri].house[x*15+z][0]==a15.a1.tr[a15.a1.c_tri].leader)
					{
						bi2 = paint.light;
						gt.drawImage(bi2,10+x*40,10+z*40,38,38,null);	// dd.setBounds(0,0,1050+i/2,600);
				
						
					}
						
				
				}
			}
							
		}
			
	}
	try {
		
		bi = ImageIO.read(new File(ea+"talk.png"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	gt.drawImage(bi, 610,0,800,700,null);	
	
	g.clearRect(0, 0,1220, 650);
	g.drawImage(tmp, 0,0,1220,650,null);	
	//System.out.print("print pp"+dx+" "+dy+"\n");  

}




public void pa(Graphics g)
{

	try {
		
		bi2 = ImageIO.read(new File(ea+"talk5.png"));
		
	} catch (IOException e2) {	
	
		e2.printStackTrace();
	}

	g.drawImage(bi2,10,10,800,500,null);	// dd.setBounds(0,0,1050+i/2,600);
	
	int k=0,k2;
	for(int x=0;x<80;x++)
	{
		for(int z=0;z<50;z++)
		{		
			//g.drawImage(a15.paint.map[x][z],10+x*10,10+z*10,9,9,null);	// dd.setBounds(0,0,1050+i/2,600);
		
		}
	}
	
	
	try {
	
		bi2 = ImageIO.read(new File(ea+"m1.png"));
		
	} catch (IOException e2) {	
	
		e2.printStackTrace();
	}

	//System.out.print("print pp"+dx+" "+dy+"\n");  
	pp[dx][dy]=-100;
//	g.drawImage(bi2,20+dx*55,20+dy*55,55,55,null);	// dd.setBounds(0,0,1050+i/2,600);


}


public static  void setb(int k,int x,int y,int x2,int y2,String g)
{
	
	bb[k][0]=1;
	bb[k][1]=x;
	bb[k][2]=y;
	bb[k][3]=x2;
	bb[k][4]=y2;
	
	bbs[k]=g;
	 bu[k].setVisible(true);
}

public static  void setbt(int k,int x,int y,int x2,int y2,String g)
{
	
	bbt[k][0]=1;
	bbt[k][1]=x;
	bbt[k][2]=y;
	bbt[k][3]=x2;
	bbt[k][4]=y2;
	
	bbts[k]=g;
	bt[k].setText(bbts[k]); 
	 bt[k].setVisible(true);
	  bt[k].setEditable(true);
}

public static  void cleanbt(int k)
{
	bt[k].setVisible(false);
	
}
public static  void cleanbl(int k)
{
	bl[k].setVisible(false);

}
public static void cleanb(int k)
{	
	 bu[k].setVisible(false);	
}
public  static void cleanallb()
{
	
	for(int z=0;z<50;z++)
	{
		bl[z].setVisible(false);
	}
	for(int z=0;z<20;z++)
	{
		bb[z][0]=0;
		bu[z].setVisible(false);
	}
	for(int z=0;z<20;z++)
	{
		bbl[z][0]=0;
		bt[z].setVisible(false);
	}
	for(int z=0;z<=20;z++)
	{
		bba[z][0]=0;
		ba[z].setVisible(false);
		bag[z].setVisible(false);
	}
}

public static void setbl(int k,int x,int y,int x2,int y2,int size,String g)
{
	
	bbl[k][0]=1;
	bbl[k][1]=x;
	bbl[k][2]=y;
	bbl[k][3]=x2;
	bbl[k][4]=y2;
	bbl[k][5]=size;
	
	bbls[k]=g;
	bl[k].setText(g); 
	bl[k].setVisible(true);
	
}

public static  void cleana(int k)
{	
	a[k][0]=0;
}

public static  void cleanall()
{
	for(int z=0;z<40;z++)
		a[z][0]=0;
	
	an=0;		
}


public static  void clean()
{
	
	g0=0;
	cleanallb();
	cleanall();
		
}

public static  int seta(int x,int y,int x2,int y2,String k)
{	
	a[an][0]=1;
	a[an][1]=x;
	a[an][2]=y;
	a[an][3]=x2;
	a[an][4]=y2;
	as[an]=k;
    an++;
	return an-1;
}


public static  void seta(int k,int x,int y,int x2,int y2,String g)
{
	a[k][0]=1;
	a[k][1]=x;
	a[k][2]=y;
	a[k][3]=x2;
	a[k][4]=y2;
	as[k]=g;
	
}

public  static  void setba(int k,int x,int y,int x2,int y2,String yy)
{
	
	bba[k][0]=1;
	bba[k][1]=x;
	bba[k][2]=y;
	bba[k][3]=x2;
	bba[k][4]=y2;
	bbas[k]=yy;

	ba[k].setVisible(true);
	bag[k].setVisible(true);
}

void chk() {
	
	this.requestFocus();
}

static a15 a150;
static n n1;
static A11 a1;
//static  file f;
static  Paint paint;


public static void main(String[] args)   {
	
	
	
	
	  a1=new A11();
  	 String str="1123aajkd";
	   String[] tokens = str.split("aa");
	   for (String t:tokens) {
		   System.out.println(t);
		 }
	   System.out.println(str.substring(1,3));
	  
	   paint=new Paint();
	   a150=new a15();
	  
	   n1=new n();
	   a1.start();
	   
	 
	  
	  
		//a15.setbl(11,720,400, 300,50,1,"草地");
  	 
  }
}