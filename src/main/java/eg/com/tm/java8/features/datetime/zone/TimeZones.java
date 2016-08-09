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
package eg.com.tm.java8.features.datetime.zone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Set;
import java.util.function.Predicate;

/**
 *
 * @author mohamed_taman
 */
public class TimeZones {

    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        LocalDateTime currentDT = LocalDateTime.now();
        System.out.println(dtf.format(currentDT));
        
        ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT+0"));
        System.out.println(dtf.format(gmt));
        
        ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(dtf.format(ny));
        
        Set<String> zones = ZoneId.getAvailableZoneIds();
        Predicate<String> condition = str -> str.contains("London");
        zones.forEach(z -> {
            if(condition.test(z))
            System.out.println(z);
        });

    }
}
