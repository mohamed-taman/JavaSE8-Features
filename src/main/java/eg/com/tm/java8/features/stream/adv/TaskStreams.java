/*
 * Copyright (C) 2017 mohamed_taman
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
package eg.com.tm.java8.features.stream.adv;

import eg.com.tm.java8.features.stream.adv.model.Task;
import static eg.com.tm.java8.features.stream.adv.model.Task.Status.OPEN;
import static eg.com.tm.java8.features.stream.adv.model.Task.getTasks;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author mohamed_taman
 */
public class TaskStreams {

    private static Collection<Task> tasks = getTasks();

    public static void main(String[] args) {

        // Calculate total points of all active tasks using sum()
        final long totalPointsOfOpenTasks = tasks
                .stream()
                .filter(task -> task.getStatus().equals(OPEN))
                .mapToInt(Task::getPoints)
                .sum();

        System.out.println("Total points: " + totalPointsOfOpenTasks);

        //------------------------------------------------------------
        // Calculate total points of all tasks
        final double totalPoints = tasks
                .stream()
                .parallel()
                .map(task -> task.getPoints()) // or map( Task::getPoints )
                .reduce(0, Integer::sum);

        System.out.println("Total points (all tasks): " + totalPoints);

//---------------------------------------------------------------------------
// Group tasks by their status
        final Map< Task.Status, List<Task>> map = tasks
                .stream()
                .collect(Collectors.groupingBy(Task::getStatus));

        System.out.println(map);
//---------------------------------------------------------------------------

// Calculate the weight of each tasks (as percent of total points)
        final Collection<String> result = tasks
                .stream()                                    // Stream<String>
                .mapToInt(Task::getPoints)                   // IntStream
                .asLongStream()                              // LongStream
                .mapToDouble(points -> points / totalPoints) // DoubleStream
                .boxed()                                     // Stream<Double>
                .mapToLong(weigth -> (long) (weigth * 100))  // LongStream
                .mapToObj(percentage -> percentage + "%")    //Stream<String>
                .collect(Collectors.toList());               // List<String>

        System.out.println(result);

    }

}
