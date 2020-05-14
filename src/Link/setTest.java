package Link;


import java.util.*;

public class setTest {
    public static void main(String[] args){

        List<String> person1=new ArrayList<>();
        person1.add("jackie");   //索引为0  //.add(e)
        person1.add("peter");    //索引为1
        person1.add("annie");    //索引为2
        person1.add("martin");   //索引为3
        person1.add("marry");    //索引为4

        List<String> person2=new ArrayList<>();

        person1.add("peter");
        person2.add("annie");


        long startTime = System.currentTimeMillis();    //获取开始时间
        for(int i=0;i<1000000;i++){
            //intersection1(person1, person2);
            intersection1(person1, person2);
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间






    }


    public static List<String> intersection1(List<String> smallList, List<String> bigList) {
        if (bigList != null && !bigList.isEmpty()) {
            Map<String, String> dataMap = new HashMap<String, String>();
            for (String id : bigList) {
                dataMap.put(id, id);
            }

            List<String> newList = new ArrayList<String>();
            for (String id : smallList) {
                if (dataMap.containsKey(id)) {
                    newList.add(id);
                }
            }
            return newList;
        } else {
            return smallList;
        }
    }


    public static List<String> intersection2(List<String> smallList, List<String> bigList){
        HashSet<String> smallSet = new HashSet<>(smallList);
        HashSet<String> bigSet = new HashSet<>(bigList);
        smallSet.retainAll(bigSet);
        return new ArrayList<>(smallSet);


    }



}
