package team.six.youth.xiaorui;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//StampCombinationCount
public class Wow {
    private static int USED1 = 0xff<<24;
    private static int USED2 = 0xff<<16;
    private static int NUM1 = 0xff << 8;
    private static int NUM2 = 0xff;
    public Set<Integer> StampCombinationCount(int nums1,int price1,int nums2,int price2){
        int initial = 0x00000000;
        initial = initial | (nums1 << 8) | nums2;
        return StampCombinationCount(initial,nums1+nums2);
    }

    public Set<Integer> StampCombinationCount(int initial,int total){
        Set<Integer> result = new HashSet<Integer>();
        result.add(initial);
        for(int i=0;i<total;i++){
            for (Integer res:result.stream().collect(Collectors.toList())) {
                int used1 = (res & USED1) >> 24;
                int used2 = (res & USED2) >> 16;
                int num1 = (res & NUM1) >> 8;
                int num2 = res & NUM2;
                int target = 0;
                if(used1+used2 == i){
                    if(num1>0){
                        target = ((num1 - 1) << 8) | ((used1 + 1) << 24) | (used2 << 16) | num2;
                        result.add(target);
                    }
                    if(num2>0){
                        target = (num2 - 1) | ((used2 + 1) << 16) | (used1 << 24) | (num1 << 8);
                        result.add(target);
                    }

                }

            }
        }


        return result;
    }


    public static void main(String []args){
        new Wow().StampCombinationCount(4,3,3,5).stream().sorted().map(x->Integer.toBinaryString(x)).forEach(System.out::println);
        new Wow().StampCombinationCount(4,3,3,5).stream().mapToInt(x->(((x&USED1)>>24)*3 + ((x&USED2)>>16)*5)).sorted().forEach(System.out::println);
    }
}
