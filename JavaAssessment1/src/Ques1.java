import java.util.*;
public class Ques1 {
    static int p = 10000;
    static Boolean arr[] = new Boolean[p];
    public static void main(String s[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrays.fill(arr,true);
        arr[0]=true;
        for(int i = 2;i<p;i++)
        {
            if(arr[i]==true)
            {
                for(int j = 2;j<p;j++)
                {
                    if(i<(p/j))
                    {
                        arr[i*j]=false;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        computePrimeFactors(n);
    }
    public static void computePrimeFactors(int num)
        {
            int numcop = num-1;
            while(num>0)
            {
                if(arr[numcop])
                {
                    System.out.print(numcop+"+");
                    num=num-numcop;
                    numcop = num;

                }
                else{
                    numcop--;
                }
            }



        }
    }

