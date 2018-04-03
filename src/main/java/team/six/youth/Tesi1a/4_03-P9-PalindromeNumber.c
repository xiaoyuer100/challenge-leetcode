#include <stdlib.h>
#include <stdio.h>
bool isPalindrome(int x);
int main(){
int x=101;
printf("%s\n","start" );
if (isPalindrome(x))
{
    printf("%s\n","true" );
}else{
   printf("%s\n","flase" );  
}
}

//如果遇到反转类似的，使用乘法是最快的 算法的复杂度为logN  
bool isPalindrome(int x) {
    if(x<0){
        return false;
    }else if(x<10){
        return true;
    }else{
        int temp=x;
        int y=0;
        while(x!=0){
            y=y*10+x%10;
            x=x/10;
        }
        if (y==temp)
        {
            return true;
        }else{
            return false;
        }
    }
}

 //还一种是按相对位置进行对比 
 //int size=0;
 //    while(x >=1 || x < -1)
 //    {
 //    x  = x / 10;
 //    size++;
 //    }
 //    char buf[size];
 //    sprintf(buf, "%d", z); 
 //    for (int i = 0; i <=size; ++i)
 //        {   
 //            printf(" %d i =%c\n",i,buf[1]); 
 //            printf("%d\n",size-1 );
 //            printf("buf[size]=%c\n",buf[size-1]);   
 //            if ((buf[i]-buf[size-1])!=0){
 //                return false;
 //            }
 //            size=size-1;
 //        }
 //        return true;