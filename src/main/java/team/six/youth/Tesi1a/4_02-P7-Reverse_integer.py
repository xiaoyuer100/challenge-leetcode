#!/usr/bin/env python
#coding: utf-8

class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        反转整数的核心思路是取出该位的数字后进行，直接乘10加1会特别顺利
        题意2的32次方
        """
        count = 0
        s = str(x)
        if s[0] == '-':
            for i in range(len(s) - 1):
                count = count * 10 + int(s[-1 - i])
            if count > 2 ** 31:
                return 0
            return -count
        else:
            for i in range(len(s)):
                print i
                count=10*count+int(s[-i-1],10)
            if count > 2 ** 31 - 1:
                    return 0
            return count

if __name__ == '__main__':
    x=2132132132
    so=Solution();
    print so.reverse(x)