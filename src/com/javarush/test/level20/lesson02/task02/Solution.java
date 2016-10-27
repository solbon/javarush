package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User bob = createUser("Bob");
            User tom = createUser("Tom");
            javaRush.users.add(bob);
            javaRush.users.add(tom);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    private static User createUser(String name) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName("Smith");
        user.setBirthDate(new Date());
        user.setMale(true);
        user.setCountry(User.Country.OTHER);
        return user;
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (User user : users) {
                writer.println("user");
                writer.println(user.getFirstName());
                writer.println(user.getLastName());
                writer.println(dateFormat.format(user.getBirthDate()));
                writer.println(user.isMale());
                writer.println(user.getCountry().getDisplayedName());
                writer.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String isUser;
            while (!((isUser = reader.readLine()) == null)) {
                if (!"user".equals(isUser))
                    continue;
                String fname = reader.readLine();
                String lname = reader.readLine();
                Date bdate = dateFormat.parse(reader.readLine());
                boolean isMale = Boolean.getBoolean(reader.readLine());
                String countryName = reader.readLine();

//                User.Country country = getCountryByName(countryName);

                User.Country country;
                switch (countryName) {
                    case "Russia": country = User.Country.RUSSIA; break;
                    case "Ukraine": country = User.Country.UKRAINE; break;
                    case "Other": country = User.Country.OTHER; break;
                    default: country = User.Country.OTHER;
                }

                User user = new User();
                user.setFirstName(fname);
                user.setLastName(lname);
                user.setBirthDate(bdate);
                user.setMale(isMale);
                user.setCountry(country);
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users.size() == javaRush.users.size();

        }

        @Override
        public int hashCode() {
            return users.hashCode();
        }
    }
}


