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
package eg.com.tm.java8.features.lambda2.defltMthd;

/**
 *
 * @author mohamed_taman
 */
public interface VehicleInterface {

    String getName();

    void setName(String name);

    String getModel();

    void setModel(String name);

    int getCC();

    void setCC(int name);

    int getMakeYear();

    void setMakeYear(int name);

    default String getInfo() {
        return getName() + ", of Model [" + getModel() + "], with "
                + getCC() + " (litter), manufactured at "
                + getMakeYear();
    }

    static String getVehicleInfo(Car c) {
        return c.getName()
                + ", of Model [" + c.getModel() + "], with "
                + c.getCC() + " (litter), manufactured at "
                + c.getMakeYear();
    }
}
