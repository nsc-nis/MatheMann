package at.g1.MatheMann.controller.signin;


import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class SignIn{
    public static ArrayList<SignInData> dataList = new ArrayList<>();

    public static void setUser(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/at/g1/MatheMann/ressources/Users.csv")))
        {
            String u = br.readLine();
            if(u.equals("User SaveFile 1.0"))
            {
                while ((u = br.readLine()) != null)
                {
                    String[] split = u.split(";");
                    dataList.add(new SignInData(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5])));
                }
            }
        }
        catch (Exception exception)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Internal Error");
            alert.setContentText(String.format("An internal Error occurred. Please restart the program%nor contact the developer on GitHub%n%nError message: %s", exception.getMessage()));
            alert.setResizable(true);
            alert.showAndWait();
            System.err.println(exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }

    public static void addUser(String username, String password)
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/at/g1/MatheMann/ressources/Users.csv", true)))
        {
            bw.write(username+";"+password+"\n");
            dataList.add(new SignInData(username, password, 0, 0, 0, 0));
        }
        catch (Exception exception)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Internal Error");
            alert.setContentText(String.format("An internal Error occurred. Please restart the program%nor contact the developer on GitHub%n%nError message: %s", exception.getMessage()));
            alert.setResizable(true);
            alert.showAndWait();
            System.err.println(exception.getMessage());
            exception.printStackTrace(System.err);
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
