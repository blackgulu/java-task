package CustomerUtil;

import java.util.Scanner;
public class CusUtility {
    private static Scanner reader=new Scanner(System.in);
    public static char readMenuSelect()
    {
        char c;
        while(true)
        {
            String s=readKeyBoard(1,false);
            c=s.charAt(0);
            if(c!='1' && c!='2' && c!='3' && c!='4' && c!='5' && c!='6')
            {
                System.out.print("选择错误，请重新选择:");
            }
            else
                break;
        }
        return c;
    }
    public static char readchar()
    {
        while(true) {
            char c = readKeyBoard(1, false).charAt(0);
            if(c=='男' || c=='女')
                return c;
            else
                System.out.print("输入的性别有误，请重新输入：");
        }

    }
    public static String readtel()
    {
        while(true)
        {
            String s=readKeyBoard(11,false);
            if(s.length()!=11)
            {
                System.out.print("输入的电话号码不正确，请重新输入：");
            }
            else if(!checktel(s))
            {
                System.out.print("请重新输入由数字组成的11位电话号码：");
            }
            else
                return s;
        }
    }
    public static boolean checktel(String s)
    {
        for (int i = 0; i < 11; i++) {
            if(!(s.charAt(i)>='0' && s.charAt(i)<='9'))
                return false;
        }
        return true;
    }
    public static String readtel(String defaulttel)
    {
        while (true)
        {
            String s=readKeyBoard(11,true);
            if(s.equals(""))
                return defaulttel;
            else if(s.length()!=11)
                System.out.print("输入的电话号码不正确，请重新输入：");
            else if(!checktel(s))
                System.out.print("请重新输入由数字组成的11位电话号码：");
            else
                return s;
        }
    }
    public static char readchar(char defaultvalue)
    {
        while(true) {
            String c = readKeyBoard(1, true);
            if(c.equals(""))
                return defaultvalue;
            else if(c.equals("男") || c.equals("女"))
                return c.charAt(0);
        }
    }
    public static int readInt()
    {
        int n;
        while(true) {
            String s = readKeyBoard(2, false);
            try {
                    n=Integer.parseInt(s);
                    break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入有误，请重新输入：");
            }
        }
        return n;
    }
    public static int readInt(int defaultvalue)
    {
        int n;
        while(true)
        {
            String s=readKeyBoard(2,true);
            if(s.length()==0)
                return defaultvalue;
            try{
                n=Integer.parseInt(s);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.print("数字输入有误，请重新输入：");
            }
        }
        return n;
    }
    public static String read(int limit)
    {
        String s=readKeyBoard(limit,false);
        return s;
    }
    public static String read(int limit,String defaultval)
    {
        String s=readKeyBoard(limit,true);
        return (s.length()==0)?defaultval:s;
    }
    public static char reconfirm()
    {
        char c;
        String s=readKeyBoard(1,false).toLowerCase();
        while(true)
        {
            c=s.charAt(0);
            if(c=='y' || c=='n')
                break;
            else
            {
                System.out.print("选择有误，请重新输入:");
            }
        }
        return c;
    }
    public static String readKeyBoard(int limit,boolean h)  //实现回车默认数据
    {
        String line="";
        while(true)
        {
            line=reader.nextLine();
            if(line.equals("")) {
                if (h)
                    return line;
                else
                    continue;
            }
            if(line.length()>limit || line.length()<1)
            {
                System.out.print("输入长度(输入长度不大于"+limit+")错误,请重新输入:");
                continue;
            }
            break;
        }
        return line;
    }
}
