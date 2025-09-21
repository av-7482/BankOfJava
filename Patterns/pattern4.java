class pattern4
{
public static void main(String args[])
{
int a=8,i,j,k;
for(i=0;i<5;i++)
{
for(j=0;j<=i;j++)
{
System.out.print("*");
}
for(k=0;k<a;k++)
{
System.out.print(" ");
}
for(j=0;j<=i;j++)
{
System.out.print("*");
}
a-=2;
System.out.println();
}
a=2;
for(i=4;i>0;i--)
{
for(j=0;j<i;j++)
{
System.out.print("*");
}
for(k=0;k<a;k++)
{
System.out.print(" ");
}
a+=2;
for(j=0;j<i;j++)
{
System.out.print("*");
}
System.out.println();

}




}
}


/*
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *  */