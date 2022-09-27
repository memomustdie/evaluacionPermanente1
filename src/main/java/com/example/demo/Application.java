package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/ep01",
                        "root",
                        "root");





        //Update con Statement
        Statement st = con.createStatement();

        int resultUpdate = st.executeUpdate("update supplier set city='Lima' where companyname='Arroces La Cigala'");

        ResultSet resultado = st.executeQuery("select * from supplier where companyname='Arroces La Cigala' ");

        while (resultado.next()) {
            System.out.println(resultado.getString("id"));
            System.out.println(resultado.getString("companyname"));
            System.out.println(resultado.getString("product"));
            System.out.println(resultado.getString("city"));
            System.out.println(resultado.getString("country"));

        }


        //Listar cpn PreparedStament
        PreparedStatement pt = con.prepareStatement("select * from supplier where id = ?");
        pt.setInt(1,2);

        ResultSet resultado2 = pt.executeQuery();

        while (resultado2.next()){
            System.out.println(resultado2.getString("id"));
            System.out.println(resultado2.getString("companyname"));
            System.out.println(resultado2.getString("contactname"));
            System.out.println(resultado2.getString("product"));
            System.out.println(resultado2.getString("city"));
            System.out.println(resultado2.getString("country"));
        }


        //Eliminar con CallableStatement
        CallableStatement calldel = con.prepareCall("{ call deletesupplier (?) }");
        calldel.setInt(1,1);
        ResultSet resultadod = calldel.executeQuery();

        //listar final con cambios
        CallableStatement calllistar = con.prepareCall("{ call listarAllSupp() }");
        ResultSet resultado3 = calllistar.executeQuery();

        while (resultado3.next()){
            System.out.println(resultado3.getString("id"));
            System.out.println(resultado3.getString("companyname"));
            System.out.println(resultado3.getString("product"));
            System.out.println(resultado3.getString("city"));
            System.out.println(resultado3.getString("country"));
        }


    }

}
