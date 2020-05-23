package com.example.lab5.DBHandler;


import android.provider.BaseColumns;

public final class UserMaster {
        // To prevent someone from accidentally instantiating the contract class,
        // make the constructor private.
        private UserMaster() {}


    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "UserInfo";
        public static final String COLUMN_1= "UserName";
        public static final String COLUMN_2= "Password";
    }


    }

