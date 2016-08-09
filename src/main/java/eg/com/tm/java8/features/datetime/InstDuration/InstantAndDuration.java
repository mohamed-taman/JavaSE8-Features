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
package eg.com.tm.java8.features.datetime.InstDuration;

import java.time.Duration;
import java.time.Instant;
import static java.time.Instant.now;

/**
 *
 * @author mohamed_taman
 */
public class InstantAndDuration {

    public static void main(String[] args) throws InterruptedException {

        Instant start = now();
        System.out.println(start);
        
        Thread.sleep(1000);
        
        Instant end = now();
        System.out.println(end);
        
        Duration elapsed = Duration.between(start, end);
        System.out.println("Elapsed: "+ elapsed.toMillis() +" milliseconds");
    }
}
