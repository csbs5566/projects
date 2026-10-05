package classfoundation;

public class Student {
    private String name;
    private String studentID;
    private int score;
    public Student(){

    }//无参构造方法
    public Student(String name,String studentID,int score){
        this.name=name;
        this.studentID=studentID;
        this.score=score;
    }//有参构造方法

    public int getScore() {
        return score;
    }//获取分数
    public void setScore(int score) {
        if(score<0||score>100){
            System.out.println("分数输入错误");
            return;
        }else {
        this.score = score;
        }//设置分数
    }
    public String getName() {
        return name;
    }//获取姓名
    public void setName(String name) {
        this.name = name;
    }//设置姓名
    public String getStudentID() {
        return studentID;
    }//获取学号
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }//设置学号
    public void introduction() {
        System.out.println("我是 "+name+", 学号是: "+studentID+", 分数是: "+score);
    }//介绍自己
}
