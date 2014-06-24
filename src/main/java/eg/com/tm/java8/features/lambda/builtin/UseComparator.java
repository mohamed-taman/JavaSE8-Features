/*
 * Copyright (C) 2014 mohamed_taman
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
package eg.com.tm.java8.features.lambda.builtin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mohamed_taman
 */
public class UseComparator {

    public static void main(String[] args) {

        List<String> values = new ArrayList();
        values.add("AAA");
        values.add("bbb");
        values.add("CCC");
        values.add("ddd");
        values.add("EEE");

        //Case sensitive sort operation
        Collections.sort(values);

        System.out.println("Simple sort:");
        print(values);

        // Case insensetive sort operation with anonymous class
//        Collections.sort(values, new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareToIgnoreCase(o2);
//            }
//        });
                
        // Case insensetive sort operation with Lambda
        Collections.sort(values,
                        (String o1, String o2) -> o1.compareToIgnoreCase(o2));

        System.out.println("Sort with Comparator");
        print(values);
    }

    /**
     * Function to print provided data.
     * @param data to be printed
     */
    private static void print(Collection<String> data) {

        for (String value : data) {
            System.out.println(value);
        }
    }
}
