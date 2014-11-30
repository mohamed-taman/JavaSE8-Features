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
package eg.com.tm.java8.features.lambda2.staticMthd;

import eg.com.tm.java8.features.lambda2.defltMthd.*;
import static eg.com.tm.java8.features.lambda2.defltMthd.VehicleInterface.getVehicleInfo;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author mohamed_taman
 */
public class StaticMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>(4);

        cars.add(new Car("Mazda 3", "Mazda", 1600, 2008));
        cars.add(new Car("Mazda 6", "Mazda", 2500, 2009));
        cars.add(new Car("Mazda 2", "Mazda", 1400, 2008));
        cars.add(new Car("Mazda X5", "Mazda", 3600, 2014));

        Predicate<Car> pred = (v) -> v.getCC() > 1900 & 
                                                  v.getMakeYear() <= 2009;
        cars.forEach((Car c) -> {
            if (pred.test(c)) {
//                String info = c.getName() 
//                              + ", of Model [" + c.getModel() + "], with "
//                              + c.getCC() + " (litter), manufactured at "
//                              + c.getMakeYear();
                out.println(getVehicleInfo(c));
            }
        });
    }
}
