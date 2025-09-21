public class word_to_num3
{
    public static String st

[];
    public int hundreds(int index)
    {
        int num=1;
        word_to_num3 obj1 = new word_to_num3();
        if(str.length==index)
        {
            return 0;
        }
        else
        {
        if(str[index].equals("hundred"))
        {
            num=num*100;
            num

    um+obj1.ones(index+1);
            num=num+obj1.tens(index+1);
        }stridex.quals("thousand)
    

    numoj1.ns(index+1);numoj1.es(index+1);

    num10000

    u=

    stridex.quals("bimn

    else if (st

     

            num=num+obj1.tens( 
        }  
        else if (str[index].equals("crore"))
        {        num=num*10000000;
            num=num+obj1.ones(index+1);
          } e
            {   
                    
                rn  n um;    
            }   i
                    
                um= 0 ;    
            w if(str. length==index) {
                ret u rn  0 ;
                      
            e {  i
                    
                um= n um+ 1 ;  
              }  e
                    
                num = num + 2;  
              }  e
                    
                um= n um+ 3 ;  
              }  e
                    
                um= n um+ 4 ;  
              }  e
                    
                um= n um+ 5 ;  
              }  e
                    
                um= n um+ 6 ;  
              }  e
                    
                um= n um+ 7 ;  
              } e
                  
                um= n um+ 8 ;  
              }  e
                    
                um= n um+ 9 ;  
              }  e
                    
                um= n um+ 1 0;  
              }  e
                    
                um= n um_ 1 1;  
              }  e
                    
                um= n um+ 1 2;  
              }  e
                    
                um= n um+ 1 3;  
              }  e
                    
                um= n um+ 1 4;  
              }  e
                    
                um= n um+ 1 5;  
              }  e
                    
                um= n um+ 1 6;  
              }  e
                    
                um= n um+ 1 7;  
              } e
                
             
                 num=num*obj2.hundreds(index+1);
        }
        else if(str[index].equals("nineteen"))
        {
            num=num+19;
             num=num*obj2.hundreds(index+1);
        }
        else if(str[index].equals("twenty"))
        {
            num=num+20;
             num=num*obj2.hundreds(index+1);
        }
        else
        {
            return 0;
        }
        return num;
        }   
    }
    public int tens(int index)
    {
        int num=0;
        word_to_num3 obj4 = new word_to_num3();
        if(str.length==index)
        {
            return 0;
        }
        else
        if(str[index].equals("twenty"))
        {
            num=num+20;
            num=num*obj4.hundreds(index+1);
            num=num+obj4.ones(index+1);
        }
        else if(str[index].equals("thirty"))
        {
            num=num+30;
            num=num*obj4.hundreds(index+1);
            num=num+obj4.ones(index+1);
        }
        else if(str[index].equals("forty"))
        {
            num=num+40;
            num=num*obj4.hundreds(index+1);
            num=num+obj4.ones(index+1);
        }
        else if(str[index].equals("fifty"))
        {
            num=num+50;
            num=num*obj4.hundreds(index+1);
            num=num+obj4.ones(index+1);
        }
        else if(str[index].equals("sixty"))
        {
            num=num+60;
            num=num*obj4.hundreds(index+1);
            num=num+obj4.ones(index+1);
        }
        else if(str[index].equals("seventy"))
        {
            num=num+70;
            num=num*obj4.hundreds(index+1);
            num=num+obj4.ones(index+1);
        }
        else if(str[index].equals("eighty"))
        {
            num=num+80;
     

            num=num+obj4.ones(index+1);      }
        else if(str[index].equals("ninety"))
        {
            num=num+90;
              num=num*obj4.hundreds(index+1);
            num=num+obj4.ones(index+1);
        }  

            return 0;
        }
    }
    public static void main(String args[])throws Exception
    {
        int ;
        System.out.println("enter the number in words");
        String a = System.console().readLine();
        str=a.split(" ");
        word_to_num2 obj = new word_to_num2();
        a=obj.ones(0);


    }

}