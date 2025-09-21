class pattern 
{
public static void main(String args[])throws Exception
{
int m=6;
int i,j,k,a=1;
for(i=1;i<=13;i=i+4)
{
for(j=m;j>0;j=j-1)
{

System.out.print(" ");
}
for(k=1;k<=i;k++)
{
if(k%2==0)
{
System.out.print(" ");
}
else
{
System.out.print(a);
a++;
}
}

System.out.println();
m=m-2;
}

}

}
