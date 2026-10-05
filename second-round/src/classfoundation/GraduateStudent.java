package classfoundation;


public class GraduateStudent extends Student{
    private String advisor;
    public GraduateStudent(){

    }//无参构造方法
    public GraduateStudent(String name, String studentID, int score, String advisor) {
        super(name, studentID, score);
        this.advisor = advisor;
    }//有参构造方法



    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }//设置导师

    public String getAdvisor() {
        return advisor;
    }//获取导师

    @Override
    public void introduction() {
        System.out.println("我是 "+getName()+", 学号是: "+getStudentID()+", 分数是: "+getScore()+", 导师是: "+advisor);
    }//介绍自己
    public void research() {
        System.out.println("我在做科研");
    }

}
