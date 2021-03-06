package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDay;

    private Person(String name, Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static Person createMale(String name, Date birthDay){
        return new Person(name, Sex.MALE, birthDay);
    }

    public static Person createFemale(String name, Date birthDay){
        return new Person(name, Sex.FEMALE, birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

//    public String toString() {
//        if (this.sex == Sex.MALE )
//            if (birthDay != null)
//                return name + " родился " + String.valueOf(new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH).format(birthDay));
//            else return name;
//        else if (this.sex == Sex.FEMALE)
//            return name + " родилась " + String.valueOf(new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH).format(birthDay));
//        else if ((this.name == null) && (this.sex == null) && (this.birthDay == null))
//            return "запись пуста";
//        return null;
//
//    }
}
