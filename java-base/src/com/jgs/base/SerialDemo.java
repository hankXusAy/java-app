package com.jgs.base;

import java.io.*;

/**
 * @ClassName SerialDemo
 * @Description    序列化
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/24 10:01 上午
 * @Return
 */
public class SerialDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        FileOutputStream fos = new FileOutputStream("user.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        User user1 = new User("xss", "123456", "male");
        oos.writeObject(user1);
        oos.flush();
        oos.close();
        //反序列化
        FileInputStream fis = new FileInputStream("user.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user2 = (User) ois.readObject();
        System.out.println(user2.getUserName()+ " " +
                user2.getPassword() + " " + user2.getSex());
        //反序列化的输出结果为：xss 123456 male
    }
}

class User implements Serializable {
    private String userName;
    private String password;
    private String sex;
    //全参构造方法、get和set方法省略


    public User(String userName, String password, String sex) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}