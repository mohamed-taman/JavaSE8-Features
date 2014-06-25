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

package eg.com.tm.java8.features.lambda.impl;

import eg.com.tm.java8.features.lambda.interfaces.CalculatorInterface;
import static java.lang.System.out;

/**
 *
 * @author mohamed_taman
 */
public class UseCalculatorInterface {

   
    public static void main(String[] args) {
        
        CalculatorInterface calc = (v1,v2) -> {
            int result = v1 * v2;
            out.println("The calculation result is: "+ result);
        };
        
        calc.doCalculate(10, 5);
    }
    
}
