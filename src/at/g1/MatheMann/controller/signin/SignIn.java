package at.g1.MatheMann.controller.signin;


import java.util.ArrayList;


public class SignIn{
    public static ArrayList<SignInData> dataList = new ArrayList<SignInData>();

    public static void setUser(){
    }

    public static int getSize(){
        return dataList.size();
    }

    public static String getNameOfUser(int index){
        return dataList.get(index).getUsername();
    }

    public static String getPasswordOfUser(int index){
        return dataList.get(index).getPassword();
    }

}
