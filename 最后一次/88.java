package MergeSortedArray88;

public class Solution88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int temp[] = new int[m];
	    memcpy(temp, nums1, sizeof(int)*m);
	    bool desc = nums1[0] > nums1[m-1];
	    for (int k = 0, i = 0, j = 0; k < m + n; ++k) {
	        if (i >= m) {
	            nums1[k] = nums2[j++];
	        } else if (j >= n) {
	            nums1[k] = temp[i++];
	        } else if (desc) {
	            nums1[k] = temp[i] >= nums2[j] ? temp[i++] : nums2[j++];
	        } else {
	            nums1[k] = temp[i] <= nums2[j] ? temp[i++] : nums2[j++];
	        }
	    }
	}
	public static void main(String[] args) {
		

	}

}
