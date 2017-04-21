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
package eg.com.tm.java8.features.stream.adv.model;

import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author mohamed_taman
 */
public class Task {

    public static enum Status {
        OPEN, CLOSED
    };

    private final Status status;

    private final Integer points;

    Task(final Status status, final Integer points) {
        this.status = status;
        this.points = points;
    }

    public Integer getPoints() {
        return points;

    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d]", status, points);
    }

    public static final Collection<Task> getTasks() {

        return Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8));
    }
}
