
package a;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;

public class n   {
	
	int ay[],ax[],ap[],an,nstart,m[][];
	int p[],pn;
	String p2[];
	
	//int goalx,goaly;
	
	 
	n() 
	{
		nstart=0;
		//waiting();
		an=0;
		ax=new int [16000];
		ay=new int [16000];
		ap=new int [16000];
		p=new int [5000];
		p2=new String [5000];
		m=new int [6000][6000];
		for(int z=0;z<6000;z++)
		{
			for(int i=0;i<6000;i++)
				m[z][i]=0;
		}
		//start() ;
		
	}
	String y2;
	
	String createplacename(int k0) {
		int g,g2;
		String yy="";
		String st[]={"new","west","south",""};
		String mid[]={"Green","Rock","Blue","Black","Sex","Rus","Kent","Lean","Pro","Stock",
				"Mettis","Fin","Gaule","Cel","Han","Cloud","Wind","Sun","Red","Cold",
				"Gote","Head","beau","",""};
		
		String mid2[]={"格林","洛克","布魯","布萊克","薩克","羅斯","肯特","利恩","波","斯塔克",
				"梅蒂斯","芬","高爐","賽爾","漢","克勞德","溫德","桑","瑞德","柯爾德",
				"哥德","黑得","比歐","",""};
		
		String last[]={"land","berg","lake","stan","na","ia","nia","land",""};
		
		String last2[]={"蘭","堡","雷克","斯坦","那","亞","尼亞","蘭",""};

		
		
		
		
		
		return yy;
		
	}
	
	
	
	String color[]={"黑","紅","土","黃","赤","褐","紫","青","墨","綠",
			"藍","灰","白","巨","矮","高","碧","桑","人","雷",
			"火","金","石","地","牙","骨","真","大","細","天",
			"沙","肥","怪","巫","異","神","彩","玉","兇"};//39
	
	String color2[]={"黑","紅","土","黃","赤","褐","紫","青","墨","綠",
			"藍","灰","白","巨","矮","高","碧","桑","人","雷",
			"火","金","石","地","牙","骨","真","大","細","天",
			"沙","肥","怪","巫","異","神","彩","玉","兇","幼",
			"壯","美","剽","悍","慈","善","寬","敏","捷","苗",
			"麗","艷","輕"};//53
	
	
	String ob[]={"熊","鳥","鷹","蛇","蟲","虎","狼","牛","羊","鹿",
			"角","毛","首","眼","耳","鼻","面","目","木","丘",
			"山","水","河","川","谷","洞","男","人","獸","猛",
			"原","土","堆","穴","穀","草","漢","風","雲"};//39
	
	
	String ob_w[]={"雲","花","容","蝶","女","虹","羊","肚","梨","果",
			"衣","裙","布","環","月","婦","姒","羞","善","慈",
			"愛","素","水","芙","婆","兒","妹","童","嬰","珠",
			"絮","香","芳","沫","蓮","娘","羊","嫗","喜"};//39
	
	String man_name()
	{
		String t="";
		
		t=color2[(int)(Math.random()*11127)%53];
		t+=ob[(int)(Math.random()*1727)%39];
		
		return t;
	}
	String woman_name()
	{
		String t="";
		
		t=color2[(int)(Math.random()*11127)%53];
		t+=ob_w[(int)(Math.random()*1727)%39];
		
		return t;
	}
	
	
	String tri_name()
	{
		
		String t="";
		
		t=color[(int)(Math.random()*11127)%39];
		t+=ob[(int)(Math.random()*1727)%39];
		
		return t;
	}
	
	String creategroupname(int k0) {
		int g,g2;
		String yy;
		String st[]={"new","west","south",""};
		String mid[]={"Green","Rock","Blue","Black","Sex","Rus","Kent","Lean","Pro","Stock",
				"Mettis","Fin","Gaule","Cel","Han","Cloud","Wind","Sun","Red","Cold",
				"Gote","Head","beau","",""};
		
		String mid2[]={"格林","洛克","布魯","布萊克","薩克","羅斯","肯特","利恩","波","斯塔克",
				"梅蒂斯","芬","高爐","賽爾","漢","克勞德","溫德","桑","瑞德","柯爾德",
				"哥德","黑得","比歐","",""};
		
		String last[]={"land","berg","lake","stan","na","ia","nia","land",""};
		
		String last2[]={"蘭","堡","雷克","斯坦","那","亞","尼亞","蘭",""};
		
		
		if((int)(Math.random()*12121)%6==1) {
			
				yy="St.";y2="聖";			
			g=(int)(Math.random()*172127)%3;			
				yy+="s"+last[g];
				y2+=last2[g];			
		}
		else {
			g=(int)(Math.random()*12121)%23;
			g2=(int)(Math.random()*172127)%8;
			yy=mid[g]+last[g2];
			y2=mid2[g]+last2[g2];
		}
		return yy;
		
	}
	
	
	
	void waiting()
	{
		a15.clean();

		a15.seta(1,0, 0, 700, 600,"talk");
		a15.seta(2,700,0, 450,580,"talk4");
		//a15.seta(3,1000,20, 135,200,"talk2");
		a15.setbl(11,700,400, 305,30,1,"wating");
	}
	void start() {
	
	}
	
	
	int bg[]=new int[30100],bgn=0;
	void addcreateg(int k)
	{
		bg[bgn]=k;
		bgn++;
	}
	void maincreategroup(int h,int hh,int k)
	{
		bgn=0;
		addcreateg(k);
		for(int z=0;z<bgn;z++)
		{
		//	a15.a1.b[bg[z]].subcreategroup0(h, hh);
		}
		
		
	}
	

}
