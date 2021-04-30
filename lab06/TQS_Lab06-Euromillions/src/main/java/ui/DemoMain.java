package ui;

import euromillions.CuponEuromillions;
import euromillions.Dip;
import euromillions.EuromillionsDraw;

import java.util.logging.Logger;
import java.util.logging.Level;

public class DemoMain {

    /**
     * demonstrates a client for ramdom euromillions bets
     */
    private static final Logger logger = Logger.getLogger(DemoMain.class.getName());

    public static void main(String[] args) {

        // played sheet
        CuponEuromillions thisWeek = new CuponEuromillions();
        logger.log(Level.INFO, "Betting with three random bets...");
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());

        // simulate a random draw
        EuromillionsDraw draw = EuromillionsDraw.generateRandomDraw();

        //report results
        logger.log(Level.INFO, "You played: \n");
        logger.log(Level.INFO, thisWeek.format());

        logger.log(Level.INFO, "Draw results: \n");
        logger.log(Level.INFO, draw.getDrawResults().format());

        logger.log(Level.INFO, "Your score: \n");
        for (Dip dip : draw.findMatches(thisWeek)) {
            logger.log(Level.INFO, dip.format());

        }
    }
}
