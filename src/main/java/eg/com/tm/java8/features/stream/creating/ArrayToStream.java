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
package eg.com.tm.java8.features.stream.creating;

import eg.com.tm.java8.features.stream.model.Person;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author mohamed_taman
 */
public class ArrayToStream {

    public static void main(String args[]) {

        Person[] people = {
            new Person("Mohamed", 69),
            new Person("Doaa", 25),
            new Person("Malik", 6)};

//        for (int i = 0; i < people.length; i++) {
//            System.out.println(people[i].getInfo());
//        }
//        Stream<Person> stream = Stream.of(people);
        Stream<Person> stream = Arrays.stream(people);
        stream.forEach(p -> System.out.println(p.getInfo()));
    }

}
