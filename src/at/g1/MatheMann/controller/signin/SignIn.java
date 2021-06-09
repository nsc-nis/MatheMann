package at.g1.MatheMann.controller.signin;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class SignIn{
    public static ArrayList<SignInData> dataList = new ArrayList<>();

    public static void setUser(){
        try(BufferedReader br = new BufferedReader(new FileReader("/at/g1/MatheMann/ressources/Users.csv")))
        {
            String u = br.readLine();
            if(u.equals("User SaveFile 1.0"))
            {
                while ((u = br.readLine()) != null)
                {
                    String split[] = u.split(";");
                    dataList.add(new SignInData(split[0], split[1]));
                }
            }
        }
        catch (Exception e)
        {

        }
    }

    public static void addUser(String username, String password)
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("/at/g1/MatheMann/ressources/Users.csv", true)))
        {
            bw.write(username+";"+password);
            dataList.add(new SignInData(username, password));
        }
        catch (Exception e)
        {

        }
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
