package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка, а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        //Напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
//            int count = 1;
            //если наш map не содержит ключа (слово) , то можем считать его вхождения
            //если это слово уже есть в map, то для него уже не надо считать, так как его вхождение уже посчитано раньше, переходим к следующему слову

            String key = list.get(i);
            if (!(result.containsKey(key))) {


                result.put(key, Collections.frequency(list, key));
            }

        }


        return result;
    }

}
