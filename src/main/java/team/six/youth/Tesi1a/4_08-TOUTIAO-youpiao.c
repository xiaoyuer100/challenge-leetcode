#include<stdio.h>
#include<string.h>


int main(){
 int a=5;
 int b=5;
 int  array[100]; 
 int num=0;

 for (int i = 0; i <= a; ++i)
 {
     for (int j = 0; j<= b; ++j)
     { 
        //不能同时为0
        if (j==0&&i==0)
        {
            continue;
        }
        printf("%d，%d\n", num,i*3+j*5);
        
        array[num]=i*3+j*5;
        for (int z= 0; z < num; ++z)
        {
            //在这里判断如果存在相等的 即不参与进数组
            if (array[num]==array[z])
            {
              printf("相等于%d,%d\n", z,array[z]);
              num=num-1;
            }
        }
        num++; 
     }
 }
 printf("num=%d\n", num);
 return 0;
}



// 遍历单价得解除 取其他值时 两种算法得到的结果不一致
// #include<stdio.h>
// int main()
// {
// int f3,f5,n,s=0;
// int z=0;
// for(n=1;n<=55;n++)
//         {
//         for(f3=0;f3<=5;f3++){
//                 for(f5=0;f5<=8;f5++){
//                         if(f3*3+f5*5==n){
//                              printf("n=%d  z=%d\n",n,z++);
//                              s++;
//                             }
//                     }
//             }
//         }
// printf("共有%d种不同的邮资\n",s);
// }