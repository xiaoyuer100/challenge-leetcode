/*************************************************************************
    > File Name: Substring.c
    > Author: Tesi1a
    > Mail: tangsilian@gmail.com 
    > Created Time: 2018-03-29 21:50
 ************************************************************************/

#include<stdio.h>
#include<string.h>
//自定义bool类型
typedef int bool;
#define TRUE 1
#define FALSE 0
static char  *_default_words[] = {
"rng","uzi",
};
int main(){
    int strsize=3;
    int temp;
    char **type_ptr = NULL;
    char **mytype_ptr=NULL;
    bool flag = FALSE;
    char *s="iaaaarnguziomgrnguzi";
    int zz=0;
    int i=0;
    int point=0;
    //这个变量为什么一直消失
    const int length=strlen(s);
    for (type_ptr = _default_words; *type_ptr != NULL;zz++, type_ptr++) {
   //  length=strlen(s);
        printf("%d,%d,%s\n",zz,length,*type_ptr) ;
    //length=strlen(*type_ptr);
    }
    for(;strsize<=strlen(s);s++,i++){
        point=strlen(s);
        printf("orginal char = %s length =%d point=%d position=%d\n",s,strlen(s),point,i);
        //字符串循环遍历
        mytype_ptr=_default_words;
        temp=0;
        while(temp<=strlen(s)){
        flag=FALSE;
        char newstr[3];
        //此时的s串为
        printf("cut char = %s,temp=%d\n",s,temp);
        strncpy(newstr, s, 3); 
        newstr[3]='\0';
        //拷贝3个长度的字符串到新串
        printf("char的前三位=%s\n",newstr);
        //判断新串是否在字符串数组里
       // int len=length; 
        int myi=0;
        int myj=0;
        for (; *mytype_ptr != NULL;myi++,mytype_ptr++) {
        printf("%d  遍历字符串数组%s\n",myi,*mytype_ptr) ;
        if(!flag&&strcmp(newstr, *mytype_ptr)==0) {
            flag = TRUE;
            printf("%s    前三位在数组中 \n",*mytype_ptr);
            s=s+3;
        } else{
        mytype_ptr[myj]=*mytype_ptr;
        }
        }
        if(!flag){
        printf("开头字母不匹配 下一位为origin \n ");
        temp=temp+3;
        break;
        }
        if (*mytype_ptr == NULL){
       // s=s+3;
        printf("=========anserwer=%d\n",i);
       // s=s+3;
        }
        i=i+3;
        temp=temp+3;
        }
    
    }
    printf("%s\n",s);
    return 0;
}

