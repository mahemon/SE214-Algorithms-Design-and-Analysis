#include <stdio.h>

// Recusive function to find peak in the array
int findPeakElement(int A[], int low, int high, int n)
{
	// find mid element
	int mid = (low + high) / 2;

	// check if mid element is greater than its neighbors
	if ((mid == 0 || A[mid - 1] <= A[mid]) &&
		(mid == n - 1 || A[mid + 1] <= A[mid]))
		return mid;

	// If the left neighbor of mid is greater than the mid element,
	// then find the peak recursively in the left sub-array
	if (mid - 1 >= 0 && A[mid - 1] > A[mid])
		return findPeakElement(A, low, mid - 1, n);

	// If the right neighbor of mid is greater than the mid element,
	// then find the peak recursively in the right sub-array
	return findPeakElement(A, mid + 1, high, n);
}

// main function
int main(void)
{
	int A[] = { 8, 9, 10, 2, 5, 6 };
	int n = sizeof(A) / sizeof(A[0]);

	int index = findPeakElement(A, 0, n - 1, n);
	printf("The peak element is %d", A[index]);

	return 0;
}