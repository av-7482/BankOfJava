import java.util.*;
class pattern6
{
public static void main(String args[]) throws Exception
{
int i,j,k,l,m=1;
for(i=0;i<16;i+=4)
{
for(j=i;j<=10;j+=2)
{
System.out.print(" ");
}
for(k=-1;k<i;k++)
{
if(k%2==0)
{
System.out.print(" ");
}
else
{
System.out.print("1");
m++;
}
}
System.out.println();
}

}
}


