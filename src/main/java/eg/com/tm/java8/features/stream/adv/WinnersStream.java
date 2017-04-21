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
package eg.com.tm.java8.features.stream.adv;

import eg.com.tm.java8.features.stream.adv.model.Winner;
import static eg.com.tm.java8.features.stream.adv.model.Winner.winners;
import java.util.*;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.*;

/**
 *
 * @author mohamed_taman
 */
public class WinnersStream {

    public static void main(String[] args) {

        // Filter and Map -
        List<String> winnersOfToursLessThan3500km = winners
                .stream()
                .filter(d -> d.getLengthKm() < 3500) // Separate out Tours less than 3500km
                .map(Winner::getName) // Get names of winners
                .collect(toList()); // Return a list

        // Winners of Tours Less than 3500km - [Alberto Contador, Cadel Evans, Bradley Wiggins, Chris Froome, Chris Froome]        
        System.out.println("Winners of Tours Less than 3500km - " + winnersOfToursLessThan3500km);

        //--------------------------------------------------------        
        List<String> winnersOfToursGreaterThan3500km = winners
                .stream()
                .filter(d -> d.getLengthKm() >= 3500)
                .map(Winner::getName)
                .collect(toList());

        // Winners of Tours Greater than 3500km - [Óscar Pereiro, Alberto Contador, Carlos Sastre, Andy Schleck, Vincenzo Nibali, Chris Froome]
        System.out.println("Winners of Tours Greater than 3500km - " + winnersOfToursGreaterThan3500km);

        //--------------------------------------------------------
        // limit - 
        List<Winner> winnerObjectsOfToursLessThan3500kmLimit2 = winners
                .stream()
                .filter(d -> d.getLengthKm() < 3500)
                .limit(2)
                .collect(toList());

        // winnerObjectsOfToursLessThan3500kmLimit2 [Alberto Contador, Cadel Evans]
        System.out.println("winnerObjectsOfToursLessThan3500kmLimit2 " + winnerObjectsOfToursLessThan3500kmLimit2);

        //--------------------------------------------------------
        List<String> firstTwoWinnersOfToursLessThan3500km = winners
                .stream()
                .filter(d -> d.getLengthKm() < 3500)
                .map(Winner::getName)
                .limit(2)
                .collect(toList());

        // firstTwoWinnersOfToursLessThan3500km - [Alberto Contador, Cadel Evans]
        System.out.println("firstTwoWinnersOfToursLessThan3500km - " + firstTwoWinnersOfToursLessThan3500km);

        //--------------------------------------------------------
        // filter by distinct
        List<String> distinctwinners = winners
                .stream()
                .map(Winner::getName)
                .distinct()
                .collect(toList());
        System.out.println("distinctwinners - " + distinctwinners);

        //--------------------------------------------------------
        long numberOfDistinceWinners = winners
                .stream()
                .map(Winner::getName)
                .distinct()
                .count();

        // numberOfDistinceWinners - 8
        System.out.println("numberOfDistinceWinners - " + numberOfDistinceWinners);

        //--------------------------------------------------------
        // skip records
        List<Winner> skipEveryOtherTDFWinner = winners
                .stream()
                .skip(2)
                .collect(toList());

        // skipEveryOtherTDFWinner - [Carlos Sastre, Alberto Contador, Andy Schleck, Cadel Evans, Bradley Wiggins, Chris Froome, Vincenzo Nibali, Chris Froome, Chris Froome]
        System.out.println("skipEveryOtherTDFWinner - " + skipEveryOtherTDFWinner);

        //--------------------------------------------------------
        List<String> mapWinnerYearNamesToList = winners
                .stream()
                .map(w -> w.getYear() + " - " + w.getName())
                .collect(toList());

        // mapWinnerYearNamesToList [2006 - Óscar Pereiro, 2007 - Alberto Contador, 2008 - Carlos Sastre, 2009 - Alberto Contador, 2010 - Andy Schleck, 2011 - Cadel Evans, 2012 - Bradley Wiggins, 2013 - Chris Froome, 2014 - Vincenzo Nibali, 2015 - Chris Froome, 2016 - Chris Froome]
        System.out.println("mapWinnerYearNamesToList " + mapWinnerYearNamesToList);

        //--------------------------------------------------------
        List<Integer> mapWinnerNameLengthToList = winners
                .stream()
                .map(Winner::getName)
                .map(String::length)
                .collect(toList());

        // mapWinnerNameLengthToList [13, 16, 13, 16, 12, 11, 15, 12, 15, 12, 12]
        System.out.println("mapWinnerNameLengthToList " + mapWinnerNameLengthToList);

        //--------------------------------------------------------
        // matching - allMatch, noneMatch
        Optional<Winner> winner2012 = winners.stream().filter(w -> w.getName().contains("Wiggins")).findAny();

        // winner2012 - Bradley Wiggins
        System.out.println("winner2012 - " + winner2012.get());

        //--------------------------------------------------------
        Optional<Integer> winnerYear2014 = winners.stream().map(Winner::getYear).filter(x -> x == 2014).findFirst();
        // winnerYear2014 - 2014
        System.out.println("winnerYear2014 - " + winnerYear2014.get());

        //--------------------------------------------------------
        // reducing - 0 --> initial value
        int totalDistance = winners.stream().map(Winner::getLengthKm).reduce(0, Integer::sum);
        // totalDistance - 38767
        System.out.println("totalDistance - " + totalDistance);

        //--------------------------------------------------------
        Optional<Integer> shortestYear = winners.stream().map(Winner::getLengthKm).reduce(Integer::min);
        // shortestYear - 3360
        System.out.println("shortestYear - " + shortestYear.get());

        //--------------------------------------------------------
        Optional<Integer> longestYear = winners.stream().map(Winner::getLengthKm).reduce(Integer::max);
        // longestYear - 3661
        System.out.println("longestYear - " + longestYear.get());

        //--------------------------------------------------------
        Optional<Winner> fastestWinner = winners.stream().min(Comparator.comparingDouble(Winner::getAveSpeed));
        System.out.println("fastestTDF - " + fastestWinner.get());

        //--------------------------------------------------------
        // shorthand
        OptionalDouble fastestTDF = winners.stream().mapToDouble(Winner::getAveSpeed).min();
        // fastestTDF - 39.0
        System.out.println("fastestTDF - " + fastestTDF.getAsDouble());

        //--------------------------------------------------------
        // groupingby - make a map whose keys are names
        Map<String, List<Winner>> namesVsWinner = winners.stream().collect(groupingBy(Winner::getName));
        // namesVsWinner - {Bradley Wiggins=[Bradley Wiggins], Carlos Sastre=[Carlos Sastre], Cadel Evans=[Cadel Evans], Óscar Pereiro=[Óscar Pereiro], Chris Froome=[Chris Froome, Chris Froome, Chris Froome], Andy Schleck=[Andy Schleck], Alberto Contador=[Alberto Contador, Alberto Contador], Vincenzo Nibali=[Vincenzo Nibali]}
        System.out.println("namesVsWinner - " + namesVsWinner);

        //--------------------------------------------------------
        // join strings
        String allwinnersTeamsCSV = winners.stream().map(Winner::getTeam).collect(joining(", "));
        // allwinnersTeams Caisse d'Epargne–Illes Balears, Discovery Channel, Team CSC, Astana, Team Saxo Bank, BMC Racing Team, Team Sky, Team Sky, Astana, Team Sky, Team Sky
        System.out.println("allwinnersTeams " + allwinnersTeamsCSV);

        //--------------------------------------------------------
        // grouping
        Map<String, List<Winner>> winnersByNationality = winners.stream().collect(groupingBy(Winner::getNationality));
        // winnersByNationality - {Great Britain=[Bradley Wiggins, Chris Froome, Chris Froome, Chris Froome], Luxembourg=[Andy Schleck], Italy=[Vincenzo Nibali], Australia=[Cadel Evans], Spain=[Óscar Pereiro, Alberto Contador, Carlos Sastre, Alberto Contador]}
        System.out.println("winnersByNationality - " + winnersByNationality);

        //--------------------------------------------------------
        Map<String, Long> winsByNationalityCounting = winners.stream().collect(groupingBy(Winner::getNationality, counting()));
        // winsByNationalityCounting - {Great Britain=4, Luxembourg=1, Italy=1, Australia=1, Spain=4}
        System.out.println("winsByNationalityCounting - " + winsByNationalityCounting);
    }

}
