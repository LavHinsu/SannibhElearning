package com.sannibhelearning;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyCoursesQuery extends AsyncTask<String , Void, String> {



    Connection con;
    Context mContext;
    OnCoursesload mCallback;
    ResultSet resultSet;


    public MyCoursesQuery(Context context){
        mContext=context;
        mCallback=(OnCoursesload) context;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionString = "jdbc:mysql://192.168.0.4:3306/" + "elearn" + "?user=" + "elearn" + "&password=" + "batman" + "&useUnicode=true&characterEncoding=UTF-8&";
            Connection con = DriverManager.getConnection(connectionString);

            String email=strings[0];

            String query="select course.coursename,course.image from usertocourse inner join course on course.courseid=usertocourse.courseid where usertocourse.email=\""+email+"\";";

            Statement stmt=con.createStatement();
            resultSet=stmt.executeQuery(query);


        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mCallback.onCoursesLoad(resultSet);

    }
}
