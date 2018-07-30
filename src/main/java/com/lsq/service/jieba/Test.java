package com.lsq.service.jieba;

import java.io.IOException;

import com.huaban.analysis.jieba.JiebaSegmenter;

/**
 * 
 * jieba分词
 *
 */
public class Test {
	public static void  main(String[] args) throws IOException {
        String text = "前任拉甘送苏宁首败落后恒大6分争冠难了";
        JiebaSegmenter segmenter = new JiebaSegmenter();
        System.out.println(segmenter.sentenceProcess(text));
    }
}
