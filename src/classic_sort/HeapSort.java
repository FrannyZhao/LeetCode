package classic_sort;

import java.util.Arrays;

public class HeapSort {
    public int[] sort(int[] srcArr) {
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        for (int i = (int) Math.floor(arr.length / 2f); i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
//        System.out.println("built result " + Arrays.toString(arr));
        int length = arr.length;
        for (int i = length - 1; i > 0; i--) {
            //将堆顶元素与末位元素调换
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            length--; //数组长度-1 隐藏堆尾元素
            heapify(arr, 0, length);
        }
        return arr;
    }
    
    private void heapify(int[] arr, int index, int length) {
        int leftChild = 2 * index + 1;//左子节点下标
        int rightChild = 2 * index + 2;//右子节点下标
        int present = index;//要调整的节点下标
        //调整左边
        if (leftChild < length && arr[leftChild] > arr[present]) {
            present = leftChild;
        }
        //调整右边
        if (rightChild < length && arr[rightChild] > arr[present]) {
            present = rightChild;
        }
        //如果下标不相等 证明调换过了
        if (present != index) {
            //交换值
            int temp = arr[index];
            arr[index] = arr[present];
            arr[present] = temp;
            //继续调整
            heapify(arr, present, length);
        }
    }
}
