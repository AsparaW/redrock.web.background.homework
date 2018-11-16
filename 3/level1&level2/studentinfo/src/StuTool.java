import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StuTool {


    public ArrayList sortByClass(ArrayList<Student> stuList, boolean isUpper, boolean isPrint) {
        if (isUpper == true) {
            Collections.sort(stuList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int leftNum = Integer.parseInt(o1.getClas());
                    int rightNum = Integer.parseInt(o2.getClas());
                    if (leftNum > rightNum) {
                        return 1;
                    } else if (leftNum < rightNum) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
        } else {
            Collections.sort(stuList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int leftNum = Integer.parseInt(o1.getClas());
                    int rightNum = Integer.parseInt(o2.getClas());
                    if (leftNum > rightNum) {
                        return -1;
                    } else if (leftNum < rightNum) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });

        }
        //print
        if (isPrint) print(stuList);
        //print over
        return stuList;
    }

    public ArrayList sortByNum(ArrayList stuList, boolean isUpper, boolean isPrint) {
        if (isUpper == true) {
            Collections.sort(stuList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int leftNum = Integer.parseInt(o1.getStuNum());
                    int rightNum = Integer.parseInt(o2.getStuNum());
                    if (leftNum > rightNum) {
                        return 1;
                    } else if (leftNum < rightNum) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
        } else {
            Collections.sort(stuList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int leftNum = Integer.parseInt(o1.getStuNum());
                    int rightNum = Integer.parseInt(o2.getStuNum());
                    if (leftNum > rightNum) {
                        return -1;
                    } else if (leftNum < rightNum) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });

        }
        //print
        if (isPrint) print(stuList);
        //print over
        return stuList;
    }

    public ArrayList sortByClassThenNum(ArrayList stuList, boolean isUpper, boolean isPrint) {
        stuList = sortByClass(stuList, isUpper, false);


        if (isUpper == true) {
            Collections.sort(stuList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int leftNum = Integer.parseInt(o1.getStuNum());
                    int rightNum = Integer.parseInt(o2.getStuNum());
                    if (o1.getClas() == o2.getClas()) {
                        if (leftNum > rightNum) {
                            return 1;
                        } else if (leftNum < rightNum) {
                            return -1;
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                }
            });
        } else {
            Collections.sort(stuList, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    int leftNum = Integer.parseInt(o1.getStuNum());
                    int rightNum = Integer.parseInt(o2.getStuNum());
                    if (o1.getClas() == o2.getClas()) {
                        if (leftNum > rightNum) {
                            return -1;
                        } else if (leftNum < rightNum) {
                            return 1;
                        } else {
                            return 0;
                        }
                    } else {
                        return 0;
                    }

                }
            });

        }

        if (isPrint) print(stuList);
        return stuList;
    }


    public void writeToFile(ArrayList<Student> temp) {
        File file = new File("studentinfo_COPY.txt");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            BufferedOutputStream mybos = new BufferedOutputStream(out);
            ObjectOutputStream myoos = new ObjectOutputStream(mybos);
            myoos.writeObject(temp);
            myoos.flush();
            myoos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入成功！（studentinfo_COPY.txt）");

    }

    public ArrayList readToFile() {

        ArrayList<Student> stuList = new ArrayList<>();
        File file = new File("studentinfo.txt");
        try {
            FileInputStream in = new FileInputStream(file);
            BufferedInputStream mybis = new BufferedInputStream(in);
            ObjectInputStream myois = new ObjectInputStream(mybis);
            stuList = (ArrayList<Student>) myois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件！（注意，请命名为studentinfo.txt）");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int max = 0;
        for (Student temp : stuList) {
            if (temp.getId() > max) max = temp.getId();
        }
        StuController.maxIndex = ++max;
        System.out.println("已读取到程序！即将为您按学号升序遍历！");
        sortByNum(stuList, true, true);
        return stuList;
    }

    public void print(ArrayList<Student> temp, boolean isPrintId) {
        for (Student tempStudent : temp) {
            if (isPrintId) {
                System.out.println("ID: >>>" + tempStudent.getId() + "<<<   班级:" + tempStudent.getClas() + "   学号:" + tempStudent.getStuNum() + "  " + tempStudent.getName() + "     " + tempStudent.getGender() + "    " + Integer.toString(tempStudent.getAge()) + "岁");
            } else {
                System.out.println("班级:" + tempStudent.getClas() + "   学号:" + tempStudent.getStuNum() + "  " + tempStudent.getName() + "     " + tempStudent.getGender() + "    " + Integer.toString(tempStudent.getAge()) + "岁");

            }
        }
    }

    private void print(ArrayList<Student> temp) {
        //遍历方式1
        for (Student tempStudent : temp) {
            System.out.println("班级:" + tempStudent.getClas() + "   学号:" + tempStudent.getStuNum() + "  " + tempStudent.getName() + "     " + tempStudent.getGender() + "    " + Integer.toString(tempStudent.getAge()) + "岁");
        }
        //遍历方式2

/*        int length = temp.size();
        for (int i=0;i<length;i++){
            //DO_SOMETHING
        }*/

        //遍历方式3
/*        Iterator myit = temp.iterator();
        while (myit.hasNext()){
            myit.next();
            //DO_SOMETHING
        }*/

/*
        MAP也有多种遍历方式，要先转为set
        （keyset,valueset），key/value分别遍历
        ，或者用getentryset，然后getkey，getvalue

        也可以存到entryset/keyset/valueset后用
        iterator再遍历，或者用foreach遍历。*/

    }


}
