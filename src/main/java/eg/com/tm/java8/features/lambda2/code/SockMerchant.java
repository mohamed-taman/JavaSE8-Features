/*
 * Copyright (C) 2018 mohamed_taman
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

package eg.com.tm.java8.features.lambda2.code;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class SockMerchant is to show how we can use local variables inside lambda expression.
 *
 * @author mohamed_taman
 */
public class SockMerchant {


    /*
     * This method receives a socks arrays and return the number of each pairs in the arrays.
     * e.g. Socks array = {10,20, 20, 10, 10, 30, 50, 10, 20}
     * method should return 3
     * as we have pair of 10 twice and pair of 20 once.
     */

    private static int sockMerchant(int[] ar) {

        Set<Integer> colors = new HashSet<>();
        AtomicInteger pairs = new AtomicInteger(0);

        Arrays.stream(ar).forEach(color -> {
            if (!colors.contains(color))
                colors.add(color);
            else {
                colors.remove(color);
                pairs.set(pairs.incrementAndGet());
            }
        });

        return pairs.get();
    }


    public static void main(String[] args) {

        int[] numbers = new int[]{10,20, 20, 10, 10, 30, 50, 10, 20};

        System.err.println(sockMerchant(numbers));

    }


}
