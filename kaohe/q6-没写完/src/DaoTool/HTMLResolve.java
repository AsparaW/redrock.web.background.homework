package DaoTool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLResolve {
    List<String> myList = new ArrayList();
    List<List<String>> output = new ArrayList<>();

    HTMLResolve(String str) {
        Connection con = JDBCUtil.getConnection();
        DBTool myDB = new DBTool(con);
        initDB();
        String resStr = str;
        String res[];
        resStr = resStr.replaceAll("<(.|\n)+?>", "");
        resStr = resStr.replaceAll(" ", "");
        resStr = resStr.replaceAll("\t", "");
        resStr = resStr.replaceAll("([\\s\\S]*)教学班分类课程号-课程名教学班类别选课状态教师上课时间地点学生名单备注理论", "");
        resStr = resStr.replaceAll("序号学期类型教学班课程名称教师停课周停课时段补（代）课时间补课地点代课老师(.*)([\\s\\S]*)", "");
        resStr = resStr.replaceAll("名单", "");
        resStr = resStr.replaceAll("\r\n", "");
        res = resStr.split("[A-Z](\\d{7})-");
        for (String tempS : res) {
            myList.add(tempS);
            System.out.println(tempS);
        }

        for (int i = 1; i < res.length; i++) {
            String courseName = "";
            String courseID = "";
            String courseType = "";
            String courseStatus = "";
            String courseTeacher = "";
            String courseMode = "";
            String operateTime = "";

            String pattern;
            //
            pattern = "[A-Z]+(\\d){5}[A-Z](\\d){10}";
            Pattern r = Pattern.compile(pattern);
            Matcher matcher = r.matcher(res[i]);
            if (matcher.find()) {
                courseID = matcher.group(0);
                int courseSize = matcher.start();
                courseName = res[i].substring(0, courseSize);
                System.out.println(courseID);
                System.out.println(courseName);
            }
            //
            pattern = "必修";
            r = Pattern.compile(pattern);
            matcher = r.matcher(res[i]);
            if (matcher.find()) {
                courseType = matcher.group(0);
                System.out.println(courseType);
            }
            //
            pattern = "正常";
            r = Pattern.compile(pattern);
            matcher = r.matcher(res[i]);
            int teacherStart = 0;
            int teacherEnd = 0;
            if (matcher.find()) {
                courseStatus = matcher.group(0);
                System.out.println(courseStatus);
                teacherStart = matcher.end();
            }

            //
            int strStart, strEnd;
            pattern = "理论|实验实践";
            r = Pattern.compile(pattern);
            matcher = r.matcher(res[i]);
            if (matcher.find()) {
                courseMode = matcher.group(0);
                System.out.println(courseMode);
                strEnd = matcher.start();
            } else {
                courseMode = "未知";
                System.out.println(courseMode);
                strEnd = res[i].length();
            }

            //
            strStart = 0;
            pattern = "星期(\\d)";
            r = Pattern.compile(pattern);
            matcher = r.matcher(res[i]);
            int day[][][] = new int[30][8][20];

            if (matcher.find()) {
                teacherEnd = matcher.start();
                strStart = teacherEnd;
            }
            courseTeacher = res[i].substring(teacherStart, teacherEnd);
            System.out.println(courseTeacher);
            res[i] = res[i].substring(strStart, strEnd);
            String timeStr[];
            timeStr = res[i].split(courseTeacher);
            int aa = 0, bb = 0;
            for (String temp : timeStr) {
                pattern = "星期(\\d)";
                r = Pattern.compile(pattern);
                matcher = r.matcher(temp);
                if (matcher.find()) {
                    String t = matcher.group(0);
                    pattern = "(\\d)";
                    r = Pattern.compile(pattern);
                    matcher = r.matcher(t);
                    if (matcher.find()) {
                        String tempt = matcher.group(0);
                        aa = Integer.parseInt(tempt);
                    }

                }
                ///
                pattern = "第(.*)节";
                r = Pattern.compile(pattern);
                matcher = r.matcher(temp);
                if (matcher.find()) {
                    String t = matcher.group(0);
                    pattern = "(\\d)+-(\\d)+";
                    r = Pattern.compile(pattern);
                    matcher = r.matcher(t);
                    if (matcher.find()) {
                        String tempt = matcher.group(0);
                        String ttt[] = tempt.split("-");
                        bb = Integer.parseInt(ttt[1]);
                        bb = bb / 2;
                    }

                }
                //
                try {
                    myDB.change("ctable", bb, courseName, "w" + Integer.toString(aa), true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //
                operateTime = operateTime + temp + "+";
            }
            operateTime = operateTime.substring(0, operateTime.length() - 1);
            System.out.println(operateTime);
            //

            try {
                myDB.insertCourse(courseID, courseName, courseType, courseStatus, courseMode, courseTeacher, operateTime);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //
        }

        output();
    }

    void initDB() {

    }

    List output() {
        return output;
    }
}
