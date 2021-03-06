package CustomerView;

import Customer.Customer;
import CustomerList.CustomerList;
import CustomerUtil.CusUtility;

public class CustomerView {
    public static void main(String[] args) {
        CustomerList cl=new CustomerList();
        AddData(cl);
        start(cl);
    }
    public static void show()
    {
        System.out.println("--------------------------客户信息管理系统-------------------------");
        System.out.println("                           1:添加客户");
        System.out.println("                           2:删除客户");
        System.out.println("                          3:修改客户信息");
        System.out.println("                          4:查找客户信息");
        System.out.println("                          5:客户信息列表");
        System.out.println("                            6：退出");
        System.out.print("请选择：(1-6):");
    }
    public static void start(CustomerList cl)
    {
        char c;
        while(true)
        {
            show();
            boolean h=false;
            c= CusUtility.readMenuSelect();
            switch (c) {
                case '1':
                    cl.add();
                    break;
                case '2':
                    cl.delete();
                    break;
                case '3':
                    cl.replace();
                    break;
                case '4':
                    cl.find();
                    break;
                case '5':
                    cl.list();
                    break;
                case '6':
                    System.out.print("确认是否要退出：是(Y)/否(N):");
                    char a=CusUtility.reconfirm();
                    if(a=='y')
                    {
                        h=true;
                        break;
                    }
                    else
                        break;
            }
            if(h)
            {
                break;
            }
        }
        System.out.println("--------------------------系统结束运行-------------------------");
    }
    public static void AddData(CustomerList cl)
    {
        Customer a1=new Customer("张飞",'男',28,"13878978977","123456789@qq.com");
        Customer a2=new Customer("关羽",'男',29,"19811732639","2985958099@qq.com");
        Customer a3=new Customer("刘备",'男',30,"13998987876","19835879249@qq.com");
        Customer a4=new Customer("孙尚香",'女',26,"14847589447","184798647619@qq.com");
        Customer a5=new Customer("鲁班",'男',54,"14987589447","18895278467619@qq.com");
        Customer a6=new Customer("诸葛亮",'男',26,"14998782647","188868888467619@qq.com");
        Customer a7=new Customer("大美女",'女',19,"14193847647","1290576289819@qq.com");
        Customer a8=new Customer("大帅哥",'男',19,"15957713567","88734928478499@qq.com");
        Customer a9=new Customer("大乔",'女',24,"19837582956","1346579278499@qq.com");
        Customer a10=new Customer("鲁班",'女',24,"13974829572","94898509878499@qq.com");
        cl.addData(a1);cl.addData(a2);cl.addData(a3);cl.addData(a4);cl.addData(a5);
        cl.addData(a6);cl.addData(a7);cl.addData(a8);cl.addData(a9);cl.addData(a10);
    }
}
