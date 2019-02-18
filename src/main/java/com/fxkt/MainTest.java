package com.fxkt;

public class MainTest {
    public static void main(String[] args) {
        int h = "58785313481".hashCode();
        h ^= h >>> 20 ^ h >>> 12;
        int hash = h ^ h >>> 7 ^ h >>> 4;
        int index = hash & (4 - 1);
        long tableOrder = index + 1;//获取表序号(1-tableCount)
        System.out.println(tableOrder);
    }
}
