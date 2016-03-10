package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    private Solution(float f){}
    private Solution(int i){}
    private Solution(double d){}
    protected Solution(){}
    protected Solution(Double d){}
    protected Solution(Float f){}
    Solution(int i, int j) {}
    Solution(int i, double j) {}
    Solution(int i, float j) {}
    public Solution(String s){}
    public Solution(Object o){}
    public Solution(Short s){}
}

