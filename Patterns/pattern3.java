class pattern3
{
public static void main(String args[])
{
int i,j,k,a=0;
for(i=0;i<10;i+=2)
{
for(k=8;k>i;k-=2)
{
System.out.print(" ");
}
for(j=0;j<=i;j++)
{
a=i;
if(j==0||j==a)
{
System.out.print("*");
}
else
{
System.out.print(" ");
}
}
System.out.println();
}


for(i=0;i<8;i+=2)
{
for(k=0;k<=i;k+=2)
{
System.out.print(" ");
}
for(j=6;j>=i;j--)
{
a=i;
if(j==6||j==a)
{
System.out.print("*");
}
else
{
System.out.print(" ");
}
}
System.out.println();
}
}
}




/* 
    *
   * *
  *   *
 *     *
*       *
 *     *
  *   *
   * *
    *

    */
