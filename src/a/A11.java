package a;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class A11 implements Serializable {
	
	
	private static final long serialVersionUID = 1;
	int mary=0;
	int speed=300;
	
	//B b[]=new B[200100];
	
	int plp_num;
	int allbn=0;

	int xlong=36,ylong=29;
	
	int year=0,day=0,dayr;//每日隨機變數
	
	
	int k,g,g2,gg,k2,gh,gx,gy;
	int hx,hy,mapx,mapy,mx,my;
	
	int pop_history[];
	
	int g_speed=3;

	
	//地圖代碼 1-40地形  1-9草地 11-19土地 21-29木質 31-39岩地 
	//人物 1000+  (人物代號) 101人物圖編號
	//地上物代號 201 小麥 202樹木
	
	int groupn=0;

	int pln;
	
	int placen=0;
	long starttime,nowtime,endtime;
	
	String event[];
	int eventn,eventyear[];

	
	int bigmap[][],landmap[][];
	
	int place[],place_ty[],placex[],placey[];
	
	tribe tr[];
	B b[];
	language lg[];
	
	int lgn=0;
	
	int trn=0;
	int bn=0;
	int mapf[][];
	
	int oldmap[][][];
	
	int old_long=200;
	
	int show_state=0;
	
	int cmap[][];
	
	int thisyear=0;
	
	int in_old=0;
	int o_page=0;
	int tx=0,ty=0;
	
	int page=0;
	int ax,ay;
	
	
	String culture1[]= {"齋戒禁食","節食","食人","人祭","寡婦殉葬",
						"殺嬰","禁慾","性開放","生殖崇拜","獵首",
						"鼓勵殉節","強掠人口","紋身","剃髮","鑿齒",
						 };
	int culture_n=15;
	
	A11()
	{
		
		
		tr= new tribe[3101];
		b= new B[31010101];
		
		lg=new language[13010];
		
		
		bigmap=new int[50][50];
		landmap=new int[50][50];

		mapf=new int[50][50];
		
		pop_history=new int[10101];
		
		oldmap=new int[100][50][50];
		cmap=new int[50][50];
		
		
		
		for(int x=0;x<40;x++)
		{
			for(int z=0;z<30;z++)
			{
				bigmap[x][z]=1;
				landmap[x][z]=1;
			}
		}
		
		for(int z=0;z<10;z++)
		{
			g=(int)(Math.random()*10111)%4+3;
			gx=(int)(Math.random()*10111)%36;
			gy=(int)(Math.random()*10111)%26;
			gh=(int)(Math.random()*10311)%2;
			 create_river(gx,gy,g,gh);
			 
		//	createsea(gx,gy,0,g);
		}
		
		for(int z=0;z<8;z++)
		{
			g=(int)(Math.random()*10111)%2+2;
			gx=(int)(Math.random()*10111)%xlong;
			gy=(int)(Math.random()*10111)%ylong;
			gh=(int)(Math.random()*10311)%2;
			
			create_river(gx,gy,g,gh);
			 
			createsea(gx,gy,0,g);
		}
		

		
		
		
			
	}
	
	void save_old_map()
	{
		int k=year/old_long;
		
		for(int x=0;x<50;x++)
		{
			for(int z=0;z<50;z++)
			{
				oldmap[k][x][z]=bigmap[x][z];
				
			}
		}
	}
	
	int create_lg(String na,int fa)
	{
		lg[lgn]=new language(na,fa);
		
		
		if(fa>-1)
		{
			lg[lgn].id=lg[fa].kidn;
			lg[fa].kid[lg[fa].kidn]=lgn;
			lg[fa].kidn++;
		}
		
		lgn++;
		return lgn-1;
	}
	void create_tri(int x,int y,int vio)
	{
		while(bigmap[x][y]!=1)
		{
			if((int)(Math.random()*1727)%2==1)
			{
				x=(x+1)%xlong;
			}
			else
				x=(y+1)%xlong;
			
		}
		
		tr[trn]=new tribe(trn,a15.n1.tri_name(),x,y,-1);
		tr[trn].newtribe(vio);
		bigmap[x][y]=10+trn;
		
		gg=create_lg(tr[trn].name,-1);
		tr[trn].language_f=gg;
		tr[trn].language_gf=gg;
		
		trn++;
	}
	
	void create_river(int x,int y,int l,int dr)
	{
		if(dr==1)
		{
			for(int i=0;i<l;i++)
			{
				if(y+i>=ylong)break;
				landmap[x+i][y]=2;
			}
		}
		else {
			for(int i=0;i<l;i++)
			{
				if(y+i>=ylong)break;
				landmap[x][y+i]=3;
			}
		}
	}
	
	void createsea(int x,int y,int l,int ln)
	{
		if(x>=xlong||x<0||y>=ylong||y<0)
			return;
		if(bigmap[x][y]==2)
			return;
		
		
		bigmap[x][y]=2;//sea
		if(l>=ln)
			return;
		if((int)(Math.random()*10111)%ln>=l)
		{
			createsea(x+1,y,l+1,ln);
		}
		if((int)(Math.random()*11111)%ln>=l)
		{
			createsea(x-1,y,l+1,ln);
		}
		if((int)(Math.random()*13111)%ln>=l)
		{
			createsea(x,y+1,l+1,ln);
		}
		if((int)(Math.random()*17111)%ln>=l)
		{
			createsea(x,y-1,l+1,ln);
		}
	}
	

	void max_heap()
	{
		 double maxHeapSize = Runtime.getRuntime().maxMemory();
	        String sizeInReadableForm;

	        double kbSize = maxHeapSize / 1024;
	        double mbSize = kbSize / 1024;
	        double gbSize = mbSize / 1024;

	        if (gbSize > 0) {
	            sizeInReadableForm = gbSize + " GB";
	        } else if (mbSize > 0) {
	            sizeInReadableForm = mbSize + " MB";
	        } else {
	            sizeInReadableForm = kbSize + " KB";
	        }

	        System.out.println("\n Maximum Heap Size: " + sizeInReadableForm+"\n");
	}
	
	void test() {
		
		create_tri(15,13,60);
		create_tri(15,15,60);
		create_tri(14,14,100);
		create_tri(16,15,100);
	}
	
	void start()
	{
		//test();
		
		
		create_tri(18,7,0);
		create_tri(10,20,50);
		create_tri(25,20,100);
		
		//max_heap();
		
		map1();
	}
	
	
	void event()
	{
		if(year%old_long==0)
		{
			save_old_map();
			
		}
		
		if(year==400)
		{
			for(int x=0;x<trn;x++)
			{
				if(tr[x].live==-1)
					continue;
				
				
				g=create_lg(tr[x].name,tr[x].language_gf);
				tr[x].language_f=g;
			
			}
		}
		

		if(year%2==0)
		{
			for(int x=0;x<lgn;x++)
			{
				lg[x].live=-1;
			}
			for(int z=0;z<trn;z++)
			{
				if(tr[z].live<0)continue;
				lg[tr[z].language_f].live=1;
				lg[tr[z].language_gf].live=1;
				
				lg[tr[z].language_gf].n++;
				
				if(tr[z].language_gf!=tr[z].language_f)
					lg[tr[z].language_f].n++;
			}
			
			
			
			
			for(int z=0;z<lgn;z++)
			{
				if(lg[z].fa>-1)
					continue;
				
				for(int x=0;x<7;x++)
				{
					if(lg[lg[z].kid[x]].live>0)continue;
					
					for(int i=x;i<lg[z].kidn;i+=7)
					{
						g=lg[z].kid[i];
						if(lg[g].live>0)
						{
							gg=lg[z].kid[x];
							lg[z].kid[x]=g;
							lg[z].kid[i]=gg;
							break;
						}
					}
					if(lg[lg[z].kid[x]].live>0)continue;
					
					for(int i=7;i<lg[z].kidn;i++)
					{
						g=lg[z].kid[i];
						if(lg[g].live>0)
						{
							gg=lg[z].kid[x];
							lg[z].kid[x]=g;
							lg[z].kid[i]=gg;
							
							lg[g].id=x;
							break;
						}
					}
					
				}
				
			}
		}
		
	}
	
	
	void newyear()
	{
		
		event();
		year++;
		
		if(year%10==0)
		 System.out.print("New year:"+year+" bn="+bn+"  tr_n="+trn+"\n");
		
		int nn=0;
		
		for(int z=0;z<50;z++)
		{
			for(int i=0;i<50;i++)
				mapf[z][i]=0;
		}
		
		for(int x=0;x<trn;x++)
		{
			if(tr[x].live==-1&&tr[x].die_year<=year-old_long/2)
			{
				if(bigmap[tr[x].ax][tr[x].ay]==10+x)
				{
					bigmap[tr[x].ax][tr[x].ay]=1;
				}			
			}
		}
		
		
		for(int x=0;x<trn;x++)
		{
			if(tr[x].live==-1)
				continue;
			tr[x].count_food0();
		}
		for(int x=0;x<trn;x++)
		{
			if(tr[x].live==-1)
				continue;
			tr[x].count_food1();
			
			if(year%10==0&&year>0)
			tr[x].addhis("本年總人口:"+tr[x].n+"人，成丁"+tr[x].man_n+"人");
		}
		
		
		
		for(int x=0;x<trn;x++)
		{
			if(tr[x].live==-1)
				continue;
			
			tr[x].newyear();
			nn+=tr[x].n;
		}
		
		 plp_num=nn;
		
		 if(year%10==0)
		 {
			 pop_history[year/10]=plp_num;
		 }
	}
	
	void show_pop()
	{
		a15.clean();

		a15.seta(0, 10, 1600, 750,"217");
		a15.seta(0, 500, 600, 280,"talk");
		
		
		mapx=1000;
		mapy=1000;
		a15.state=1;
		
		for(int z=0;z<10;z++)
		{
			if(page*10+z*10>year)break;
			
			a15.setbl(10+z,800,20+40*z,1000,30,1,"第"+(page*10+z*10)+"年  人口:"+pop_history[page+z]);
		}
		
		if(page>0)
			a15.setb(2,1000,400,100,40,"上一頁");
		
		if(page*10+100<=year)
			a15.setb(3,1000,450,100,40,"下一頁");
		
		a15.setb(1,800,500,100,40,"返回");
		
		 Thread t2= new Thread( new Runnable(){
			 public void run(){	  try {
				 
				 for (int i = 1; i < 700;) {
					 	
					
					if(a15.g0==1)
					{
						
						a15.g0=0;
						map1();
						break;
					}
									
					if(a15.g0==2)
					{		
						page-=10;
						show_pop();
						
						break;
						
					}
					if(a15.g0==3)
					{		
						page+=10;
						show_pop();
						
						break;
						
					}
		
						 Thread.sleep(speed);
				}
			 
			 } catch (Exception e) {  e.printStackTrace();
			 } 	 } } );   t2.start();

		
	}
	

	void showoldmap()
	{

		for(int x=0;x<50;x++)
		{
			for(int z=0;z<50;z++)
			{
				bigmap[x][z]=oldmap[(thisyear/old_long)][x][z];
			}
		}
		
		
		
		
		a15.clean();

		a15.seta(0, 10, 1600, 750,"217");
		a15.seta(0, 500, 600, 280,"talk");
		

		for(int x=0;x<10;x++)
		{
			if((o_page+x)*old_long>year)
				break;
			
			a15.setb(10+x,800,20+x*40,120,30, "第"+old_long*(x+o_page)+"年");
		}
		
		if(o_page>0)
			a15.setb(8,1100,400,100,30,"上一頁");
		else 
			a15.cleanb(8);
		
		if((o_page+10)*old_long<=year)
			a15.setb(9,1100,450,100,30,"下一頁");
		else
			a15.cleanb(9);
		
		a15.setbl(1,800,500,1200,40,1,"第"+thisyear+"年  歷史遺址 此年世界人口:"+pop_history[thisyear/10]);
		 
		mapx=1000;
		mapy=1000;
		a15.state=1;
		a15.g0=0;
		day=0;
		
		
		a15.setb(7,1100,500,100,40, "返回");
		
		Thread t2= new Thread( new Runnable(){
				 public void run(){	  try {
					 
					 for (int i = 1; i < 700;) {
						 
						 
						 
						 if(a15.g0>=10&&a15.g0<=19)
						 {
							 g=a15.g0-10+o_page;
							 if(g*old_long>year) {
								 a15.g0=0;
							 }
							 else {
								 thisyear=g*old_long;
								 showoldmap();
								 break;
							 }
						 }
						
						if(a15.g0==0&&mapx<40&&mapy<30)
						{
							String yy[]= {"no","陸地","海洋","未知"};
							//a15.cleanbl(3);
							//a15.cleanbl(4);
							
							a15.cleanallb();

							
							a15.setbl(1,800,300,1200,40,1,"第"+thisyear+"年  歷史遺址 世界人口:"+pop_history[thisyear/10]);
							
							if( bigmap[mapx][mapy]<=3)
							{
								a15.setbl(3,800,380,1200,40,1,"型態:"+yy[ bigmap[mapx][mapy]]);
								a15.setbl(4,800,420,1200,40,1,"位置: x="+mapx+ "y="+mapy);
								a15.cleanbl(5);a15.cleanbl(6);
							}				
							else if( bigmap[mapx][mapy]>=10) {
								
								int tt= bigmap[mapx][mapy]-10;
								
								if(tr[ bigmap[mapx][mapy]-10].live<0)
									a15.setbl(3,800,380,1200,30,1,tr[ bigmap[mapx][mapy]-10].name+"部落，成立於"+tr[ bigmap[mapx][mapy]-10].found_year+"年，滅亡於"+tr[ bigmap[mapx][mapy]-10].die_year+"年 (已滅亡)");
								else
									a15.setbl(3,800,380,1200,30,1,tr[ bigmap[mapx][mapy]-10].name+"部落，成立於"+tr[ bigmap[mapx][mapy]-10].found_year+"年");
								
								
								a15.setbl(4,800,420,1200,30,1,"部落人數: "+tr[ bigmap[mapx][mapy]-10].n+" 家族數量:"+tr[ bigmap[mapx][mapy]-10].hn+" 成丁數量:"+tr[ bigmap[mapx][mapy]-10].man_n+" 兒童數量:"+tr[ bigmap[mapx][mapy]-10].kid_n);
							
								a15.setbl(5,800,460,1200,30,1," 生存壓力:"+tr[ bigmap[mapx][mapy]-10].pressure+" 糧食數:"+tr[ bigmap[mapx][mapy]-10].food);
								
								a15.setbl(6,800,500,1200,30,1," 文化: "+lg[tr[tt].language_gf].name+"語系 "+lg[tr[tt].language_f].name+"語族");
								
								
								a15.setb(1,800,560,100,40, "進入");
								a15.setb(6,1000,560,100,40, "返回");
							
							}	
							tx=mapx;
							ty=mapy;
							mapx=1000;
							mapy=1000;
							a15.g0=0;
						}
						
						if(a15.g0==6)
						{		
		
							showoldmap();
							break;
							
						}	
						if(a15.g0==8)
						{		
							if(o_page>0)
								o_page-=10;
							
							showoldmap();
							break;
							
						}	
			
						if(a15.g0==9)
						{					
							o_page+=10;
							showoldmap();
							break;
							
						}	
										
						if(a15.g0==1)
						{		
							if(bigmap[tx][ty]>=10)
								c_tri=bigmap[tx][ty]-10;
							else
								c_tri=-1;
							
							map2();
							break;
							
						}
						if(a15.g0==7)
						{		
							for(int x=0;x<50;x++)
							{
								for(int z=0;z<50;z++)
								{
									bigmap[x][z]=cmap[x][z];
								}
							}
							
							in_old=0;
							map1();
							break;
							
						}
			
							 Thread.sleep(speed);
					}
				 
				 } catch (Exception e) {  e.printStackTrace();
				 } 	 } } );   t2.start();
	}
	
	
	int c_tri=0,stop=0;
	
	void map1()//大地圖
	{	
		a15.clean();

		a15.seta(0, 10, 1600, 750,"217");
		a15.seta(0, 500, 600, 280,"talk");
		
		
		
		if(stop!=0)
			a15.setb(2,1000,550,100,40,"繼續");
		else
			a15.setb(2,1000,550,100,40,"暫停");
		
		
		
		a15.setb(4,800,50,120,40,"人口史");
		a15.setb(5,800,100,120,40,"歷史遺址");
		
		
		mapx=1000;
		mapy=1000;
		a15.state=1;
		a15.g0=0;
		day=0;
		

		 Thread t2= new Thread( new Runnable(){
				 public void run(){	  try {
					 
					 for (int i = 1; i < 700;) {
						 
						
						 
						 if(stop==0)
						 day++;
						 
						 if(day>1)
						 {
							 newyear();
							 day=0;
							 
							 a15.setbl(1,800,300,1200,40,1,"大地圖 世界人口:"+plp_num+" "+" 歷史累積人口:"+bn);
							 a15.setbl(2,800,340,1200,40,1,"第"+year+"年" );
						 }
						
						if(a15.g0==2)
						{
							if(stop==0)
							a15.setb(2,1000,550,100,40,"繼續");
							else
								a15.setb(2,1000,550,100,40,"暫停");
							
							stop=~stop;
							a15.g0=0;
					    }
						
						if(a15.g0==4)
						{
							page=0;
							a15.g0=0;
							show_pop();
							break;
					    }
						if(a15.g0==5)
						{
							
							for(int x=0;x<50;x++)
							{
								for(int z=0;z<50;z++)
								{
									cmap[x][z]=bigmap[x][z];
								}
							}
							
							in_old=1;
							o_page=0;
							a15.g0=0;
							showoldmap();
							break;
					    }
						
						
						if(a15.g0==0&&mapx<40&&mapy<30)
						{
							String yy[]= {"no","陸地","海洋","未知"};
							//a15.cleanbl(3);
							//a15.cleanbl(4);
							
							if( bigmap[mapx][mapy]<=3)
							{
								a15.setbl(3,800,380,1200,40,1,"型態:"+yy[ bigmap[mapx][mapy]]);
								a15.setbl(4,800,420,1200,40,1,"位置: x="+mapx+ "y="+mapy);
								a15.cleanbl(5);a15.cleanbl(6);
							}				
							else if( bigmap[mapx][mapy]>=10) {
								
								int tt= bigmap[mapx][mapy]-10;
								
								if(tr[ bigmap[mapx][mapy]-10].live<0)
									a15.setbl(3,800,380,1200,30,1,tr[ bigmap[mapx][mapy]-10].name+"部落，成立於"+tr[ bigmap[mapx][mapy]-10].found_year+"年，滅亡於"+tr[ bigmap[mapx][mapy]-10].die_year+"年 (已滅亡)");
								else
									a15.setbl(3,800,380,1200,30,1,tr[ bigmap[mapx][mapy]-10].name+"部落，成立於"+tr[ bigmap[mapx][mapy]-10].found_year+"年");
								
								
								a15.setbl(4,800,420,1200,30,1,"部落人數: "+tr[ bigmap[mapx][mapy]-10].n+" 家族數量:"+tr[ bigmap[mapx][mapy]-10].hn+" 成丁數量:"+tr[ bigmap[mapx][mapy]-10].man_n+" 兒童數量:"+tr[ bigmap[mapx][mapy]-10].kid_n);
							
								a15.setbl(5,800,460,1200,30,1," 生存壓力:"+tr[ bigmap[mapx][mapy]-10].pressure+" 糧食數:"+tr[ bigmap[mapx][mapy]-10].food);
								
								a15.setbl(6,800,500,1200,30,1," 文化: "+lg[tr[tt].language_gf].name+"語系 "+lg[tr[tt].language_f].name+"語族");
								
								
								a15.setb(1,800,560,100,40, "進入");
							
							}						
							tx=mapx;
							ty=mapy;
							//mapx=1000;
							//mapy=1000;
							a15.g0=0;
						}
										
						if(a15.g0==1)
						{		
							if(bigmap[tx][ty]>=10)
								c_tri=bigmap[tx][ty]-10;
							else
								c_tri=-1;
							
							map2();
							break;
							
						}
			
							 Thread.sleep(speed);
					}
				 
				 } catch (Exception e) {  e.printStackTrace();
				 } 	 } } );   t2.start();
	}
	
	void show_tri_member()
	{
		
		k=c_tri;
		if(k==-1)
		{
			map2();
			return;
		}
		
		a15.clean();

		a15.seta(0, 10, 1600, 750,"217");
		a15.seta(0, 500, 600, 280,"talk");
						
		a15.setbl(1,625,30,800,20,1,tr[k].name+"  部落 歷史累積人口:"+tr[k].allp);
		

								
		mx=1000;
		my=1000;

		a15.g0=0;
		String y="";
		for(int x=0;x<10;x++)
		{
			if(page+x>=tr[k].pn)
				break;
			g=tr[k].pop[page+x];
			
			
			if(b[g].wi>=0&&b[b[g].wi].live>0)y=b[b[g].wi].fullname()+"("+b[b[g].wi].age()+"歲)";
			else y="無";
				
			if(b[g].live>0)
				a15.setbl(10+x,625,70+x*40,800,35,1,b[g].fullname()+" "+b[g].sex()+" "+b[g].age()+"歲,   配偶:"+y+"  住址:"+b[g].house);
			else
				a15.setbl(10+x,625,70+x*40,800,35,1,b[g].fullname()+" "+b[g].sex()+" (已故) 享年"+b[g].age()+"歲 死因:"+b[g].die_reason+" 存活後代數:"+b[g].count_descendants(g, 2, 1));
			
			a15.setb(10+x,1100,70+x*40,100,30,"查看");
					
		}
			
			if(page>0)
				a15.setb(8,1100,500,100,40,"上一頁");
		
			
			if(page+10<tr[k].pn)
				a15.setb(9,1100,550,100,40,"下一頁");
		
		

		a15.setb(5,625,550,100,40, "返回");
		
		a15.setb(7,625,500,100,40,"末頁");
		
		 Thread t2= new Thread( new Runnable(){
				 public void run(){	  try {
					 
					 for (int i = 1; i < 700;) {
							
							
						if(a15.g0==7)
						{					
							page=(tr[k].pn-1)-(tr[k].pn-1)%10;
							show_tri_member();
							break;
								
						}
							
						if(a15.g0==8)
						{		
							if(page>0)
							page-=10;
							
							show_tri_member();
							break;
							
						}	

						if(a15.g0==9)
						{					
							page+=10;
							show_tri_member();
							break;
							
						}	

						if(a15.g0==5)
						{					
							map2();
							break;
							
						}
						

						if(a15.g0>=10&&a15.g0<=19)
						{
							k=tr[k].pop[page+a15.g0-10];
							showperson();
							a15.g0=0;
							break;
						}
						
				
			
							 Thread.sleep(speed);
					}
				 
				 } catch (Exception e) {  e.printStackTrace();
				 } 	 } } );   t2.start();
	}
	

	void map2()//中地圖
	{	
		a15.clean();

		a15.seta(0, 10, 1600, 750,"217");
		a15.seta(0, 500, 600, 280,"talk");
		if(c_tri>=0) {
			a15.setbl(2,800,400,800,30,1,"部落:"+tr[c_tri].name+"  首領:"+b[tr[c_tri].leader].fullname());		
			
			a15.setbl(4,800,440,1200,30,1,"部落人數: "+tr[ c_tri].n+" 家族數量:"+tr[c_tri].hn+" 成丁數量:"+tr[c_tri].man_n+" 兒童數量:"+tr[c_tri].kid_n);
			
			a15.setbl(5,800,480,1200,30,1," 生存壓力:"+tr[ c_tri].pressure+" 糧食數:"+tr[c_tri].food);
			
			a15.setbl(6,800,520,1200,30,1," 文化: "+lg[tr[c_tri].language_gf].name+"語系 "+lg[tr[c_tri].language_f].name+"語族");
			
			
			a15.setb(3,800,50,120,40, "部落歷史");
			a15.setb(4,800,100,120,40, "部落文化");
			a15.setb(5,800,150,120,40, "部落成員");
		}
		else
			a15.setbl(2,800,400,800,30,1,"荒野");
		
		a15.setb(1,1000,500,140,40, "返回");
		
		
		
		
		mx=1000;
		my=1000;
		ax=mx;ay=my;
		a15.state=2;
		a15.g0=0;
		page=0;

		 Thread t2= new Thread( new Runnable(){
				 public void run(){	  try {
					 
					 for (int i = 1; i < 700;) {
						
					
						if(a15.g0==0&&mx<15&&my<15&&mx>=0&&my>=0)
						{
							a15.cleanallb();
							
							ax=mx;ay=my;
							mx=1000;my=1000;
							if(c_tri>=0)
								a15.setbl(2,800,400,800,30,1,"部落:"+tr[c_tri].name+"  首領:"+b[tr[c_tri].leader].fullname());
							else
								a15.setbl(2,800,400,800,30,1,"荒野");
							
							a15.setbl(3,800,440,1200,30,1,"位置: x="+mx+ "y="+my);
							
							if(c_tri>=0&&tr[c_tri].house_n[ax*15+ay]>0) {
								
								
								a15.setbl(4,800,480,800,30,1,"家族族長:"+b[tr[c_tri].house[ax*15+ay][0]].fullname());
							
								a15.setbl(5,800,520,800,30,1,"家族人數:"+tr[c_tri].house_n[ax*15+ay]);
								
								
								a15.setb(2,1000,550,140,40, "家族成員一覽");
							}
							else {
							
							}
							a15.setb(1,1000,500,140,40, "返回");
							a15.setb(3,800,50,120,40, "部落歷史");
							
							page=0;
							a15.g0=0;
						}
						
						if(a15.g0==1)
						{	
							if(in_old==0)				
								map1();
							else {
								
								showoldmap();
							}
							
							break;
							
						}
						
						if(a15.g0==2)
						{		
							a15.cleanallb();
							if(c_tri>=0)
							{
								String sex[]= {"女","男"};
								for(int x=0;x<10;x++)
								{
									if(page+x>=tr[c_tri].house_n[ax*15+ay])
										break;
									k=page+x;
									 System.out.print("page"+page+"k="+k+" c_tri="+c_tri+" ax="+ax+" ay="+ay+" \n");
									
									a15.setbl(10+x,800,15+x*35,400,35,1,""+b[tr[c_tri].house[ax*15+ay][k]].fullname()+" "+sex[b[tr[c_tri].house[ax*15+ay][k]].sex]+" "+(year-b[tr[c_tri].house[ax*15+ay][k]].bornyear)+"歲");
									
									a15.setb(10+x,950,17+x*35,100,30,"查詢");
									
								}
								
								if(page>0)
									a15.setb(8,1100,250,100,30,"上一頁");
								else 
									a15.cleanb(8);
								
								if(page+10<tr[c_tri].house_n[ax*15+ay])
									a15.setb(9,1100,300,100,30,"下一頁");
								else
									a15.cleanb(9);
							}
							
							//mx=1000;
							//my=1000;
							a15.setb(7,1000,500,140,40, "返回");
							a15.g0=0;

							
						}
						
						if(a15.g0==3)
						{
							k=c_tri;
							page=0;
							showevent();
							a15.g0=0;
							break;
						}
						
						if(a15.g0==4)
						{
							k=c_tri;
							showculture();
							a15.g0=0;
							break;
						}
						
						if(a15.g0==5)
						{
							k=c_tri;
							page=0;
							show_tri_member();
							a15.g0=0;
							break;
						}
						
						if(a15.g0==7)
						{
							
							page=0;
							map2();
							a15.g0=0;
							break;
						}
						
						
						
						if(a15.g0==8)
						{
							if(page>0)
							page-=10;
							
							a15.g0=2;
							
						}	
			
						if(a15.g0==9)
						{					
							page+=10;
							a15.g0=2;
							
						}	
						
						if(a15.g0>=10&&a15.g0<=19)
						{
							k=tr[c_tri].house[ax*15+ay][page+a15.g0-10];
							System.out.print("a15.g0="+a15.g0+"    page"+page+"k="+k+" c_tri="+c_tri+" ax="+ax+" ay="+ay+" \n");
						    showperson();
							
						    break;
							 
					
						}
						
						
						
			
							 Thread.sleep(speed);
					}
				 
				 } catch (Exception e) {  e.printStackTrace();
				 } 	 } } );   t2.start();
	}
	

	
	void showperson()
	{

		if(k==-1)
		{
			map2();
			return;
		}
		a15.clean();

		a15.seta(0, 10, 1600, 750,"217");
		a15.seta(0, 500, 600, 280,"talk");
						
		String sex[]= {"女","男"};
				
		a15.setbl(1,800,50,800,30,1,b[k].fullname()+"  住址:"+b[k].house+"  出生年:"+b[k].bornyear);
		if(b[k].live>-1)
			a15.setbl(2,800,100,800,30,1,"性別"+sex[b[k].sex]+" 年齡:"+(b[k].age()));
		else
			a15.setbl(2,800,100,800,30,1,"性別"+sex[b[k].sex]+" 享年:"+b[k].age()+" 死因:"+b[k].die_reason+" (已故)");
			
		
		if(b[k].fa>=0)
		{
			if(b[b[k].fa].live>-1)
				a15.setbl(3,800,150,800,30,1,"父:"+b[b[k].fa].fullname()+" 年齡:"+b[b[k].fa].age()+"歲");
			else
				a15.setbl(3,800,150,800,30,1,"父:"+b[b[k].fa].fullname()+" 享年:"+b[b[k].fa].age()+"歲 (已故)");
			
			a15.setb(6,1050,150,90,30,"查詢");
			
			if(b[b[k].ma].live>-1)
				a15.setbl(4,800,190,800,30,1,"母:"+b[b[k].ma].fullname()+" 年齡:"+b[b[k].ma].age()+"歲");
			else
				a15.setbl(4,800,190,800,30,1,"母:"+b[b[k].ma].fullname()+" 享年:"+b[b[k].ma].age()+"歲 (已故)");
			
			
			a15.setb(7,1050,190,90,30,"查詢");
			
		}
		a15.setbl(5,800,300,800,30,1,"所屬部落:"+tr[c_tri].name);
		a15.setbl(6,800,340,800,30,1,"子女數:"+b[k].kidn+" 總後裔數:"+b[k].count_descendants(k,2, 0)+" 在世後裔數:"+b[k].count_descendants(k,2, 1));

		a15.setbl(7,800,380,800,30,1,"父系後裔總數:"+b[k].count_descendants(k,1, 0)+" 在世父系後裔數:"+b[k].count_descendants(k,1, 1));
		a15.setbl(8,800,420,800,30,1,"母系後裔總數:"+b[k].count_descendants(k,0, 0)+" 在世母系後裔數:"+b[k].count_descendants(k,0, 1));
		
		
		a15.setb(2,800,500,100,30,"子女");
		a15.setb(3,1000,500,100,30,"配偶");
								
		mx=1000;
		my=1000;

		a15.g0=0;
		page=0;
		show_state=0;
		a15.setb(1,800,550,100,30, "返回");

		
		 Thread t2= new Thread( new Runnable(){
				 public void run(){	  try {
					 
					 for (int i = 1; i < 700;) {
						
			
						if(a15.g0==1)
						{					
							map2();
							break;		
						}
						 
						if(a15.g0==2)
						{		
							a15.cleanallb();
							String sex[]= {"女","男"};
							for(int x=0;x<10;x++)
							{
								if(page+x>=b[k].kidn)
									break;
								
								
								g=(int) b[k].kid.elementAt(page+x);
									 
								if(b[g].live>-1)
									a15.setbl(10+x,800,15+x*35,400,35,1,""+b[g].fullname()+" "+sex[b[g].sex]+" 年齡:"+(b[g].age())+"歲");
								else
									a15.setbl(10+x,800,15+x*35,400,35,1,""+b[g].fullname()+" "+sex[b[g].sex]+" 得年:"+(b[g].age())+"歲 (已故)");
								
									
								a15.setb(10+x,1050,17+x*35,90,30,"查詢");
									
							}
								
								if(page>0)
									a15.setb(8,1100,450,100,30,"上一頁");
								else 
									a15.cleanb(8);
								
								if(page+10<b[k].kidn)
									a15.setb(9,1100,500,100,30,"下一頁");
								else
									a15.cleanb(9);
							
							a15.cleanb(2);
							//mx=1000;
							//my=1000;
							a15.setb(5,800,550,100,30, "返回");
							
							a15.g0=0;

							
						}
						
						if(a15.g0==3)
						{		
							
							a15.cleanallb();
							show_state=1;
							
							for(int x=0;x<10;x++)
							{
								if(x>=b[k].wi_rn)
									break;
								g=b[k].wi_r[x];
									 
								if(b[g].live>-1)
									a15.setbl(10+x,700,15+x*35,800,35,1,""+b[g].fullname()+" "+sex[b[g].sex]+" 年齡:"+(b[g].age())+"歲, "+b[k].wi_r2[x]+"歲成婚");
								else
									a15.setbl(10+x,700,15+x*35,800,35,1,""+b[g].fullname()+" "+sex[b[g].sex]+" 得年:"+(b[g].age())+"歲 (已故), "+b[k].wi_r2[x]+"歲成婚");
								
									
								a15.setb(10+x,1100,17+x*35,90,30,"查詢");
									
							}
								
							a15.setb(5,800,550,100,30, "返回");							
							a15.g0=0;

							
						}
						
						if(a15.g0==5)
						{					
							showperson();
							break;	
						}
						
						
						if(a15.g0==6)
						{
							k=b[k].fa;
							showperson();
							break;
						}
						
						if(a15.g0==7)
						{	
							k=b[k].ma;
							showperson();
							break;
						}
						
						
						if(a15.g0==8)
						{		
							if(page>0)
							page-=10;
							a15.g0=2;
						}	
			
						if(a15.g0==9)
						{					
							page+=10;
							a15.g0=2;	
						}	
						
						if(a15.g0>=10&&a15.g0<=19)
						{
							if(show_state==1)
							{
								k=b[k].wi_r[a15.g0-10];
								showperson();
							}
							else {
								
								
								k=(int)b[k].kid.elementAt(page+a15.g0-10);
								showperson();
							}
							
							
							break;
						}
						
						
					
			
							 Thread.sleep(speed);
					}
				 
				 } catch (Exception e) {  e.printStackTrace();
				 } 	 } } );   t2.start();
	}
	
	void showculture()
	{
		if(k==-1)
		{
			map2();
			return;
		}
		a15.clean();

		a15.seta(0, 10, 1600, 750,"217");
		a15.seta(0, 500, 600, 280,"talk");
		
		String v[]= {"非常和平","比較和平","略為暴力","十分暴力","極端殘暴","終極殘暴","人神共憤","萬惡之淵","萬惡之淵X2","萬惡之淵X3","萬惡之淵X4","萬惡之淵X5"};
		
		String st[]= {"蠢不可及","庸碌無能","中規中矩","足智多謀","天選之才","天神降世","天神降世X2"};
		
						
		a15.setbl(1,700,30,800,30,1,tr[k].name+"部落的文化:");
		
		
		a15.setbl(2,700,100,800,30,1,"部落語言: "+lg[tr[c_tri].language_gf].name+"語系 "+lg[tr[c_tri].language_f].name+"語族");
		
		
		a15.setbl(3,700,140,800,30,1,"部落傳統: "+v[tr[c_tri].violence/20]+"("+tr[c_tri].violence+")   當前風格:"+v[tr[c_tri].vio()/20]+"("+tr[c_tri].vio()+")");
		
		a15.setbl(4,700,180,800,30,1,"首領風格: "+v[b[tr[c_tri].leader].violence()/20]+"("+b[tr[c_tri].leader].violence()+")   首領智謀: "+st[b[tr[c_tri].leader].smart()/20]+"("+b[tr[c_tri].leader].smart()+")");
		
		a15.setbl(5,700,220,800,30,1,"部落習俗: "+culture1[tr[c_tri].culture[0]]+", "+culture1[tr[c_tri].culture[1]]+", "+culture1[tr[c_tri].culture[2]]+"");
		
								
		mx=1000;
		my=1000;

		a15.g0=0;

		a15.setb(5,700,550,100,40, "返回");

		
		 Thread t2= new Thread( new Runnable(){
				 public void run(){	  try {
					 
					 for (int i = 1; i < 700;) {
						

						if(a15.g0==5)
						{					
							map2();
							break;						
						}
							
							 Thread.sleep(speed);
					}
				 
				 } catch (Exception e) {  e.printStackTrace();
				 } 	 } } );   t2.start();
		
	}
	void showevent()
	{

		if(k==-1)
		{
			map2();
			return;
		}
		a15.clean();

		a15.seta(0, 10, 1600, 750,"217");
		a15.seta(0, 500, 600, 280,"talk");
						
		a15.setbl(1,625,30,800,30,1,tr[k].name+"  部落編年史:");
		

								
		mx=1000;
		my=1000;

		a15.g0=0;
		
		for(int x=0;x<10;x++)
		{
			if(page+x>=tr[k].his_n)
				break;
			
			a15.setbl(10+x,625,80+x*35,800,35,1,tr[k].history[page+x]);
					
		}
			
			if(page>0)
				a15.setb(8,1100,450,100,40,"上一頁");
			else 
				a15.cleanb(8);
			
			if(page+10<tr[k].his_n)
				a15.setb(9,1100,500,100,40,"下一頁");
			else
				a15.cleanb(9);
		
		a15.setb(7,625,500,100,40,"末頁");
		//mx=1000;
		//my=1000;
		a15.setb(5,625,550,100,40, "返回");

		
		 Thread t2= new Thread( new Runnable(){
				 public void run(){	  try {
					 
					 for (int i = 1; i < 700;) {
						
			
					
						if(a15.g0==7)
						{		
							page=(tr[k].his_n-1)-(tr[k].his_n-1)%10;
								
							showevent();
							break;
								
						}	
												
						if(a15.g0==8)
						{		
							if(page>0)
							page-=10;
							
							showevent();
							break;
							
						}	
			
						if(a15.g0==9)
						{					
							page+=10;
							showevent();
							break;
							
						}	

						if(a15.g0==5)
						{					
							map2();
							break;
							
						}
				
			
							 Thread.sleep(speed);
					}
				 
				 } catch (Exception e) {  e.printStackTrace();
				 } 	 } } );   t2.start();
	}
	
	
	int addman(int sex,int age,int h,int tr)
	{
		if(sex==1) {
			
			b[bn]=new B(bn,a15.n1.man_name(),a15.n1.man_name(),sex,year-age,-1,-1,h,tr);
			
		}
		else if(sex==0) {
			
			b[bn]=new B(bn,a15.n1.woman_name(),a15.n1.woman_name(),sex,year-age,-1,-1,h,tr);
			
		}
		bn++;
		
		return bn-1;
		
	}
	
	int addkid(int fa,int ma)
	{
		int sex=(int)(Math.random()*13127)%2;
		
		if(sex==1) {
			
			b[bn]=new B(bn,a15.n1.man_name(),b[fa].name,sex,year,fa,ma,b[fa].house,b[fa].tr);
			
		}
		else if(sex==0) {
			
			b[bn]=new B(bn,a15.n1.woman_name(),b[ma].name,sex,year,fa,ma,b[fa].house,b[fa].tr);
			
		}
		b[fa].addkid(bn);
		b[ma].addkid(bn);
		
		bn++;
		
		return bn-1;
		
	}
	
	void add_tri(int old)
	{
		
	}
	
	
	
	
	
	
}
