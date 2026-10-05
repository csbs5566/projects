package classfoundation;

public class test {
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student();
        Student st3 = new Student("zhangsan", "123456", 90);

        st1.setName("长盛");
        st1.setStudentID("123457");
        st1.setScore(100);//st1赋值

        st2.setName("lisi");
        st2.setStudentID("123458");
        st2.setScore(80);//st2赋值

        st1.introduction();
        st2.introduction();
        st3.introduction();


        GraduateStudent GS1 = new GraduateStudent("研究生", "123456", 90, "导师");
        //GS1赋值
        GS1.introduction();
        GS1.research();
        Student s = new GraduateStudent("学生", "123456", 90, "导师");
//        s.introduction();
        ((GraduateStudent) s).research();

    }
}
