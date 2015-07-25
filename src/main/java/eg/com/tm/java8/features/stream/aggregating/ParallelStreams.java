/*
 * Copyright (C) 2015 mohamed_taman
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
package eg.com.tm.java8.features.stream.aggregating;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mohamed_taman
 */
public class ParallelStreams {

    public static void main(String args[]) {

        System.out.println("Creating list");
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            strings.add("Item " + i);
        }
        strings.stream()
                .parallel()
                .forEach(str -> System.out.println(str));
    }
}
