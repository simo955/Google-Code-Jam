import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String[] args) throws Exception{ new Solution(new Reader()); }
	public Solution(Reader rr) throws IOException{
		int T=rr.ni();
		for(int t=1; t<=T; t++) {
			int n=rr.ni(), l=rr.ni();
			int num=100, den=n, addend=0;
			addend=num/den;
			num%=den;
			if(num==0) {
				System.out.println("Case #"+t+": "+100);
				for(int i=0; i<l; i++) rr.ni();
				continue;
			}
			int maxAdd=0;
			if(((double)num)<((double)den)/2) {
				maxAdd=(int)Math.ceil((((double)den)/2)/((double)num));
			}else maxAdd=1;
			int ans=0;
			int[] tnums=new int[l];
			int left=n;
			for(int i=0; i<l; i++) {
				int p=rr.ni();
				left-=p;
				int tnum=p*100;
				ans+=tnum/den;
				tnum%=den;
				tnums[i]=tnum;
			}
			Arrays.sort(tnums);
			for(int i=l-1; i>=0; i--) {
				if((double)tnums[i]<((double)den)/2) {
					if(maxAdd==1) continue;
					else {
						int add=(int)Math.ceil(((((double)den)/2)-tnums[i])/((double)num));
						if(add>left) break;
						else left-=add;
						ans+=addend*add;
						ans++;
					}
				}else ans++;
			}
			while(left>0) {
				if(left>=maxAdd) {
					left-=maxAdd;
					ans+=addend*maxAdd;
					ans++;
				}else {
					ans+=addend*left;
					left=0;
				}
			}
			System.out.println("Case #"+t+": "+ans);
		}
	}
	static class Reader{
		private DataInputStream din;
		private byte[] buffer=new byte[1024];
		private int bufP, bytR;
		public Reader() throws IOException{
			din=new DataInputStream(System.in);
			bufP=bytR=0;
		}
		public Reader(String file) throws IOException{
			din=new DataInputStream(new FileInputStream(file));
			bufP=bytR=0;
		}
		private String rl() throws IOException{
			byte[] buf=new byte[1024];
			int cnt=0, c;
			while((c=read())!=-1){
				if(c=='\n') break;
				buf[cnt++]=(byte)c;
			}
			return new String(buf, 0, cnt);
		}
		private int ni() throws IOException{
			int num=0;
			byte c=read();
			while(c<=' ') c=read();
			boolean neg=(c=='-');
			if(neg) c=read();
			do{
				num=num*10+c-'0';
			} while((c=read())>='0'&&c<='9');
			if(neg) return -num;
			return num;
		}
		private long nl() throws IOException{
			long num=0;
			byte c=read();
			while(c<=' ') c=read();
			boolean neg=(c=='-');
			if(neg) c=read();
			do{
				num=num*10+c-'0';
			} while((c=read())>='0'&&c<='9');
			if(neg) return -num;
			return num;
		}
		private double nd() throws IOException{ return Double.parseDouble(ns()); }
		private char nc() throws IOException{ return (char)next(); }
		private String ns() throws IOException{
			int c=next();
			StringBuilder sb=new StringBuilder();
			while(!(isChar(c))){
				sb.appendCodePoint(c);
				c=read();
			}
			return sb.toString();
		}
		private char[] ns(int n) throws IOException{
			char[] buf=new char[n];
			int c=next(), r=0;
			while(r<n&&!(isChar(c))){
				buf[r++]=(char)c;
				c=next();
			}
			return n==r?buf:Arrays.copyOf(buf, r);
		}
		private char[][] nm(int n, int m) throws IOException{
			char[][] map=new char[n][];
			for(int i=0; i<n; i++) map[i]=ns(m);
			return map;
		}
		private int[] na(int n) throws IOException{
			int[] a=new int[n];
			for(int i=0; i<n; i++) a[i]=ni();
			return a;
		}
		private boolean isChar(int c) throws IOException{ return !(c>=33&&c<=126); }
		private int next() throws IOException{ int c; while((c=read())!=-1&&isChar(c)); return c; }
		private byte read() throws IOException{
			if(bufP==bytR){
				bytR=din.read(buffer, bufP=0, 1024);
				if(bytR==-1) buffer[0]=-1;
			}
			return buffer[bufP++];
		}
		public void close() throws IOException{
			if(din==null) return;
			din.close();
		}
	}
}
