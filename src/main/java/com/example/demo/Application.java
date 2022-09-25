package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conexion =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/ep1",
                        "root",
                        "root");

        /*Statement st = conexion.createStatement();

        PreparedStatement pt = conexion.prepareStatement("select * from users where id = ? and username = ?");
        pt.setInt(1,2);
        pt.setString(2,"DNI46299021");*/

        CallableStatement callSp = conexion.prepareCall("{call validarLogin(?,?,?)}");
        callSp.setString(1,"DNI73267572");
        callSp.setString(2,"123456");
        callSp.registerOutParameter(3, Types.INTEGER);

        callSp.executeQuery();

        int resultado = callSp.getInt(3);

        if(resultado == 1) {
            System.out.println("Login exitoso");

        }else{
            System.out.println("Usuario o clave incorrecto");
        }



        CallableStatement callSp2 = conexion.prepareCall("{ call listarAllUser () }");
        ResultSet resultadoSP2 = callSp2.executeQuery();

        while (resultadoSP2.next()){
            System.out.println(resultadoSP2.getString("username"));
        }



        CallableStatement callSp3 = conexion.prepareCall("{ call listarUserPerId (?) }");
        callSp3.setInt(1,2);
        ResultSet resultadoSP3 = callSp3.executeQuery();

        while (resultadoSP3.next()){
            System.out.println(resultadoSP3.getString("name"));
        }



        //ResultSet resultado = callSp.executeQuery();

        //while (resultado.next()) {
        //    System.out.println(resultado.getString("name"));
        //}



    }

}
