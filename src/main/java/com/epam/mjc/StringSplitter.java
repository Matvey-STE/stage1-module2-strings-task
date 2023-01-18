package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringBuilder sb = new StringBuilder();
        for (String ch: delimiters){
            sb.append(ch);
        }
        StringTokenizer tokenizer = new StringTokenizer(source, sb.toString());
        List<String> result = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            result.add(tokenizer.nextToken());
        }
        return result;
    }
}
