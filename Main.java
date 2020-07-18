import java.util.*;
import java.io.*;
public class Main implements Runnable{
    FastScanner sc;
    PrintWriter pw;
    final class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 
        public long nlo() {
            return Long.parseLong(next());
        }
 
        public String next() {
            if (st.hasMoreTokens()) return st.nextToken();
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }
 
        public int ni() {
            return Integer.parseInt(next());
        }
 
        public String nli() {
            String line = "";
            if (st.hasMoreTokens()) line = st.nextToken();
            else try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (st.hasMoreTokens()) line += " " + st.nextToken();
            return line;
        }
 
        public double nd() {
            return Double.parseDouble(next());
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Thread(null,new Main(),"codeforces",1<<28).start();
    }
    public void run()
    {
        sc=new FastScanner();
        pw=new PrintWriter(System.out);
        solve();
        pw.flush();
        pw.close();
    }
    public long gcd(long a,long b)
    {
        return b==0L?a:gcd(b,a%b);
    }
    public long ppow(long a,long b,long mod)
    {
        if(b==0L)
        return 1L;
        long tmp=1;
        while(b>1L)
        {
            if((b&1L)==1)
            tmp*=a;
            a*=a;
            a%=mod;
            tmp%=mod;
            b>>=1;
        }
        return (tmp*a)%mod;
    }
    public  int gcd(int x,int y)
    {
        return y==0?x:gcd(y,x%y);
    }
    //////////////////////////////////
    /////////////  LOGIC  ///////////
    ////////////////////////////////

    public void solve() {
        int t=sc.ni();
        while(t-->0)
        {
            String s=sc.next();
            int[] frr=new int[26];
            for(int i=0;i<s.length();i++)
            frr[s.charAt(i)-'a']++;
            int z=25;
            int n=sc.ni();
            int[] brr=new int[n];
            for(int i=0;i<n;i++)
                brr[i]=sc.ni();
            char[] arr=new char[n];
            Arrays.fill(arr,'A');
            ArrayList<Integer> list=new ArrayList();
            while(list.size()<n&&z>=0)
            {
                ArrayList<Integer> com=new ArrayList();
                int y=0;
                if(list.size()==0)
                {
                    for(int i=0;i<n;i++)
                    if(brr[i]==0)
                    {y++;com.add(i);}
                }
                else
                {
                    for(int i=0;i<n;i++)
                    {
                        if(arr[i]!='A')
                        continue;
                        int tmp=0;
                        for(int x:list)
                        tmp+=Math.abs(i-x);
                        if(tmp==brr[i])
                        {y++;com.add(i);}
                    }
                }
                for(;z>=0;z--)
                if(frr[z]>=y)
                break;
               // pw.println(y+" "+z);
                for(int x:com)
                {
                    arr[x]=(char)(z+'a');
                    list.add(x);
                }
                z--;
            }
            pw.println(String.copyValueOf(arr));
        }
    }
}