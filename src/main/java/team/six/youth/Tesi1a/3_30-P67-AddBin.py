#!/usr/bin/env python
#coding: utf-8


class Solution(object):
    def addBinary(self, a, b):
    	return bin(int(a,2)+int(b,2))[2:]//由于输出是以0b开头的需要截掉前两位