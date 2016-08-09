/*
 * Copyright (C) 2016 mohamed_taman
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
package eg.com.tm.java8.features.datetime.localdt;

import static java.time.LocalDate.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author mohamed_taman
 */
public class LocalDateAndTime {

    public static void main(String[] args) throws InterruptedException {

        LocalDate currentDate = now();
        System.out.println(currentDate);

        LocalDate specificDate = of(2016, 1, 1);
        System.out.println(specificDate);

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        LocalTime specificTime = LocalTime.of(14, 0, 45);
        System.out.println(specificTime);

        LocalDateTime currentDT = LocalDateTime.now();
        System.out.println(currentDT);

        LocalDateTime specificDT = LocalDateTime.of(specificDate, specificTime);
        System.out.println(specificDT);

    }
}
