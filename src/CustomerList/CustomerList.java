package CustomerList;
import Customer.Customer;
import java.util.ArrayList;
import CustomerUtil.*;
public class CustomerList {             //实现增删改查
    ArrayList<Customer> al=new ArrayList<Customer>();
    public void addData(Customer cus)
    {
        al.add(cus);
    }
    public void add()               //实现客户的添加
    {
        System.out.println("-----------------------------添加客户-----------------------------");
        System.out.print("姓名：");
        String name=CusUtility.read(10);
        System.out.print("性别：");
        char gender=CusUtility.readchar();
        System.out.print("年龄：");
        int age=CusUtility.readInt();
        System.out.print("电话：");
        String tel=CusUtility.readtel();
        System.out.print("邮箱：");
        String email=CusUtility.read(20);
        Customer cus=new Customer(name,gender,age,tel,email);
        al.add(cus);
        System.out.println("----------------------------添加客户完成----------------------------");
        System.out.println();

    }
    public void delete()
    {
        System.out.println("-----------------------------删除客户-----------------------------");
        int id=0;
        System.out.print("请输入需要删除的客户的id：");
        while(true) {
            id = CusUtility.readInt();            //需要修改 现在只能取到1-99 再util里加个read id
            if(id<1 || id>al.size())
            {
                System.out.print("输入的id有误，请重新输入：");
                continue;
            }
            else{
                Customer cu=al.get(id-1);
                System.out.printf("%-6d %-6s %-6s %-6d  %-14s%-15s\n",al.indexOf(cu)+1,cu.getName()
                        ,cu.getGender(),cu.getAge(),cu.getTel(),cu.getEmail());
                System.out.print("确实是否需要删除：是(Y)/否(N):");
                char c=CusUtility.reconfirm();
                if(c=='y')
                    break;
                else {
                    System.out.println("----------------------------已返回----------------------------");
                    System.out.println();
                    return;
                }
            }
        }
        al.remove(id-1);
        System.out.println("----------------------------删除客户完成----------------------------");
        System.out.println();
    }
    public void replace()
    {
        System.out.println("----------------------------修改客户信息----------------------------");
        System.out.print("请输入需要修改的客户的id：");
        int id;
        Customer cus;
        while(true)
        {
            id=CusUtility.readInt();
            if(id>al.size() || id<1)
            {
                System.out.print("输入的id有误，请重新输入：");
                continue;
            }
            cus=al.get(id-1);
            System.out.printf("%-6d  %-6s %-6s %-6d  %-14s%-15s\n",id,cus.getName()
            ,cus.getGender(),cus.getAge(),cus.getTel(),cus.getEmail());
            System.out.print("是否对其进行修改：是(Y)/否(N)");
            char c=CusUtility.reconfirm();
            if(c=='y')
                break;
            else
                return;
        }
        System.out.println("按回车可以跳过对当前项的更改");
        System.out.print("姓名：");
        String name=CusUtility.read(10,cus.getName());
        System.out.print("性别：");
        char gender=CusUtility.readchar(cus.getGender());
        System.out.print("年龄：");
        int age=CusUtility.readInt(cus.getAge());
        System.out.print("电话：");              //电话11位，最后单独限制字长
        String tel=CusUtility.readtel(cus.getTel());
        System.out.print("邮箱：");
        String email=CusUtility.read(20,cus.getEmail());
        cus.setAge(age);cus.setEmail(email);cus.setGender(gender);
        cus.setTel(tel);cus.setName(name);
        System.out.println("---------------------------修改完成---------------------------");
        System.out.println();
    }
    public void find()
    {
        System.out.println("---------------------------查找客户---------------------------");
        System.out.print("通过以下方式进行查找：1.姓名  2.电话  3.邮箱 4.性别  5.年龄  6.返回");
        System.out.println("请选择(1-6):");
        char c;
        while(true) {
            c = CusUtility.read(1).charAt(0);
            if(c>='1' && c<='6')
                break;
            else
                System.out.println("请重新选择：");
        }
        switch(c){
            case '1':
                System.out.print("请输入客户名称：");
                String s=CusUtility.read(5);
                findbyname(s);
                break;
            case '2':
                System.out.print("请输入客户电话：");
                String findtel=CusUtility.readtel();
                findbytel(findtel);
                break;
            case '3':
                System.out.println("请输入客户邮箱：");
                String findemail=CusUtility.read(20);
                findbyemail(findemail);
                break;
            case '4':
                System.out.println("请输入客户性别：");
                char gender=CusUtility.readchar();
                findbygender(gender);
                break;
            case '5':
                System.out.println("请输入客户年龄");
                int age=CusUtility.readInt();
                findbyage(age);
                break;
            case '6':
                return;
        }
        System.out.println("--------------------------查找客户完成--------------------------");
        System.out.println();
        return;
    }
    public void findbyage(int age)
    {
        ArrayList<Customer> alage=new ArrayList<Customer>();
        for(Customer cu:al)
        {
            if(cu.getAge()==age)
                alage.add(cu);
        }
        if(alage.size()==0) {
            System.out.println("未找到客户！");
            return;
        }
        else
        {
            System.out.printf("%-6s%-6s%-6s%-6s%-13s%-15s\n","编号","姓名",
                    "性别","年龄","电话","邮箱");
            for(Customer cu:alage)
                System.out.printf("%-6d %-6s %-6s %-6d  %-14s%-15s\n",al.indexOf(cu)+1,cu.getName()
                        ,cu.getGender(),cu.getAge(),cu.getTel(),cu.getEmail());
        }
    }
    public void findbygender(char c)
    {
        ArrayList<Customer> alg=new ArrayList<Customer>();
        for(Customer cu:al)
        {
            if(cu.getGender()==c)
                alg.add(cu);
        }
        if(alg.size()==0) {
            System.out.println("未找到客户！");
            return;
        }
        else
        {
            System.out.printf("%-6s%-6s%-6s%-6s%-13s%-15s\n","编号","姓名",
                    "性别","年龄","电话","邮箱");
            for(Customer cu:alg)
                System.out.printf("%-6d %-6s %-6s %-6d  %-14s%-15s\n",al.indexOf(cu)+1,cu.getName()
                        ,cu.getGender(),cu.getAge(),cu.getTel(),cu.getEmail());
        }
    }
    public void findbyemail(String s)
    {
        for(Customer c:al)
        {
            if(c.getEmail().equals(s))
            {
                System.out.printf("%-6s%-6s%-6s%-6s%-13s%-15s\n","编号","姓名",
                        "性别","年龄","电话","邮箱");
                System.out.printf("%-6d %-6s %-6s %-6d  %-14s%-15s\n",al.indexOf(c)+1,c.getName()
                        ,c.getGender(),c.getAge(),c.getTel(),c.getEmail());
                return;
            }
        }
        System.out.println("未找到该客户！");
    }
    public void findbytel(String tel)
    {
        for(Customer c:al)
        {
            if(c.getTel().equals(tel))
            {
                System.out.printf("%-6s%-6s%-6s%-6s%-13s%-15s\n","编号","姓名",
                        "性别","年龄","电话","邮箱");
                System.out.printf("%-6d %-6s %-6s %-6d  %-14s%-15s\n",al.indexOf(c)+1,c.getName()
                        ,c.getGender(),c.getAge(),c.getTel(),c.getEmail());
                return;
            }
        }
        System.out.println("未找到该客户！");
    }
    public void findbyname(String name)
    {
        ArrayList<Customer> alname=new ArrayList<Customer>();
        for(Customer cu:al)
        {
            if(cu.getName().equals(name))
                alname.add(cu);
        }
        if(alname.size()==0) {
            System.out.println("未找到客户！");
            return;
        }
        else
        {
            System.out.printf("%-6s%-6s%-6s%-6s%-13s%-15s\n","编号","姓名",
                    "性别","年龄","电话","邮箱");
            for(Customer cu:alname)
                System.out.printf("%-6d %-6s %-6s %-6d  %-14s%-15s\n",al.indexOf(cu)+1,cu.getName()
                        ,cu.getGender(),cu.getAge(),cu.getTel(),cu.getEmail());
        }
    }
    public void list()
    {
        System.out.println("----------------------------客户列表----------------------------");
        if(al.size()==0) {
            System.out.println("客户列表为空！");
            return;
        }
        System.out.printf("%-6s%-6s%-6s%-6s%-13s%-15s\n","编号","姓名",
                "性别","年龄","电话","邮箱");
        for (int i = 0; i < al.size(); i++) {
            Customer cus=al.get(i);
            System.out.printf("%-6d %-6s %-6s %-6d  %-14s%-15s\n",i+1,cus.getName()
                    ,cus.getGender(),cus.getAge(),cus.getTel(),cus.getEmail());
        }
        System.out.println("----------------------------客户列表----------------------------");
        System.out.println();
    }
}
