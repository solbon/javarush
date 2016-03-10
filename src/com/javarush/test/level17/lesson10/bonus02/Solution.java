package com.javarush.test.level17.lesson10.bonus02;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
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
            for (int i = 1; i < args.length - 1; i++) {
                if (args[i + 1].equals("м")) {
                    allPeople.add(Person.createMale(args[i], dateFormat.parse(args[i + 2])));
                    i = i + 2;
                    System.out.println(allPeople.size() - 1);
                }
                else if (args[i + 1].equals("ж")) {
                    allPeople.add(Person.createFemale(args[i], dateFormat.parse(args[i + 2])));
                    i = i + 2;
                    System.out.println(allPeople.size() - 1);
                }
                else if (args[i + 2].equals("м")) {
                    allPeople.add(Person.createMale(args[i] + " " + args[i + 1], dateFormat.parse(args[i + 3])));
                    i = i + 3;
                    System.out.println(allPeople.size() - 1);
                }
                else if (args[i + 2].equals("ж")) {
                    allPeople.add(Person.createFemale(args[i] + " " + args[i + 1], dateFormat.parse(args[i + 3])));
                    i = i + 3;
                    System.out.println(allPeople.size() - 1);
                }
            }
        }

        else if (args[0].equals("-u")) {
            for (int i = 1; i < args.length - 1; i++) {
                Person person = allPeople.get(Integer.parseInt(args[i]));
                if ((args[i + 2].equals("м")) || (args[i + 2]).equals("ж")) {
                    person.setName(args[i + 1]);
                    if (args[i + 2].equals("м"))
                        person.setSex(Sex.MALE);
                    if (args[i + 2].equals("ж"))
                        person.setSex(Sex.FEMALE);
                    person.setBirthDay(dateFormat.parse(args[i + 3]));
                    i = i + 3;
                }
                else if ((args[i + 3].equals("м")) || (args[i + 3]).equals("ж")) {
                    person.setName(args[i + 1] + " " + args[i + 2]);
                    if (args[i + 3].equals("м"))
                        person.setSex(Sex.MALE);
                    if (args[i + 3].equals("ж"))
                        person.setSex(Sex.FEMALE);
                    person.setBirthDay(dateFormat.parse(args[i + 4]));
                    i = i + 4;
                }
            }
        }
        else if (args[0].equals("-d")) {
            for (int i = 1; i < args.length - 1; i++) {
                Person person = allPeople.get(Integer.parseInt(args[i]));
                person.setBirthDay(null);
            }
        }
        else if (args[0].equals("-i")) {
            for (int i = 1; i < args.length; i++) {
                Person person = allPeople.get(Integer.parseInt(args[i]));
                DateFormat dateFormat1 = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
                String sex = null;
                if (person.getSex() == Sex.MALE)
                    sex = "м";
                else if (person.getSex() == Sex.FEMALE)
                    sex = "ж";

                System.out.println(person.getName() + " " + sex + " " + dateFormat1.format(person.getBirthDay()));
            }
        }


//        System.out.println(allPeople);


    }
}