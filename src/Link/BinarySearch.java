package Link;
//https://www.cnblogs.com/luoxn28/p/5767571.html
public class BinarySearch {

    private int[] array;

    private BinarySearch(int[] array) {
        this.array = array;
    }

    /**
     * 二分查找，找到该值在数组中的下标，否则为-1
     */
    private int findEqual(int target){
        int start=0;
        int end=array.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(target==array[mid]) return mid;
            else if(target>=array[mid]){
                start=mid+1;
            }
            else {
                end=(start+end)/2-1;
            }
        }
        return -1;
    }

//    查找第一个与key相等的元素
    private int findFirstEqual(int target){


        return -1;
    }


    // 查找最后一个等于或者小于key的元素
    static int findLastEqualSmaller(int[] array, int key) {



        return -1;
    }


    public static void main(String[] args) {
        int[] array={0,2,3,5,5,7};
        BinarySearch binarySearch = new BinarySearch(array);
        int i = binarySearch.findEqual(5);
        System.out.println(i);

    }


}
