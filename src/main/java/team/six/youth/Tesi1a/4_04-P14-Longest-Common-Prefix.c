//求最短前缀  这题拿到的时候完全无思路    选取其中任一字符串遍历，以其长度开始匹配 取共有的最长为返回值
char* longestCommonPrefix(char** strs, int strsSize) {
    char* str=strs[0];  
    int i,j;  
    if(strsSize==0){return NULL;}  
    //遍历字符串数组
    for(i=1;i<strsSize;i++){  
        j=0;  
        //这里这三句代码堪称经典  匹配前缀
        while(str[j] && strs[i][j] && str[j]==strs[i][j])
            {
                j++;
            }  
        str[j]=0;//末尾置位0  
    }  
    return str;  
}