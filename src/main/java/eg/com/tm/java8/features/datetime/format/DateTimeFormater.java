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
package eg.com.tm.java8.features.datetime.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 *
 * @author mohamed_taman
 */
public class DateTimeFormater {

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
        System.out.println(df.format(currentDate));

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter dt = DateTimeFormatter.ISO_TIME;
        System.out.println(dt.format(currentTime));

        LocalDateTime currentDT = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(dtf.format(currentDT));

        DateTimeFormatter f_long = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(f_long.format(currentDT));

        DateTimeFormatter f_short = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(f_short.format(currentDT));
        
        String fr_short = f_short.withLocale(Locale.FRENCH).format(currentDT);
        String fr_long = f_long.withLocale(Locale.FRENCH).format(currentDT);
        
        System.out.println(fr_short);
        System.out.println(fr_long);
        
        DateTimeFormatterBuilder b = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.DAY_OF_YEAR)
                .appendLiteral("||")
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral("||")
                .appendValue(ChronoField.YEAR);
        
        DateTimeFormatter f = b.toFormatter();
        System.out.println(f.format(currentDT));
               

    }
}
