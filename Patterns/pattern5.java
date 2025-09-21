class pattern5
{
public static void main(String args[])
{
int i,j,k;
for(i=0;i<10;i+=2)
{
for(k=0;k<i;k+=2)
{
System.out.print(" ");
}
for(j=9;j>i;j--)
{
System.out.print("*");
}
System.out.println();
}
 

for(i=2;i<10;i+=2)
{
for(k=6;k>=i;k-=2)
{
System.out.print(" ");
}
for(j=0;j<=i;j++)
{
System.out.print("*");
}
System.out.println();
}

}
}




*********
 *******
  *****
   ***
    *
   ***
  *****
 *******
*********