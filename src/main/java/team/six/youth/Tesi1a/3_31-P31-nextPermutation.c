/*************************************************************************
    > File Name: Substring.c
    > Author: Tesi1a
    > Mail: tangsilian@gmail.com 
    > Created Time: 2018-03-31 21:50
 ************************************************************************/

#include<stdio.h>
#include<string.h>



void nextPermutation(int* nums, int numsSize);

int main(int argc, char const *argv[])
{
    int a[]={3,2,5,4,2,1};
    int numsSize=sizeof(a)/sizeof(a[0]) ;
    printf("原数列长度：%d\n", numsSize);
    nextPermutation( a, numsSize) ;
     printf("下一个序列");
    for (int i = 0; i < numsSize; ++i)
    {
        printf("%d", a[i]);
    }
    return 0;
}

void nextPermutation(int* nums, int numsSize) {  
    int j,i=numsSize-1,tmp;  
    //找到第一个逆序的位置
    while(i>0 && nums[i]<=nums[i-1])i--;  
    //交换其与大于自己的最小值
    if(i!=0){  
        j=numsSize-1;  
        while(j>=i && nums[j]<=nums[i-1])j--;  
        tmp=nums[j];  
        nums[j]=nums[i-1];  
        nums[i-1]=tmp;  
    }  
    j=numsSize-1;  
    while(i<j){ 
    //从中间开始交换，因为本来就是升序的 
        tmp=nums[i];  
        nums[i]=nums[j];  
        nums[j]=tmp;  
        i++;j--;  
    }  
}  