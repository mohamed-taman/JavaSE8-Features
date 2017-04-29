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
package eg.com.tm.java8.features.miscellaneous;

public class JoinerMethod {

	public static void main(String[] args) {

		String stooges = String.join(" and ", "Larry", "Curly", "Moe");
		System.out.println(stooges);
		
		String[] states = {"California", "Oregon", "Washington"};
		String statesList = String.join(",", states);
		System.out.println(statesList);
		
	}		
}
