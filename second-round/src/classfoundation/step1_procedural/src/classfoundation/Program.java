package classfoundation;

/*
 * ============================================================
 *  面向过程（Procedural）版：和学生管理系统等价的实现
 *
 *  规则：
 *   1. 没有 class 建模（只有"装 main 的壳子"这一个 class）
 *   2. 数据全部用【一个个独立的变量】表示，数据和方法是分开的
 *   3. 每个学生都要亲手指定：叫什么、是普通生还是研究生
 *   4. 每种输出都要单独写一个函数（因为没有"多态"这种东西）
 * ============================================================
 */
public class Program {

    // ---------------------------------------------------------
    // 第一步：定义"数据"
    // 注意：方法里要用到这些变量，所以它们必须写成 static（相当于 C 的全局变量）
    // ---------------------------------------------------------
    static String st1Name;      // 学生1 的姓名
    static String st1ID;        // 学生1 的学号
    static int    st1Score;     // 学生1 的分数

    static String st2Name;
    static String st2ID;
    static int    st2Score;

    static String st3Name;
    static String st3ID;
    static int    st3Score;

    // 研究生
    static String gsName;
    static String gsID;
    static int    gsScore;
    static String gsAdvisor;    // 导师：多出来的一个字段，每个相关函数都要多加一个参数

    // 用父类引用指向子类对象的那种"多态"写法，在面向过程里只能这样模拟
    static String sName;
    static String sID;
    static int    sScore;
    static String sAdvisor;
    static String sType;        // "普通生" 还是 "研究生"：程序必须自己记住每个变量的类型

    // ---------------------------------------------------------
    // 第二步：写函数（行为）
    // 每个函数都得靠上面那些全局变量才能干活 —— 这就是"数据与行为分离"
    // ---------------------------------------------------------

    /** 校验分数：面向过程版必须每个入口都自己调一次，没人帮你兜底 */
    static boolean checkScore(int score) {
        if (score < 0 || score > 100) {
            System.out.println("分数输入错误");
            return false;
        }
        return true;
    }

    /** 打印普通学生1的信息 */
    static void printSt1() {
        System.out.println("我是 " + st1Name + ", 学号是: " + st1ID + ", 分数是: " + st1Score);
    }

    /** 打印普通学生2的信息 */
    static void printSt2() {
        System.out.println("我是 " + st2Name + ", 学号是: " + st2ID + ", 分数是: " + st2Score);
    }

    /** 打印普通学生3的信息 */
    static void printSt3() {
        System.out.println("我是 " + st3Name + ", 学号是: " + st3ID + ", 分数是: " + st3Score);
    }

    /** 打印研究生的信息：比普通学生多一个"导师"，函数签名就得跟着变 */
    static void printGraduate(String name, String id, int score, String advisor) {
        System.out.println("我是 " + name + ", 学号是: " + id + ", 分数是: " + score + ", 导师是: " + advisor);
    }

    /** 做科研：普通学生没有这个能力，所以只能给研究生单独写一个 */
    static void researchGraduate() {
        System.out.println("我在做科研");
    }

    /**
     * 模拟 oop 里的 Student s = new GraduateStudent(...)
     * 面向过程没有多态，只能靠一个 sType 标记 + if 判断来"猜"该走哪个分支
     */
    static void printAny() {
        if (sType.equals("研究生")) {
            printGraduate(sName, sID, sScore, sAdvisor);
        } else {
            System.out.println("我是 " + sName + ", 学号是: " + sID + ", 分数是: " + sScore);
        }
    }

    // ---------------------------------------------------------
    // 第三步：按顺序执行（主流程）
    // ---------------------------------------------------------
    public static void main(String[] args) {

        // ---- 学生1：要逐个字段赋值，一个都不能漏 ----
        st1Name = "长盛";
        st1ID = "123457";
        if (checkScore(100)) {
            st1Score = 100;
        }

        // ---- 学生2 ----
        st2Name = "lisi";
        st2ID = "123458";
        if (checkScore(80)) {
            st2Score = 80;
        }

        // ---- 学生3 ----
        st3Name = "zhangsan";
        st3ID = "123456";
        if (checkScore(90)) {
            st3Score = 90;
        }

        printSt1();
        printSt2();
        printSt3();
        System.out.println();

        // ---- 研究生 ----
        gsName = "研究生";
        gsID = "123456";
        if (checkScore(90)) {
            gsScore = 90;
        }
        gsAdvisor = "导师";

        printGraduate(gsName, gsID, gsScore, gsAdvisor);
        researchGraduate();
        System.out.println();

        // ---- 模拟 "父类引用指向子类对象" ----
        sName = "学生";
        sID = "123456";
        if (checkScore(90)) {
            sScore = 90;
        }
        sAdvisor = "导师";
        sType = "研究生";          // 全靠这行手工标记，忘记写就出错

        printAny();

        // oop 里一行 ((GraduateStudent)s).research() 就搞定的事，
        // 面向过程里得自己判断类型，才敢调用
        if (sType.equals("研究生")) {
            researchGraduate();
        }
    }
}
