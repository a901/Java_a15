package a;

public class tribe {
	
	

	int k,g,gg,gh,gk,g2,g0,t,q,gl;
	
	int this_k;
	int live=1;
	
	int level=0;
	
	int house[][],house_n[],hn,n;
	//int h_leader[];
	String name;
	
	int pressure=0;
	
	int ax,ay;
	int boy_h[],girl_h[];
	int boy_z[],girl_z[];
	
	int girl2_z[],girl2_h[];
	
	int boy_n,girl_n,girl2_n;
	
	int father=-1;
	
	int language_gf,language_f,language;
	
	
	int violence=100;
	int man_n=0,kid_n=0;
	
	int leader=0;
	String history[];
	int his_n=0;
	
	int tsex=1;
	int found_year=0,die_year;
	
	int culture[];
	
	boolean cl0[]; 
	
	int pop[];
	int pn=0,allp=0;
	
	tribe(int k0,String name0, int xx,int yy,int fa)
	{
		k=k0;
		this_k=k0;
		
		name=name0;
		ax=xx;
		ay=yy;
		
		live=1;
		hn=0;
		n=0;
		pn=0;
		allp=0;
		
		house_n=new int[227];
	//	h_leader=new int[227];
		house=new int[227][225];
		
		
		pop=new int[5010];
		
		culture=new int[5];
		cl0=new boolean[20];
		for(int z=0;z<20;z++)
		{
			cl0[z]=false;
		}
		
		for(int x=0;x<225;x++)
		{
			for(int z=0;z<225;z++)
			{
				house[x][z]=0;
			}
		}
		
		boy_h=new int[50];
		girl_h=new int[50];
		boy_z=new int[50];
		girl_z=new int[50];
		
		girl2_h=new int[50];
		girl2_z=new int[50];
		
		history=new String[5101];
		his_n=0;
		
		boy_n=0;
		girl_n=0;
		father=fa;
		
		found_year=a15.a1.year;
		
		if(father>-1)
		{
			language_f=a15.a1.tr[father].language_f;
			language_gf=a15.a1.tr[father].language_gf;
			violence=a15.a1.tr[father].violence;
			
			for(int i=0;i<3;i++)
			{
				culture[i]=a15.a1.tr[father].culture[i];
			}
			
			if((int)(Math.random()*142127)%5==1)
			{
				violence=violence-10+(int)(Math.random()*142127)%21;
			}
			
			if((int)(Math.random()*132127)%5==1)
			{
				change_cl();
			}
			

			set_cl();
			
		}
		
		
		
	}
	
	
	void addp(int k)
	{
		pop[pn]=k;
		pn++;
		allp++;
		
		if(pn>4990)
		{
			for(int z=3000;z<pn;z++)
			{
				pop[z-2000]=pop[z];
			}
			pn-=2000;
		}
		
	}

	void change_cl()
	{
		gl=(int)(Math.random()*142127)%3;
		g=(int)(Math.random()*133127)%a15.a1.culture_n;
		
		while(true)
		{
			if(violence<30&&(g==3||g==9)) {}
			else if(culture[(gl+1)%3]!=g&&culture[(gl+2)%3]!=g)
			{
				break;
			}
			g=(g+1)%a15.a1.culture_n;
		}
		culture[gl]=g;
		set_cl();
	}
	
	void set_cl()
	{
		for(int z=0;z<15;z++)
		{
			cl0[z]=false;
		}
		for(int z=0;z<3;z++)
		{
			cl0[culture[z]]=true;
		}
		if((cl0[3]==true||cl0[4]==true)&&violence<40)
		{
			violence=40;
		}
		//cl0[11]=true;//
	}
	
	void choose_leader()
	{
		
		
		
		int old=leader;
		int gn=0;
		int gh=0;
		for(int x=0;x<225;x++)
		{
			if(house_n[x]<=0||house[x][0]==old)
				continue;
			
			gg=0;
			if(a15.a1.b[house[x][0]].sex==tsex&&a15.a1.b[house[x][0]].age()>=15)
			{
				
				if(a15.a1.b[house[x][0]].age()<=45)
					gg+=a15.a1.b[house[x][0]].age()+(a15.a1.b[house[x][0]].strong+a15.a1.b[house[x][0]].smart())/2-ab(a15.a1.b[house[x][0]].violence()-violence);
				else
					gg+=50*2+(a15.a1.b[house[x][0]].strong+a15.a1.b[house[x][0]].smart())/2-ab(a15.a1.b[house[x][0]].violence()-violence);
			
				
				if(a15.a1.b[house[x][0]].age()<=20)
					gg-=100;
				else if(a15.a1.b[house[x][0]].age()<=25)
					gg-=50;
				else if(a15.a1.b[house[x][0]].age()<=30)
					gg-=25;
				
				
				if(a15.a1.b[house[x][0]].fa==old)
				{
					gg+=100;
				}
			}
			else {
				gg=a15.a1.b[house[x][0]].age()/2;
			}
			if(gg>gn)
			{
				gn=gg;
				gh=x;
			}
			
			
			
		}
		leader=house[gh][0];
		
	}
	
	void newtribe(int vio)
	{
		int id;
		violence=vio;
		for(int i=0;i<225;i++)
			house_n[i]=0;
		
		
		for(int i=0;i<125;i++)
		{
			id=a15.a1.addman(1, 15,i,this_k);
			house[i][0]=id;
			//h_leader[i]=id;
			
			id=a15.a1.addman(0, 15,i,this_k);
			house[i][1]=id;
			
			house_n[i]=2;
			
			for(int j=2;j<2;j++)
			{
				id=a15.a1.addkid(house[i][0],house[i][1]);
				house[i][j]=id;
				house_n[i]++;
				
				a15.a1.b[house[i][0]].addkid(id);
				a15.a1.b[house[i][1]].addkid(id);
			}
			
			a15.a1.b[house[i][0]].wi=house[i][1];
			a15.a1.b[house[i][1]].wi=house[i][0];
			
			a15.a1.b[house[i][0]].add_wir(house[i][1]);
			a15.a1.b[house[i][1]].add_wir(house[i][0]);
			
			
		}
		culture[0]=-1;
		culture[1]=-1;
		culture[2]=-1;
		
		t=0;
		for(int y=0;y<3;y++)
		{
			g=(int)(Math.random()*17327)%a15.a1.culture_n;
			while(true) {
				t=1;
				for(int i=0;i<y;i++)
				{
					if(g==culture[i])
						t=-1;
				
				}
				if(violence<40&&(g==3||g==9)) {}
				else if(t==1) 
				{
					culture[y]=g;
					break;
				}
				g=(g+1)%a15.a1.culture_n;
			}
		}
		
		set_cl();
	
		
		
	}
	
	
	
	
	
	int food=0;
	void count_food0()
	{
		for(int x=ax-2;x<=ax+2;x++)
		{
			if(x<0||x>=a15.a1.xlong)continue;
			for(int z=ay-2;z<=ay+2;z++)
			{
				if(z<0||z>=a15.a1.ylong)continue;
				
				
				a15.a1.mapf[x][z]+=((n-kid_n)+kid_n/2);		
			}
		}
	}
	
	void count_food1()
	{
		food=10;int base=10;
		for(int x=ax-2;x<=ax+2;x++)
		{
			if(x<0||x>=a15.a1.xlong)continue;
			for(int z=ay-2;z<=ay+2;z++)
			{
				if(z<0||z>=a15.a1.ylong||a15.a1.bigmap[x][z]!=1)continue;
				
				base=20;
				if(a15.a1.landmap[x][z]==2||a15.a1.landmap[x][z]==3)
					base=40;
				
				if(cl0[0]==true)//齋戒禁食
				{
					base=base*120/100;
				}
				if(cl0[1]==true)//節食
				{
					base=base*130/100;
				}
		
				
				if(a15.a1.mapf[x][z]>0)
				food+=base*((n-kid_n)+kid_n/2)/a15.a1.mapf[x][z];	
				else food+=base;
			}
		}
		
		if(cl0[2]==true)//食人
		{
			food+=n/20;
		}
	}
	
	
	int vio()
	{
		int fg=(violence+a15.a1.b[leader].violence()+pressure)/2;
		if(fg>100)fg=100;
		if(fg<0)fg=0;
		
		return fg;
	}
	
	int power()
	{
		return man_n;
	}
	
	int real_power()
	{
		int p=0;
		for(int z=0;z<225;z++)
		{
			for(int i=0;i<house_n[z];i++)
			{
				if(a15.a1.b[house[z][i]].sex==1&&a15.a1.b[house[z][i]].age()>=15)
				{

					p+=a15.a1.b[house[z][i]].strong+50;
				}
				
			}
		}
		
		p=p*(a15.a1.b[leader].smart()/2+violence/5+100);
		p=p*(115-(int)(Math.random()*172127)%30)/100;	
		

		return p;
	}
	
	int war_kill(int st,String r)
	{
		int p=0;
		
		int ss=100+st;
		if(ss<30)ss=30;
		
		for(int z=0;z<225;z++)
		{
			for(int i=0;i<house_n[z];i++)
			{
				if(a15.a1.b[house[z][i]].sex==1&&a15.a1.b[house[z][i]].age()>=14)
				{
					
					if((int)(Math.random()*17127)%(ss)<20)
					{
						die(z,i,r);
						i--;
						p++;
					}
					
				}
				
			}
		}
		


		return p;
	}
	
	
	void count_pressure()
	{
		count_food1();
		
		// System.out.println("ax="+ax+" ay="+ay+" \n");

		//food/=2;
		
		if(food>=(n-kid_n)+(kid_n)/2)
		pressure=0;
		else 
		{
			pressure=((n-kid_n)+(kid_n)/2-food)*100/food;
			
		}
		
		if(hn>180)	
		{
			pressure+=(hn-180);
		}
		
		
	}
	
	void try_kid(int fa,int ma,int h)
	{
		int id=0;
		
		g=a15.a1.b[fa].trait[0]%15+4;
		if(a15.a1.b[fa].gene[0])
			g+=3;
		if(a15.a1.b[fa].gene[1])
			g+=3;
		if(a15.a1.b[fa].gene[2])
			g+=3;
		
		g+=a15.a1.b[ma].trait[0]%15+4;
		
		if(a15.a1.b[ma].gene[0])
			g+=3;
		if(a15.a1.b[ma].gene[1])
			g+=3;
		if(a15.a1.b[ma].gene[2])
			g+=3;
		
		if(g>=30)g+=15;
		
		if(cl0[6]==true)//禁慾
			g-=10;
		
		if(cl0[7]==true)//性開放
			g+=10;
		if(cl0[8]==true)//生殖崇拜
			g+=5;

		
		
		if(a15.a1.b[ma].age()>=30)
		{
			g-=(a15.a1.b[ma].age()-29)*3;
		}
		if(a15.a1.b[ma].age()>=39)
		{
			g-=(a15.a1.b[ma].age()-30)*3;
		}
		if(a15.a1.b[fa].age()>=45)
		{
			g-=(a15.a1.b[fa].age()-44)*2;
		}
		if(a15.a1.b[ma].age()>=45||a15.a1.b[fa].trait[0]%30==0||a15.a1.b[ma].trait[0]%30==0)
		{
			g=-100;
		}
		
		if((int)(Math.random()*133127)%80<g)
		{
			id=a15.a1.addkid(fa, ma);
			addp(id);
			
			house[h][house_n[h]]=id;
			house_n[h]++;
			
			if(cl0[5]==true&&pressure>=20&&a15.a1.b[fa].count_descendants(fa, 1, 1)>=2&&(int)(Math.random()*133127)%9<1+pressure/20)
			{
				die(h,house_n[h]-1,"出生後被殺(殺嬰)");
			}
		}
		
	}
	
	
	int ab(int gg)
	{
		if(gg<0) return gg*(-1);
		return gg;
	}
	
	int t_distance(int k,int k2)
	{
		int gg=ab(a15.a1.tr[k].ax-a15.a1.tr[k2].ax)+ab(a15.a1.tr[k].ay-a15.a1.tr[k2].ay);
		return gg;	
	}
	
	int search_tr()
	{
		for(int x=ax-2;x<=ax+2;x++)
		{
			if(x<0||x>=a15.a1.xlong)continue;
			
			if((int)(Math.random()*172127)%2==1) {
			
				for(int z=ay+1;z<=ay+2;z++)
				{
					if(z<0||z>=a15.a1.ylong||a15.a1.bigmap[x][z]<10)continue;
					gg=	a15.a1.bigmap[x][z]-10;
					if(gg==this_k||a15.a1.tr[gg].live<0)continue;
				
					if(t_distance(this_k,gg)<=5&&(int)(Math.random()*172127)%5==x%5)
						return gg;			
				}		
			}
			else {
				
				for(int z=ay-1;z>=ay-2;z--)
				{
					if(z<0||z>=a15.a1.ylong||a15.a1.bigmap[x][z]<10)continue;
					gg=	a15.a1.bigmap[x][z]-10;
					if(gg==this_k||a15.a1.tr[gg].live<0)continue;
				
					if(t_distance(this_k,gg)<=5&&(int)(Math.random()*172127)%5==x%5)
						return gg;			
				}		
			}
		}
		return -1;
	
	}
	
	int war(int enemy)
	{
		int p=real_power()+10;
		int mp=a15.a1.tr[enemy].real_power()+10;
		
		
		
	
		
		p=(p-mp)*100/mp;
		return p;
		
	
	}
	void tdie()
	{
		n=0;
		hn=0;
		man_n=0;
		kid_n=0;
		live=-1;
		die_year=a15.a1.year;
		
	}
	
	
	void set_this()//部落新建
	{
		choose_leader();
		
		if(father!=-1)
			addhis(name+"部落從"+a15.a1.tr[father].name+"部落分離成立，"+a15.a1.b[leader].fullname()+"成為首任部落首領，時年"+a15.a1.b[leader].age()+"歲");
		else
		addhis(name+"部落成立，"+a15.a1.b[leader].fullname()+"成為首任部落首領，時年"+a15.a1.b[leader].age()+"歲");
		
		int id=0;
		for(int x=0;x<225;x++)
		{
			if(house_n[x]<=0)continue;
			for(int z=0;z<house_n[x];z++)
			{
				id=house[x][z];
				addp(id);
			}
				
				
		}
	}
	
	void event()
	{
		if(his_n==0)//部落新建
		{
			set_this();
			return;
		}
		
		
		int xx,yy,nt;
		
		
		if(vio()>20&&man_n>=20&&(int)(Math.random()*14271)%1000<(vio()+pressure)&&(int)(Math.random()*17231)%29==1)//內戰
		{
			g=war_kill(0,"內戰戰死");
			if(vio()>=50)	
				g+=masskill(6-vio()/20,"部落內戰受戮");

			addhis("部落內戰，死亡"+g+"人，內戰前部落總人口"+n+"人");
			
			if((int)(Math.random()*17271)%2==1)
			{
				die(a15.a1.b[leader].house,0,"部落內戰");
			}
			
			return;
		}
		

		gk=search_tr();
		
		if(gk>-1&&(vio()>=10))// 部落戰爭
		{
			
			int m1=power();
			int m2=a15.a1.tr[gk].power();
			
			g2=(m1-m2)*100/(m2+1);
			
			int ln=0,lp=0;
			if(a15.a1.tr[gk].hn+hn<=180&&m1>=m2*3&&a15.a1.tr[gk].hn<=25-vio()/5-pressure/10&&m2<=20-vio()/5-pressure/10)
			{
				for(int x=0;x<225;x++)
				{
					if(house_n[x]>0)continue;
					for(int z=0;z<225;z++)
					{
						if(a15.a1.tr[gk].house_n[z]<=0)continue;
						house_n[x]=a15.a1.tr[gk].house_n[z];
						for(int i=0;i<a15.a1.tr[gk].house_n[z];i++)
						{
							house[x][i]=a15.a1.tr[gk].house[z][i];
							lp++;
						}
						a15.a1.tr[gk].house_n[z]=0;
						ln++;
						break;
					}
				}
				addhis("合併"+a15.a1.tr[gk].name+"部落，增加"+ln+"戶"+lp+"人");
				
				a15.a1.tr[gk].addhis("被"+name+"部落併吞，"+a15.a1.tr[gk].name+"部落滅亡");
				a15.a1.tr[gk].tdie();
				
				
				return;
			}
			
			
			if(man_n>=20&&(int)(Math.random()*17271)%300<(vio()+pressure)&&(int)(Math.random()*13371)%250<(g2+20+pressure/2))
			{
				int die=0,die2=0,bm=0;
				
				int pow=war(gk);
				
				die=war_kill(pow,"戰死");
				die2=a15.a1.tr[gk].war_kill(-pow,"戰死");
				
				if(pow>0) {
					if(vio()>=40) {
						int vv=6-(vio())/20;
						if(vv<1)vv=1;
						bm=a15.a1.tr[gk].masskill(vv,"被敵對部落屠戮");
					}
					addhis("攻擊"+a15.a1.tr[gk].name+"部落，戰勝，戰死"+die+"人，殺敵"+die2+"人，減損敵方"+bm+"人 ("+m1+"vs"+m2+")優勢:"+pow);
					
					a15.a1.tr[gk].addhis("受"+a15.a1.tr[this_k].name+"部落襲擊，戰敗，戰死"+die2+"人，殺敵"+die+"人，被敵屠戮"+bm+"人 ("+m2+"vs"+m1+")優勢:"+(-pow));
				}
				else {
					addhis("攻擊"+a15.a1.tr[gk].name+"部落，戰敗，戰死"+die+"人，殺敵"+die2+"人 ("+m1+"vs"+m2+")優勢:"+pow);
					a15.a1.tr[gk].addhis("受"+a15.a1.tr[this_k].name+"部落襲擊，成功抵禦，戰勝，戰死"+die2+"人，殺敵"+die+"人 ("+m2+"vs"+m1+")優勢:"+(-pow));
					
					
				}
				return;
			}
			
			
			
		}
		
		if(gk>-1&&cl0[9]==true&&man_n>=10)// 獵首
		{
			int m1=power();
			int m2=a15.a1.tr[gk].power();
			int v=vio()/25;
			if(v>4)v=4;
			
			
			if(m1*3>=m2*2&&(int)(Math.random()*17271)%(8-v)==1)
			{
				int pow=war(gk);
				int die=0,die2=0;
				
				die=war_kill(pow+200,"獵首時戰死");
				
				
				if(pow-20+(int)(Math.random()*17471)%40>0) {
					
					die2=a15.a1.tr[gk].masskill(8+a15.a1.tr[gk].n/50,"被敵對部落獵首");
				}
				
				addhis("前往"+a15.a1.tr[gk].name+"部落獵首，戰死"+die+"人，獵取敵方首級"+die2+"顆 ("+m1+"vs"+m2+")優勢:"+pow);
				a15.a1.tr[gk].addhis("被"+name+"部落入侵獵首，己方"+die2+"人被殺，殺敵"+die+"人 ("+m2+"vs"+m1+")優勢:"+(-pow));
				
				return;
			}
			
			
		}
		
		
		if(gk>-1&&cl0[11]==true&&man_n>=10)// 強掠人口
		{
			int m1=power();
			int m2=a15.a1.tr[gk].power();
			int v=vio()/25;
			if(v>4)v=4;
			
			
			if(m1*3>=m2*2&&(int)(Math.random()*17271)%(8-v)==1)
			{
				int pow=war(gk);
				int die=0,die2=0;
				
				die=war_kill(pow+200,"掠奪敵部落時戰死");
							
				if(pow-20+(int)(Math.random()*17471)%40>0) {
					
					die2=0;
					
					int w=a15.a1.b[leader].smart()+pow;
					
					if(w>200)w=200;
					if(m2>=20&&w>150)w=150;
					
					for(int z=0;z<225;z++)
					{
						if(house_n[z]<=0||a15.a1.b[house[z][0]].sex!=1||a15.a1.b[house[z][0]].age()<15)
							continue;
						for(int i=0;i<a15.a1.tr[gk].house_n[z];i++)
						{
							if(a15.a1.b[a15.a1.tr[gk].house[z][i]].sex==1&&a15.a1.b[a15.a1.tr[gk].house[z][i]].age()>7)
								continue;
							
							if(a15.a1.b[a15.a1.tr[gk].house[z][i]].age()>=30)
								continue;
							
							if((int)(Math.random()*17471)%(10+pressure/10-w/25)!=1)
								continue;
							
							gg=a15.a1.tr[gk].house[z][i];
							
							house[z][house_n[z]]=gg;
							house_n[z]++;
							addp(gg);
							
							a15.a1.b[gg].tr=this_k;
							a15.a1.tr[gk].remove(z, i);
							
							if(a15.a1.b[gg].wi>0) {
								q=a15.a1.b[gg].wi;
								a15.a1.b[q].wi=-1;
								a15.a1.b[gg].wi=-1;		
							}
							die2++;
							
						}
					}
				}
				
				addhis("前往"+a15.a1.tr[gk].name+"部落掠奪人口，戰死"+die+"人，共掠奪"+die2+"人 ("+m1+"vs"+m2+")優勢:"+pow);
				a15.a1.tr[gk].addhis("被"+name+"部落入侵掠奪，己方"+die2+"人被掠，殺敵"+die+"人 ("+m2+"vs"+m1+")優勢:"+(-pow));
				
				return;
			}
			
			
		}

		
		
		
		if(cl0[3]==true&&man_n>=15&&n>=50&&((found_year+a15.a1.year)%10==4||(int)(Math.random()*123171)%33==1)&&(int)(Math.random()*173171)%7>=1)//人祭
		{
			human_sacrifice();
			return;
		}
		
		if((int)(Math.random()*173171)%107==1)
		{
			xx=ax;
			yy=ay;
			if((int)(Math.random()*17271)%2==1)
				xx=ax+(int)(Math.random()*17271)%3-1;
			else yy=ay+(int)(Math.random()*17271)%3-1;
			
			if(xx<0||xx>=a15.a1.xlong)return;
			if(yy<0||yy>=a15.a1.ylong)return;
			
			if(a15.a1.bigmap[xx][yy]==1) {
				a15.a1.bigmap[ax][ay]=1;
				a15.a1.bigmap[xx][yy]=10+this_k;
				ax=xx;ay=yy;
			}
			
			return;
		}
		
		if(n>400&&(man_n>=150||hn>=200)&&hn>=30&&(int)(Math.random()*17371)%3==1)// create_tri
		{
			if((int)(Math.random()*17271)%2==1)
			xx=ax-2;
			else xx=ax+2;
			
			if((int)(Math.random()*17331)%2==1)
			yy=ay-2;
			else yy=ay+2;
			
			
			if(xx<0||xx>=a15.a1.xlong)return;
			if(yy<0||yy>=a15.a1.ylong)return;
			
			int nn=0,mn=0;
			if(a15.a1.bigmap[xx][yy]==1)// 釋放分支部落
			{
				nt=a15.a1.trn;
				a15.a1.tr[nt]=new tribe(nt,a15.n1.tri_name(),xx,yy,this_k);
				
				a15.a1.bigmap[xx][yy]=10+nt;
				
				gg=0;
				for(int z=(hn/2);z<225;z++)
				{
					if(house_n[z]==0)continue;
					
					a15.a1.tr[nt].house_n[gg]=house_n[z];
					nn+=house_n[z];
					for(int i=0;i<house_n[z];i++) {
						a15.a1.tr[nt].house[gg][i]=house[z][i];
						a15.a1.b[house[z][i]].tr=nt;
						if(a15.a1.b[house[z][i]].sex==1&&a15.a1.b[house[z][i]].age()>=14)
							mn++;
					}
					house_n[z]=0;
					gg++;
				}
				a15.a1.tr[nt].hn=gg;
				a15.a1.tr[nt].n=nn;
				a15.a1.tr[nt].man_n=mn;
				
				addhis("分出分支部落 "+a15.a1.tr[nt].name);

				
				a15.a1.trn++;
			}
		}
		
	}
	
	
	
	
	void newyear()
	{
		int w,id;
		
	
		if(n==0&&a15.a1.year>found_year+1) {
			
			if(live>0)
			{
				tdie();
				addhis(name+"部落滅亡");
			}
			live=-1;
			return;
		}
		if(a15.a1.b[leader].live<0||a15.a1.b[leader].tr!=this_k)
		{
			choose_leader();
		}
		
		count_pressure();
		
		event();
		
		
		int gh,gi;
		
		
		int g0=0;
		for(int z=0;z<225;z++)
		{
			for(int i=0;i<house_n[z];i++)
			{
				if(a15.a1.b[house[z][i]].live<0)
				{
					//System.out.print("Eerror i="+i+" n="+house_n[z]+" "+a15.a1.b[house[z][i]].dieyear+"\n");  
					remove(z,i);
				}
				else
				trydie(z,i);
			}
		}
		
		n=0;hn=0;man_n=0;kid_n=0;
		boy_n=0;girl_n=0;girl2_n=0;
		
		for(int z=0;z<225;z++)
		{
			if(house_n[z]<=0)
				continue;		
			
			hn++;
			
			if(a15.a1.b[house[z][0]].wi>-1)
			{
				if(a15.a1.b[house[z][0]].sex==1)
				 try_kid(house[z][0],a15.a1.b[house[z][0]].wi,z);
				else {
					 try_kid(a15.a1.b[house[z][0]].wi,house[z][0],z);
				}
			}		
			n+=house_n[z];			
		}
		
		for(int z=0;z<225;z++)
		{
			for(int i=0;i<house_n[z];i++)
			{
				if(a15.a1.b[house[z][i]].sex==1&&a15.a1.b[house[z][i]].age()>=15)
					man_n++;
				if(a15.a1.b[house[z][i]].age()<15)
					kid_n++;
			}
		}
		
		
		
		
		if((int)(Math.random()*17274)%3==1){
			
		
		for(int z=0;z<50;z++)
		{
			girl_h[z]=0;
			girl_z[z]=0;
			boy_z[z]=0;
			boy_h[z]=0;
			girl2_h[z]=0;
			girl2_z[z]=0;
		}
		
		
		
		for(int z=0;z<225;z++)
		{
			for(int i=1;i<house_n[z];i++)
			{
				if(house[z][i]==a15.a1.b[house[z][0]].wi)continue;
				
				if(a15.a1.b[house[z][i]].age()>=15&&(int)(Math.random()*(111113))%2==1)
				{
					if(a15.a1.b[house[z][i]].sex==1&&boy_n<49)
					{
						boy_h[boy_n]=z;
						boy_z[boy_n]=i;
						boy_n++;
					}
					else if(a15.a1.b[house[z][i]].sex!=tsex&&a15.a1.b[house[z][i]].age()<=35&&girl2_n<20&&(int)(Math.random()*(33113))%4==1)
					{
						girl2_h[girl2_n]=z;
						girl2_z[girl2_n]=i;
						girl2_n++;
					}
					else if(a15.a1.b[house[z][i]].sex==0&&a15.a1.b[house[z][i]].age()<=30&&girl_n<49)
					{
						girl_h[girl_n]=z;
						girl_z[girl_n]=i;
						girl_n++;
					}
				}
				
			}
		
		}
		

		g0=0;
		for(int z=0;z<225;z++)
		{
			if(g0==girl2_n)break;
			
			if(a15.a1.b[house[z][0]].sex==tsex&&a15.a1.b[house[z][0]].wi==-1&&z!=girl2_h[g0])
			{
				a15.a1.b[house[z][0]].wi=house[girl2_h[g0]][girl2_z[g0]];
				a15.a1.b[house[z][0]].add_wir(house[girl2_h[g0]][girl2_z[g0]]);
				
				a15.a1.b[house[girl2_h[g0]][girl2_z[g0]]].wi=house[z][0];
				a15.a1.b[house[girl2_h[g0]][girl2_z[g0]]].add_wir(house[z][0]);
				
				house[z][house_n[z]]=house[girl2_h[g0]][girl2_z[g0]];
				house_n[z]++;
				
				remove(girl2_h[g0],girl2_z[g0]);
				
				g0++;
			}
		
		}
		int gn=0;
		
		for(int z=0;z<225;z++)// 換家主
		{
			if(house_n[z]<=0||a15.a1.b[house[z][0]].sex==1&&a15.a1.b[house[z][0]].age()<55&&leader!=house[z][0])
				continue;
			
			for(int i=1;i<house_n[z];i++)
			{
				if(a15.a1.b[house[z][i]].sex==1)
				{
					gg=house[z][i];
					house[z][i]=house[z][0];
					house[z][0]=gg;
				}
			}
			if(a15.a1.b[house[z][0]].sex==0&&a15.a1.b[house[z][0]].age()<=35&&boy_n>0)
			{
				g=boy_n-1;
				gn=house_n[z];
				
				//System.out.print("marry z="+z+" "+a15.a1.b[house[z][0]].name+" "+a15.a1.b[house[boy_h[g]][boy_z[g]]].name+"\n");  
				
				house[z][gn]=house[boy_h[g]][boy_z[g]];

				
				a15.a1.b[house[boy_h[g]][boy_z[g]]].house=z;
		
				
				a15.a1.b[house[z][0]].wi=house[boy_h[g]][boy_z[g]];
				a15.a1.b[house[boy_h[g]][boy_z[g]]].wi=house[z][0];
				
				a15.a1.b[house[z][0]].add_wir(house[boy_h[g]][boy_z[g]]);
				a15.a1.b[house[boy_h[g]][boy_z[g]]].add_wir(house[z][0]);
				
				house_n[z]++;
				
				remove(boy_h[g],boy_z[g]);
				boy_n--;
				
			}
		
		}
		
		gh=-1;
		for(int y=0;y<boy_n;y++)
		{
			gh=-1;
			for(int z=y;z<boy_n;z++)
			{
				
				if(gh==-1||(a15.a1.b[house[boy_h[z]][boy_z[z]]].strong>a15.a1.b[house[boy_h[gh]][boy_z[gh]]].strong))
				{
					gh=z;
				}
			}
			gg=boy_h[y];
			gi=boy_z[y];

			boy_h[y]=boy_h[gh];
			boy_z[y]=boy_z[gh];
			
			boy_h[gh]=gg;
			boy_z[gh]=gi;			
		}
		
		gh=-1;
		for(int y=0;y<girl_n;y++)
		{
			gh=-1;
			for(int z=y;z<girl_n;z++)
			{
				
				if(gh==-1||(a15.a1.b[house[boy_h[z]][boy_z[z]]].look>a15.a1.b[house[boy_h[gh]][boy_z[gh]]].look))
				{
					gh=z;
				}
			}
			gg=girl_h[y];
			gi=girl_z[y];

			girl_h[y]=girl_h[gh];
			girl_z[y]=girl_z[gh];
			
			girl_h[gh]=gg;
			girl_z[gh]=gi;			
		}
		
		
		for(int y=0;;y++)
		{
			if(hn>222)break;
			
			
			if(y>=boy_n||y>=girl_n)break;
			
			if(boy_h[y]!=girl_h[y])
			{
				for(int i=0;i<225;i++)
				{
					if(house_n[i]<=0)
					{
						house[i][0]=house[boy_h[y]][boy_z[y]];
						house[i][1]=house[girl_h[y]][girl_z[y]];
						
						a15.a1.b[house[boy_h[y]][boy_z[y]]].house=i;
						a15.a1.b[house[girl_h[y]][girl_z[y]]].house=i;
						
						a15.a1.b[house[i][0]].wi=house[i][1];
						a15.a1.b[house[i][1]].wi=house[i][0];
						
						a15.a1.b[house[i][0]].add_wir(house[i][1]);
						a15.a1.b[house[i][1]].add_wir(house[i][0]);
						
						
						house_n[i]=2;
						
						remove(boy_h[y],boy_z[y]);
						remove(girl_h[y],girl_z[y]);
						
						break;
						
					}
				}
			}
		}
		
		}
		
		

		

	}
	
	void remove(int h,int i)
	{
		for(int x=i;x<house_n[h]-1;x++)
		{
			house[h][x]=house[h][x+1];
		}
		house_n[h]--;

	}
	
	void trydie(int h,int i)
	{
		int kk=house[h][i];
		gg=200+a15.a1.b[kk].health-pressure*150/100;
		if(gg<=10)gg=10;
		
		String r="病死";
		if(a15.a1.b[kk].age()<2)
		{
			if((int)(Math.random()*11127)%gg<120&&(int)(Math.random()*11127)%2==1)
			 die(h,i,r);
		}
		else if(a15.a1.b[kk].age()<8)
		{
			if((int)(Math.random()*11127)%gg<30&&(int)(Math.random()*11127)%2==1)
			 die(h,i,r);
		}
		else if(a15.a1.b[kk].age()<50)
		{
			if((int)(Math.random()*11127)%gg<20&&(int)(Math.random()*13327)%6==1)
			 die(h,i,r);
		}
		else if(a15.a1.b[kk].age()<60)
		{
			if((int)(Math.random()*11127)%gg<20&&(int)(Math.random()*11327)%2==1)
			 die(h,i,r);
		}
		else if(a15.a1.b[kk].age()<70)
		{
			if((int)(Math.random()*11127)%gg<60&&(int)(Math.random()*11327)%2==1)
			 die(h,i,r);
		}
		else if(a15.a1.b[kk].age()<80)
		{
			if((int)(Math.random()*11127)%gg<90)
				 die(h,i,r);
		}
		else {
			if((int)(Math.random()*11127)%gg<150)
				 die(h,i,r);
		}
	}
	void addhis(String y)
	{
		//if(his_n>=10100)return;
		
		history[his_n]="第"+a15.a1.year+"年: "+y;
		his_n++;
	}
	
	void die(int h,int i,String r)
	{
		
		a15.a1.b[house[h][i]].die(r);
		if(house[h][i]==leader)
		{
			choose_leader();
			
			addhis("部落首領"+a15.a1.b[house[h][0]].fullname()+"逝世，"+a15.a1.b[leader].fullname()+"成為新任首領，時年"+a15.a1.b[leader].age()+"歲");
		}
		q=a15.a1.b[house[h][i]].wi;
		if(cl0[4]==true&&i==0&&a15.a1.b[house[h][i]].sex==1&&a15.a1.b[house[h][i]].wi>0&&a15.a1.b[q].live>0)
		{
			
			remove(h,i);
			for(int z=0;z<house_n[h];z++)
			{
				if(house[h][z]==q)
				{
					die(h,z,"殉葬");
					break;
				}
			}
		}
		else if(cl0[10]==true&&i==0&&a15.a1.b[house[h][i]].sex==1&&a15.a1.b[house[h][i]].wi>0&&a15.a1.b[q].live>0&&(int)(Math.random()*(11211))%2==1&&a15.a1.b[q].count_descendants(q, 1, 1)<=0)
		{
			remove(h,i);
			for(int z=0;z<house_n[h];z++)
			{
				if(house[h][z]==q)
				{
					die(h,z,"自盡殉葬");
					break;
				}
			}
		}
		else {
		remove(h,i);
		}
		
	}
	
	int masskill(int level,String r)
	{
		int nn=0;
		for(int x=0;x<225;x++)
		{
			for(int z=0;z<house_n[x];z++)
			{
				if(house[x][z]==leader) continue;
				
				
				if((int)(Math.random()*17227)%(level+1)<1 && a15.a1.b[house[x][z]].sex==1 && a15.a1.b[house[x][z]].age()>14)
				{
					die(x,z,r);nn++;
					z--;
				}
				else if((int)(Math.random()*17227)%(level*2+1)<1 &&( a15.a1.b[house[x][z]].sex==0 || a15.a1.b[house[x][z]].age()<=14))
				{
					die(x,z,r);nn++;
					z--;
				}
				
				
				
			}
		}
		return nn;
	}
	
	
	
	void human_sacrifice()
	{
		int sf[]= {-1,-1,-1};int sn=0;
		
		for(int i=0;i<10000;i++)
		{
			g=(int)(Math.random()*1727)%225;	
			
			if(house_n[g]<=0)continue;
			if(sf[(sn+1)%3]==g||sf[(sn+2)%3]==g)
				continue;
			if(house[g][0]==leader)continue;
			
			sf[sn]=g;
			sn++;
			if(sn>=3)break;
		
			
		}
		
		String y="";
		for(int z=0;z<sn;z++)
		{
			gg=sf[z];
			y+=a15.a1.b[house[gg][house_n[gg]-1]].fullname()+"("+a15.a1.b[house[gg][house_n[gg]-1]].sex()+","+a15.a1.b[house[gg][house_n[gg]-1]].age()+"歲)";
		}
		
		addhis("部落舉行人祭，獻祭"+y);
		
		for(int z=0;z<sn;z++)
		{
			gg=sf[z];
			die(gg,house_n[gg]-1,"被部落殺死獻祭");
		}
	}
	

}
