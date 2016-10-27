package tests.Strings;

/**
 * Created by solbon on 26.11.2014.
 */
public class StringPool {
    public static void main(String[] args) {
/*        String s = "abc";   //"abc" added into String Pool and s has ref to "abc" in SP (s=SP("abc"))
        String s1 = "abc";  //"abc" already in SP, so s1 has ref to "abc" in SP (s1=SP("abc"))
        s1 = "xyz";         //"xyz" added int SP (new object), s1 has ref to "xyz" in SP (s1=SP("xyz"))
        String t = new String("abc");   //new object was created in Heap with value "abc", t has ref to object in Heap (t=heap("abc")). "abc" already in SP, so no new string added into SP
//        t = t.intern();     //inter() return ref to object in SP, in this case (t=SP("abc"))
        String t1 = t.intern();         //t1 has ref to "abc" in SP, the same as s and s1 (t1=SP("abc"))
        String t2 = t;                  //t2 has the same ref as t - to object in Heap (t2=heap("abc"))
        System.out.println("s == t: " + (s == t));
        System.out.println("s == t1: " + (s==t1));
        System.out.println("s == s1: " + (s==s1));
        System.out.println("s == t2: " + (s==t2));*/

        int i = 5;
        String s1 = "abcd5";            //s1=SP("abcd5")
        String s2 = "abcd"+"5";         //s2=SP("abcd5")
        String s3 = "abc"+"d5";         //s3=SP("abcd5")
        String t1 = "abcd"+s1.length(); //s4=Heap("abcd5")
        String t2 = "abcd"+i;           //s5=Heap("abcd5"), different than s4 ref. if i would be "final", then t2=SP("abcd5")
        String s4 = "abcd"+5;           //s6=SP("abcd5")
		String t3 = t1.intern();		//t3=SP("abcd5")
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//true
        System.out.println(s2 == s3);//true
        System.out.println(s1 == t1);//false
        System.out.println(s1 == t2);//false
        System.out.println(t1 == t2);//false
        System.out.println(t2 == s4);//false
        System.out.println(s1 == s4);//true
        System.out.println(s2 == s4);//true
        System.out.println(s1.equals(t1));//true
        System.out.println(s1.equals(t2));//true
		System.out.println(t3 == s1);//true

/*        String s = "abc";
        String s1 = "xyzabc";
        String s2 = "xyz"+"abc";
        String t = new String("xyz") + s;
        String t1 = new String("xyzabc");
        String t2 = t.intern();

        System.out.println("s: " + s);
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("t: " + t);
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
        System.out.println(s1 == t);//false
        System.out.println(s1 == t1);//false
        System.out.println(t == t1);//false
        System.out.println(s1 == t2);//true
        System.out.println(s1 == s2);//true*/
    }
}
