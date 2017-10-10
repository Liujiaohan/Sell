package com.liujiaohan.sell.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KeyUtilTest {
    @Test
    public void genUniqueKey() throws Exception {
        System.out.print("haha"+KeyUtil.genUniqueKey());
    }

}