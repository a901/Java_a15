package a;

import java.util.Vector;

public class B {
	
	
	
	String name,midname,surname;
	
	int fa,ma,wi=-1,sex=0,bornyear;//sex=1 man sex=0 woman
	int dieyear=0;
	
	Vector kid;
	int kidn=0;
		
	boolean gene[];
	int gene_f,gene_m;
	
	int trait[];
	
	int house=-1;
	
	int strong=0;
	int look=0;
	int live=1;
	int health=0;
	
	int dieage=0;
	
	int count=0;
	int this_k=0;
	int tr=0;
	
	int wi_r[];
	short wi_r2[];
	int wi_rn=0;
	
	String die_reason;
	// gene[1]%5+gene[5]%5+trait[0]%13生育率
	
	// gene[2]%10+gene[8]%10+gene[12]%10+gene[18]%10強壯
	// gene[3]%10+gene[7]%10+gene[13]%10+gene[17]%10美麗
	// gene[4]%10+gene[6]%10+gene[14]%10+gene[16]%10健康
	
	// trait[3]%61+gene[31]%11 gene[32]%11 gene[33]%11 gene[34]%11=暴力
	
	// trait[4]%71+gene[41]%11 gene[42]%11 gene[43]%11 =智力
	

	
	int descendants_count[];
	int descendants_count_year[];
	B(int kk,String name0,String midname0, int sex0,int year,int f,int m,int hh,int tr0)
	{
		
		
		this_k=kk;
		name=name0;
		midname=midname0;
		
		tr=tr0;
		house=hh;
		
		sex=sex0;
		bornyear=year;
		fa=f;
		ma=m;
		wi=-1;
		live=1;
		
		kid=new Vector();
		
		//kid=new int[41];

		
		gene=new boolean[300];
		trait=new int[10];
		
		wi_r=new int[11];
		wi_r2=new short[11];
		
		descendants_count=new int[4];
		descendants_count_year=new int[4];
		
		if(fa>-1&&ma>-1)
		{
			for(int z=0;z<51;z++)
			{
				if((int)(Math.random()*(1127+z*fa+z))%2==1)
				{
					gene[z]=a15.a1.b[fa].gene[z];
				}
				else {
					gene[z]=a15.a1.b[ma].gene[z];
				}
			}
			gene_f=a15.a1.b[fa].gene_f;
			gene_m=a15.a1.b[ma].gene_m;			
			
		}
		else {
			for(int z=0;z<45;z++)
			{
					//gene[z]=(short) ((short)(Math.random()*(11127+z*1101))%31111);
			}
			gene_f=(short)kk;
			gene_m=(short)kk;
			
			for(int z=0;z<300;z++) {
				if(z%a15.a1.origin_trn==tr0)
					gene[z]=true;
				else
					gene[z]=false;		
			}				
		}
		
		for(int z=0;z<10;z++)
		{
			trait[z]=(int)(Math.random()*(1111123))%1010171;
		}
		
		strong=(int)(Math.random()*(15117))%101;
		look=(int)(Math.random()*(11137))%101;
		health=(int)(Math.random()*(11137))%101;
		
		
		
	}
	
	
	void add_wir(int h)
	{
		if(wi_rn>=10)
			return;
		
		wi_r[wi_rn]=h;
		wi_r2[wi_rn]=(short)age();
		wi_rn++;
	}
	
	
	
	void modify_cul()
	{
		if(a15.a1.tr[tr].cl0[0]==true)
		{
			health-=10;
			strong-=5;
		}
		if(a15.a1.tr[tr].cl0[1]==true)
		{
			health-=15;
			strong-=10;
		}
		
		if(a15.a1.tr[tr].cl0[6]==true)//禁慾
		{
			health+=5;
			strong+=5;
		}
		if(a15.a1.tr[tr].cl0[7]==true)//性開放
		{
			health-=5;
			strong-=5;
		}
		if(a15.a1.tr[tr].cl0[8]==true)//生殖崇拜
		{
			strong+=5;
		}
	}
	
	void addkid(int id)
	{
		kid.add(id);
			//kid[kidn]=id;
		kidn++;
	}
	
	

	int count_descendants(int start,int type,int v)
	{
		if(count>0) return 0;
		count=1;
		
		//if(descendants_count_year[type]==a15.a1.year)
			//return descendants_count[type];
		
		
		
		
		int n=0;
		if(live>-1&&v!=0&&start!=this_k)n++;
		
		for(int z=0;z<kidn;z++)
		{
			if(type==2||type==a15.a1.b[(int) kid.elementAt(z)].sex)
			{
				if(v==0)
				n+=a15.a1.b[(int) kid.elementAt(z)].count_descendants(start,type,v)+1;
				else {
					n+=a15.a1.b[(int)kid.elementAt(z)].count_descendants(start,type,v);
					
				}
				
			}
		}
		if(start==this_k) {
			clear();
			
		}
		descendants_count_year[type]=a15.a1.year;
		descendants_count[type]=n;
		
		return n;
	}
	
	
	void clear()
	{
		for(int z=0;z<a15.a1.bn;z++)
		{
			a15.a1.b[z].count=0;
		}
	}
	
	String fullname()
	{
		return name+"."+midname;
	}
	
	void die(String r)
	{
		if(wi>-1)
		{
			a15.a1.b[wi].wi=-1;
		}
		dieyear=a15.a1.year;
		
		dieage=a15.a1.year-bornyear;
		live=-1;
		die_reason=r;
	}
	
	
	int age()
	{
		if(live<=0) return dieage;
		else
		return a15.a1.year-bornyear;
	}
	
	int violence()
	{
		return trait[3]%101;
	}
	int smart()
	{
		return trait[4]%101; 
	}
	
	String sex() {
		if(sex==0)return "女";
		return "男";
	}
	
	

}
