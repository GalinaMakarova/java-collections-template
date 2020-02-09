package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Данный класс обязан использовать StreamApi из функционала Java 8. Функциональность должна быть идентична
 * {@link SimpleTextStatisticsAnalyzer}.
 */
public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
        return getWords(text).stream().mapToInt(String::length).sum();
    }

    @Override
    public int countNumberOfWords(String text) {
        return getWords(text).size();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return getUniqueWords(text).size();
    }

    @Override
    public List<String> getWords(String text) {
        return Stream.of(text.split("(\\.|,|\\s|!|-|\")+")).collect(Collectors.toList());
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        return new HashSet<>(getWords(text));
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        Map<String, Integer> resultMap = new HashMap<>();
        getWords(text).forEach(word -> resultMap.put(word, (int) getWords(text).stream().filter(word::equals).count()));
        return resultMap;
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        if (direction.equals(Direction.ASC)) {
            return getUniqueWords(text).stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        } else {
            return getUniqueWords(text).stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList());
        }
    }
}
