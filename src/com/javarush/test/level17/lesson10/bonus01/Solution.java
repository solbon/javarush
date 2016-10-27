package com.javarush.test.level17.lesson10.bonus01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            //если передано 4 параметра, например: -c Солбон м 02/12/1981, то вызвать этот блок
            //имя из 1 слова
            if (args.length == 4) {
                if (args[2].equals("м"))
                    allPeople.add(Person.createMale(args[1], dateFormat.parse(args[3])));
                else if (args[2].equals("ж"))
                    allPeople.add(Person.createFemale(args[1], dateFormat.parse(args[3])));
            }

            //если передано 5 параметров(имя из 2 слов), например: -c Солбон Дарибазарон м 02/12/1981, то вызвать этот блок
            //имя из 2 слов
            else if (args.length == 5) {
                if (args[3].equals("м"))
                    allPeople.add(Person.createMale(args[1] + " " + args[2], dateFormat.parse(args[4])));
                else if (args[3].equals("ж"))
                    allPeople.add(Person.createFemale(args[1] + " " + args[2], dateFormat.parse(args[4])));
            }
            System.out.println(allPeople.size() - 1);
        }

        else if (args[0].equals("-u")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            if (args.length == 5) {
                person.setName(args[2]);
                if (args[3].equals("м"))
                    person.setSex(Sex.MALE);
                if (args[3].equals("ж"))
                    person.setSex(Sex.FEMALE);
                person.setBirthDay(dateFormat.parse(args[4]));
            }
            if (args.length == 6) {
                person.setName(args[2] + " " + args[3]);
                if (args[4].equals("м"))
                    person.setSex(Sex.MALE);
                if (args[4].equals("ж"))
                    person.setSex(Sex.FEMALE);
                person.setBirthDay(dateFormat.parse(args[5]));
            }

            }
        else if (args[0].equals("-d")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
//            person.setName(null);
//            person.setSex(null);
            person.setBirthDay(null);
        }
        else if (args[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            DateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
            String sex = null;
            if (person.getSex() == Sex.MALE)
                sex = "м";
            else if (person.getSex() == Sex.FEMALE)
                sex = "ж";

            System.out.println(person.getName() + " " + sex + " " + dateFormat1.format(person.getBirthDay()));
        }




//        System.out.println(allPeople);
    }

}
