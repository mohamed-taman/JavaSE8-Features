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
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package eg.com.tm.java8.features.stream.aggregating;

import eg.com.tm.java8.features.stream.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/**
 *
 * @author mohamed_taman
 */
public class SumAndAverage {

    public static void main(String args[]) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Mohamed", 69));
        people.add(new Person("Doaa", 25));
        people.add(new Person("Malik", 6));

        int sum = people.stream()
                .mapToInt(p -> p.getAge())
                .sum();
        System.out.println("Total of ages " + sum);

        OptionalDouble avg = people.stream()
                .mapToInt(p -> p.getAge())
                .average();

        if (avg.isPresent()) {
            System.out.println("Average: " + avg.getAsDouble());
        } else {
            System.out.println("Average was not calculated");
        }
    }
}
