/*
 * Copyright (C) 2018 Mohamed Taman <m.taman@price2spy.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eg.com.tm.java8.features.stream.map.sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Mohamed Taman <m.taman@price2spy.com>
 */
public class MapSorter {

    public static void main(String[] args) {

        final Map<String, Integer> wordCounts = new HashMap<>(5);
        wordCounts.put("Egypt", 100);
        wordCounts.put("Belgrade", 200);
        wordCounts.put("Software", 50);
        wordCounts.put("Technology", 70);
        wordCounts.put("Opportunity", 200);

        /* 
        Now, if I have to sort this map with value in ascending order, then it 
        would be simplest and readable as below:
         */
        Map<String, Integer> sortedByCount = wordCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));

        System.out.println(sortedByCount);

        //sort a map in reverse order
        sortedByCount = wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(sortedByCount);

        /*
        You can see that the  sorted() method takesComparator as an argument, 
        making it possible to sort a map with any kind of value.
         */
        sortedByCount = wordCounts.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(sortedByCount);

    }

}

