/*
Title: Game Tools
Author: Draedn Groves
Date: Feb.17th/2024
Purpose: Game Tools
 */

import java.util.Random;
public class Game {
    public static int player1TotalSum = 0;
    public static int player2TotalSum = 0;
    public static int gamesPlayed = 1;

    public static int[][] player1Game1DartsAndValues = new int[256][2];
    public static int[][] player1Game2DartsAndValues = new int[256][2];
    public static int[][] player1Game3DartsAndValues = new int[256][2];
    public static int[][] player1Game4DartsAndValues = new int[256][2];
    public static int[][] player1Game5DartsAndValues = new int[256][2];

    public static int[][] player2Game1DartsAndValues = new int[256][2];
    public static int[][] player2Game2DartsAndValues = new int[256][2];
    public static int[][] player2Game3DartsAndValues = new int[256][2];
    public static int[][] player2Game4DartsAndValues = new int[256][2];
    public static int[][] player2Game5DartsAndValues = new int[256][2];

    public static int[][] player2DartsAndValues = new int[256][2];
    public static int[][] player1DartsAndValues = new int[256][2];

    private static int currentIndex = 0;
    public static String dartBoardRegionName = "";
    public static int[] dartBoardValues = {
            1, 2, 3,
            2, 4, 6,
            3, 6, 9,
            4, 8, 12,
            5, 10, 15,
            6, 12, 18,
            7, 14, 21,
            8, 16, 24,
            9, 18, 27,
            10, 20, 30,
            11, 22, 33,
            12, 24, 36,
            13, 26, 39,
            14, 28, 42,
            15, 30, 45,
            16, 32, 48,
            17, 34, 51,
            18, 36, 54,
            19, 38, 57,
            20, 40, 60,
            25, 50, 0, 0
    };

    public static String[] dartBoardRegions = {
            "Single 1", "Double 1", "Triple 1",
            "Single 2", "Double 2", "Triple 2",
            "Single 3", "Double 3", "Triple 3",
            "Single 4", "Double 4", "Triple 4",
            "Single 5", "Double 5", "Triple 5",
            "Single 6", "Double 6", "Triple 6",
            "Single 7", "Double 7", "Triple 7",
            "Single 8", "Double 8", "Triple 8",
            "Single 9", "Double 9", "Triple 9",
            "Single 10", "Double 10", "Triple 10",
            "Single 11", "Double 11", "Triple 11",
            "Single 12", "Double 12", "Triple 12",
            "Single 13", "Double 13", "Triple 13",
            "Single 14", "Double 14", "Triple 14",
            "Single 15", "Double 15", "Triple 15",
            "Single 16", "Double 16", "Triple 16",
            "Single 17", "Double 17", "Triple 17",
            "Single 18", "Double 18", "Triple 18",
            "Single 19", "Double 19", "Triple 19",
            "Single 20", "Double 20", "Triple 20",
            "Bullseye", "Double Bullseye", "Wide Miss", "No Stick"};

    public static int[] outShootValues = {
            170,
            169,
            168,
            167,
            166,
            165,
            164,
            163,
            162,
            161,
            160,
            159,
            158,
            157,
            156,
            155,
            154,
            153,
            152,
            151,
            150,
            149,
            148,
            147,
            146,
            145,
            144,
            143,
            142,
            141,
            140,
            139,
            138,
            137,
            136,
            135,
            134,
            133,
            132,
            131,
            130,
            129,
            128,
            127,
            126,
            125,
            124,
            123,
            122,
            121,
            120,
            119,
            118,
            117,
            116,
            115,
            114,
            113,
            112,
            111,
            110,
            109,
            108,
            107,
            106,
            105,
            104,
            103,
            102,
            101,
            100,
            99,
            98,
            97,
            96,
            95,
            94,
            93,
            92,
            91,
            91,
            89,
            88,
            87,
            86,
            85,
            84,
            83,
            82,
            81,
            80,
            79,
            78,
            77,
            76,
            75,
            74,
            73,
            72,
            71,
            70,
            69,
            68,
            67,
            66,
            65,
            64,
            63,
            62,
            61,
            60,
            59,
            58,
            57,
            56,
            55,
            54,
            53,
            52,
            51,
            50,
            49,
            48,
            47,
            46,
            45,
            44,
            43,
            42,
            41,
            40,
            39,
            38,
            37,
            36,
            35,
            34,
            33,
            32,
            31,
            30,
            29,
            28,
            27,
            26,
            25,
            24,
            23,
            22,
            21,
            20,
            19,
            18,
            17,
            16,
            15,
            14,
            13,
            12,
            11,
            10,
            9,
            8,
            7,
            6,
            5,
            4,
            3,
            2,
    };


    public static String[] outShootOptions = {
            "T20, T20, Double Bullseye",
            "T20, T19, Double Bullseye",
            "IMPOSSIBLE",
            "T20, T19, Bullseye",
            "IMPOSSIBLE",
            "IMPOSSIBLE",
            "T20, T18, Bullseye",
            "IMPOSSIBLE",
            "IMPOSSIBLE",
            "T20, T17, Bullseye",
            "T20, T20, D20",
            "IMPOSSIBLE",
            "T20, T20, D19",
            "T20, T19, D20",
            "T20, T20, D18",
            "T20, T19, D19",
            "T20, T18, D20",
            "T20, T19, D18",
            "T20, T20, D16",
            "T20, T17, D20",
            "T20, T18, D18",
            "T20, T19, D16",
            "T20, T20, D14",
            "T20, T17, D18",
            "T20, T18, D16",
            "T20, T19, D14",
            "T20, T20, D12",
            "T19, T18, D16",
            "T20, T14, D20",
            "T20, T19, D12",
            "T20, T20, D10",
            "T19, T14, D20",
            "T20, T18, D12",
            "T20, T19, D10",
            "T20, T20, D8",
            "T20, T17, D12",
            "T20, T14, D16",
            "T20, T19, D8",
            "T20, T16, D12",
            "T20, T13, D16",
            "T20, T18, D8",
            "T19, T16, D12",
            "T18, T14, D16",
            "T20, T17, D8",
            "T19, T15, D12",
            "T18, T13, D16",
            "T20, T16, D8",
            "T19, T14, D12",
            "T18, T18, D7",
            "T20, T11, D14",
            "T20, S20, D20",
            "T19, T12, D13",
            "T20, S18, D20",
            "T20, S17, D20",
            "T20, S16, D20",
            "T19, S18, D20",
            "T20, S14, D20",
            "T19, S16, D20",
            "T20, T12, D8",
            "T19, S14, D20",
            "T20, S10, D20",
            "T20, S9, D20",
            "T19, S19, D16",
            "T20, S15, D16",
            "T20, S6, D20",
            "T19, S8, D20",
            "T20, T12, D4",
            "T17, S12, D20",
            "T20, S10, D16",
            "T17, S10, D20",
            "T20, D20",
            "T19, S10, D16",
            "T20, D19",
            "T19, D20",
            "T20, D18",
            "T19, D19",
            "T18, D20",
            "T19, D18",
            "T20, D16",
            "T17, D20",
            "T17, D20",
            "T19, D16",
            "T16, D20",
            "T17, D18",
            "T18, D16",
            "T15, D20",
            "T20, D12",
            "T17, D16",
            "T14, D20",
            "T19, D12",
            "T20, D10",
            "T13, D20",
            "T18, D12",
            "T15, D16",
            "T20, D8",
            "T17, D12",
            "T14, D16",
            "T19, D8",
            "T16, D12",
            "T13, D16",
            "T18, D8",
            "T19, D6",
            "T20, D4",
            "T17, D8",
            "T14, D12",
            "T19, D4",
            "T16, D8",
            "T13, D12",
            "T10, D16",
            "T15, D8",
            "S20, D20",
            "S19, D20",
            "S18, D20",
            "S17, D20",
            "T16, D4",
            "S15, D20",
            "S14, D20",
            "S12, D20",
            "S12, D20",
            "S11, D20",
            "S10, D20",
            "S9, D20",
            "S8, D20",
            "S15, D16",
            "S14, D16",
            "S13, D16",
            "S12, D16",
            "S11, D16",
            "S10, D16",
            "S9, D16",
            "D20",
            "S7, D16",
            "D19",
            "S5, D16",
            "D18",
            "S3, D16",
            "D17",
            "S1, D16",
            "D16",
            "S7, D12",
            "D15",
            "S13, D8",
            "D14",
            "S11, D8",
            "D13",
            "S9, D8",
            "D12",
            "S7, D8",
            "D11",
            "S5, D8",
            "D10",
            "S3, D8",
            "D9",
            "S13, D2",
            "D8",
            "S7, D4",
            "D7",
            "S5, D4",
            "D6",
            "S3, D4",
            "D5",
            "S1, D4",
            "D4",
            "S3, D2",
            "D3",
            "S1, D2",
            "D2",
            "S1, D1",
            "D1"
    };


    public static String indexOutShootsOnPlayer1CurrentScore() {

        for (int i = 0; i < outShootValues.length; i++) {
            if (outShootValues[i] == Main.p1CurrentScore) {
                if (i < outShootOptions.length) {
                    return outShootOptions[i];
                } else {
                    return "No valid out shoot option found.";
                }
            }
        }
        return "No valid out shoot option found.";


    }

    public static String indexOutShootsOnPlayer2CurrentScore() {

        for (int i = 0; i < outShootValues.length; i++) {
            if (outShootValues[i] == Main.p2CurrentScore) {
                if (i < outShootOptions.length) {
                    return outShootOptions[i];
                } else {
                    return "No valid out shoot option found.";
                }
            }
        }
        return "No valid out shoot option found.";


    }


    public static int[] dartScores = new int[3];

    public static void throwDart() {

        Random random = new Random();
        int totalValue = 0;
        int dartsThrown;


        for (dartsThrown = 0; dartsThrown < 3; dartsThrown++) {
            int regionIndex = random.nextInt(dartBoardRegions.length);
            dartBoardRegionName = dartBoardRegions[regionIndex];
            int regionValue = dartBoardValues[regionIndex];
            dartScores[dartsThrown] = regionValue;
            totalValue += regionValue;

            if (Main.CURRENT_THROWER == 1) {
                System.out.println(Main.P1NAME + " threw a " + dartBoardRegionName);
                player1DartsAndValues[currentIndex][0]++; // Increment the total number of darts thrown
                player1DartsAndValues[currentIndex][1] += regionValue;// Update the second value with total value of darts
            } else if (Main.CURRENT_THROWER == 2) {
                System.out.println(Main.P2NAME + " threw a " + dartBoardRegionName);
                player2DartsAndValues[currentIndex][0]++; // Increment the total number of darts thrown
                player2DartsAndValues[currentIndex][1] += regionValue; // Update the second value with total value of darts
            }
        }
    }

    public static void throwFakeDart() {
        int fakeDartsThrown;
        Random fakeRandom = new Random();
        String fakeRegionName = "";

        for (fakeDartsThrown = 0; fakeDartsThrown < 3; fakeDartsThrown++) {
            int regionIndex = fakeRandom.nextInt(dartBoardRegions.length);
            fakeRegionName = dartBoardRegions[regionIndex];
            int regionValue = dartBoardValues[regionIndex];
            dartScores[fakeDartsThrown] = regionValue;


            if (Main.CURRENT_THROWER == 1) {
                System.out.println(Main.P1NAME + " threw a " + fakeRegionName);

            } else if (Main.CURRENT_THROWER == 2) {
                System.out.println(Main.P2NAME + " threw a " + fakeRegionName);

            }
        }
    }


    public static void printPlayer1DartsAndValues() {
        for (int i = 0; i < Main.CURRENT_ROUND; i++) {
            for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                System.out.print(player1DartsAndValues[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printPlayer2DartsAndValues() {
        for (int i = 0; i < Main.CURRENT_ROUND; i++) {
            for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                System.out.print(player2DartsAndValues[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void thrownDarts() {
    }

    // increment each integer as a dart thrown, regardless of a miss, or surpassing
    // the required amount to win. (include throws that may be negative)
    // add each integer to an array assigned to the respective player.
    // ex: Arraylist playerOneDarts (20, 16, 3, 5, 7, 18)
    // call some sort of math function to add the ints from the array
    public static void roundTracker() {
        Tools.p1Thrown = false;
        Tools.p2Thrown = false;
        Main.CURRENT_ROUND++;
        currentIndex++;
        System.out.println("ROUND: " + Main.CURRENT_ROUND);
        //return Main.CURRENT_ROUND;
    }

    public static int sumRound() {

        int dartScore = 0;

        for (int score : dartScores) {
            dartScore += score;
        }
        return dartScore;
    }

    public static void updateGamesPlayed() {
        gamesPlayed++;
        // call method to reinitialize the p1 currentScore / p2 currentScore / rounds
    }

    public static void endCurrentGame() {
        Main.p1CurrentScore = 501;
        Main.p2CurrentScore = 501;
        Main.WINNER = " ";
        Main.CURRENT_ROUND = 1;
        Tools.p1Thrown = false;
        Tools.p2Thrown = false;



        if (gamesPlayed == 1) {
            //Copy data into game array
            for (int i = 0; i < player1DartsAndValues.length; i++) {
                for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                    player1Game1DartsAndValues[i][j] = player1DartsAndValues[i][j];
                }
            }

            // Reset the data in player 1 array
            for (int i = 0; i < player1DartsAndValues.length; i++) {
                for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                    player1DartsAndValues[i][j] = 0; //resetting with 0s maybe nulls
                }
            }

            //Copy data into player 2 game array
            for (int i = 0; i < player2DartsAndValues.length; i++) {
                for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                    player2Game1DartsAndValues[i][j] = player2DartsAndValues[i][j];
                }
            }

            // Reset the data in player 2 array
            for (int i = 0; i < player2DartsAndValues.length; i++) {
                for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                    player2DartsAndValues[i][j] = 0;
                }

            }
        } else if (gamesPlayed == 2) {

            for (int i = 0; i < player1DartsAndValues.length; i++) {
                for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                    player1Game2DartsAndValues[i][j] = player1DartsAndValues[i][j];
                }
            }

            for (int i = 0; i < player1DartsAndValues.length; i++) {
                for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                    player1DartsAndValues[i][j] = 0;
                }
            }

            for (int i = 0; i < player2DartsAndValues.length; i++) {
                for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                    player2Game2DartsAndValues[i][j] = player2DartsAndValues[i][j];
                }
            }

            for (int i = 0; i < player2DartsAndValues.length; i++) {
                for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                    player2DartsAndValues[i][j] = 0;
                }
            }
        } else if (gamesPlayed == 3) {
            for (int i = 0; i < player1DartsAndValues.length; i++) {
                for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                    player1Game3DartsAndValues[i][j] = player1DartsAndValues[i][j];
                }
            }

            for (int i = 0; i < player1DartsAndValues.length; i++) {
                for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                    player1DartsAndValues[i][j] = 0;
                }
            }


            for (int i = 0; i < player2DartsAndValues.length; i++) {
                for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                    player2Game3DartsAndValues[i][j] = player2DartsAndValues[i][j];
                }
            }


            for (int i = 0; i < player2DartsAndValues.length; i++) {
                for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                    player2DartsAndValues[i][j] = 0;
                }
            }
        } else if (gamesPlayed == 4) {
            for (int i = 0; i < player1DartsAndValues.length; i++) {
                for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                    player1Game4DartsAndValues[i][j] = player1DartsAndValues[i][j];
                }
            }

            for (int i = 0; i < player1DartsAndValues.length; i++) {
                for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                    player1DartsAndValues[i][j] = 0;
                }
            }


            for (int i = 0; i < player2DartsAndValues.length; i++) {
                for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                    player2Game4DartsAndValues[i][j] = player2DartsAndValues[i][j];
                }
            }


            for (int i = 0; i < player2DartsAndValues.length; i++) {
                for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                    player2DartsAndValues[i][j] = 0;
                }
            }
        } else if (gamesPlayed == 5) {
            for (int i = 0; i < player1DartsAndValues.length; i++) {
                for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                    player1Game5DartsAndValues[i][j] = player1DartsAndValues[i][j];
                }
            }


            for (int i = 0; i < player1DartsAndValues.length; i++) {
                for (int j = 0; j < player1DartsAndValues[i].length; j++) {
                    player1DartsAndValues[i][j] = 0;
                }
            }


            for (int i = 0; i < player2DartsAndValues.length; i++) {
                for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                    player2Game5DartsAndValues[i][j] = player2DartsAndValues[i][j];
                }
            }


            for (int i = 0; i < player2DartsAndValues.length; i++) {
                for (int j = 0; j < player2DartsAndValues[i].length; j++) {
                    player2DartsAndValues[i][j] = 0;
                }
            }
        }
//        for (int i = 0; i < player2Game1DartsAndValues[i].length; i++) {
//            for (int j = 0; j < player2Game1DartsAndValues[i].length; j++) {
//                System.out.print(player2Game1DartsAndValues[i][j] + " ");
//            }
//            System.out.println("player 2 dataG1");
//        }
//        for (int i = 0; i < player2Game2DartsAndValues[i].length; i++) {
//            for (int j = 0; j < player2Game2DartsAndValues[i].length; j++) {
//                System.out.print(player2Game2DartsAndValues[i][j] + " ");
//            }
//            System.out.println("player 2 dataG2");
//        }
//        for (int i = 0; i < player2Game3DartsAndValues[i].length; i++) {
//            for (int j = 0; j < player2Game3DartsAndValues[i].length; j++) {
//                System.out.print(player2Game3DartsAndValues[i][j] + " ");
//            }
//            System.out.println("player 2 dataG3");
//        }
//        for (int i = 0; i < player2Game4DartsAndValues[i].length; i++) {
//            for (int j = 0; j < player2Game4DartsAndValues[i].length; j++) {
//                System.out.print(player2Game4DartsAndValues[i][j] + " ");
//            }
//            System.out.println("player 2 dataG4");
//        }
//        for (int i = 0; i < player2Game5DartsAndValues[i].length; i++) {
//            for (int j = 0; j < player2Game5DartsAndValues[i].length; j++) {
//                System.out.print(player2Game5DartsAndValues[i][j] + " ");
//            }
//            System.out.println("player 2 data G5");
//        }
        sumAtEndOfEachGame();
        Game.updateGamesPlayed();
        Main.startDartGame();
    }


    //we need to make a copy of player1 and 2 2d arrays and save them to the memory of the current game
    // there is going to be a game 1 2 3 4 5 data for each player that holds the data in the array

// after we copy we need to empty the current 2d array so that we can populate it again

    public static void saveTheFakeDarts() {

        if (Main.CURRENT_THROWER == 1) {
            player1DartsAndValues[currentIndex][0] = 3; // Increment the total number of darts thrown
            player1DartsAndValues[currentIndex][1] += Tools.tempScore;// Update the second value with total value of darts
        } else if (Main.CURRENT_THROWER == 2) {
            player2DartsAndValues[currentIndex][0] = 3; // Increment the total number of darts thrown
            player2DartsAndValues[currentIndex][1] += Tools.tempScore; // Update the second value with total value of darts
        }


    }

    public static void saveTheWinningFakeDarts() {

        if (Main.CURRENT_THROWER == 1) {
            player1DartsAndValues[currentIndex][0] = Tools.tempDartsThrown; // Increment the total number of darts thrown
            player1DartsAndValues[currentIndex][1] = Tools.tempScore;// Update the second value with total value of darts
        } else if (Main.CURRENT_THROWER == 2) {
            player2DartsAndValues[currentIndex][0] = Tools.tempDartsThrown; // Increment the total number of darts thrown
            player2DartsAndValues[currentIndex][1] = Tools.tempScore; // Update the second value with total value of darts

        }
    }

    public static void sumAtEndOfEachGame() {
        //we can probably just do this with the p1dartsandvalues 2d array by summing the final values for that game
        if (gamesPlayed == 1) {
            int sum1 = 0;
            int sumAtEndOfPlayer1Game = 0;
            for (int i = 0; i < player1Game1DartsAndValues.length; i++) {
                if (player1Game1DartsAndValues[i].length > 1) {
                    sum1 += player1Game1DartsAndValues[i][1];
                }
            }
            System.out.println("Player 1 sum of game " + gamesPlayed + " darts " + sum1);

            int sum2 = 0;
            int sumAtEndOfPlayer2Game = 0;
            for (int i = 0; i < player2Game1DartsAndValues.length; i++) {
                if (player2Game1DartsAndValues[i].length > 1) {
                    sum2 += player2Game1DartsAndValues[i][1];
                }
            }
            System.out.println("Player 2 sum of game " + gamesPlayed + " darts " + sum2);
        }
        if (gamesPlayed == 2) {
            int sum1 = 0;
            int sumAtEndOfPlayer1Game = 0;
            for (int i = 0; i < player1Game2DartsAndValues.length; i++) {
                if (player1Game2DartsAndValues[i].length > 1) {
                    sum1 += player1Game2DartsAndValues[i][1];
                }
            }
            System.out.println("Player 1 sum of game " + gamesPlayed + " darts " + sum1);

            int sum2 = 0;
            int sumAtEndOfPlayer2Game = 0;
            for (int i = 0; i < player2Game2DartsAndValues.length; i++) {
                if (player2Game2DartsAndValues[i].length > 1) {
                    sum2 += player2Game2DartsAndValues[i][1];
                }
            }
            System.out.println("Player 2 sum of game " + gamesPlayed + " darts " + sum2);
        }
        if (gamesPlayed == 3) {
            int sum1 = 0;
            int sumAtEndOfPlayer1Game = 0;
            for (int i = 0; i < player1Game3DartsAndValues.length; i++) {
                if (player1Game3DartsAndValues[i].length > 1) {
                    sum1 += player1Game3DartsAndValues[i][1];
                }
            }
            System.out.println("Player 1 sum of game " + gamesPlayed + " darts " + sum1);

            int sum2 = 0;
            int sumAtEndOfPlayer2Game = 0;
            for (int i = 0; i < player2Game3DartsAndValues.length; i++) {
                if (player2Game3DartsAndValues[i].length > 1) {
                    sum2 += player2Game3DartsAndValues[i][1];
                }
            }
            System.out.println("Player 2 sum of game " + gamesPlayed + " darts " + sum2);
        }
        if (gamesPlayed == 4) {
            int sum1 = 0;
            int sumAtEndOfPlayer1Game = 0;
            for (int i = 0; i < player1Game4DartsAndValues.length; i++) {
                if (player1Game4DartsAndValues[i].length > 1) {
                    sum1 += player1Game4DartsAndValues[i][1];
                }
            }
            System.out.println("Player 1 sum of game " + gamesPlayed + " darts " + sum1);

            int sum2 = 0;
            int sumAtEndOfPlayer2Game = 0;
            for (int i = 0; i < player2Game4DartsAndValues.length; i++) {
                if (player2Game4DartsAndValues[i].length > 1) {
                    sum2 += player2Game4DartsAndValues[i][1];
                }
            }
            System.out.println("Player 2 sum of game " + gamesPlayed + " darts " + sum2);
        }
        if (gamesPlayed == 5) {
            int sum1 = 0;
            int sumAtEndOfPlayer1Game = 0;
            for (int i = 0; i < player1Game5DartsAndValues.length; i++) {
                if (player1Game5DartsAndValues[i].length > 1) {
                    sum1 += player1Game5DartsAndValues[i][1];
                }
            }
            System.out.println("Player 1 sum of game " + gamesPlayed + " darts " + sum1);

            int sum2 = 0;
            int sumAtEndOfPlayer2Game = 0;
            for (int i = 0; i < player2Game5DartsAndValues.length; i++) {
                if (player2Game5DartsAndValues[i].length > 1) {
                    sum2 += player2Game5DartsAndValues[i][1];
                }
            }
            System.out.println("Player 2 sum of game " + gamesPlayed + " darts " + sum2);
        }
    }
    public static void sumAtEndOfEachMatch(){
        int[][][] allPlayer1Games = {player1Game1DartsAndValues, player1Game2DartsAndValues, player1Game3DartsAndValues, player1Game4DartsAndValues, player1Game5DartsAndValues};
        int[][][] allPlayer2Games = {player2Game1DartsAndValues, player2Game2DartsAndValues, player2Game3DartsAndValues, player2Game4DartsAndValues, player2Game5DartsAndValues};

        for (int i = 0; i < 5; i++) {
            int sum1 = 0;
            for (int j = 0; j < allPlayer1Games[i].length; j++) {
                if (allPlayer1Games[i][j].length > 1) {
                    sum1 += allPlayer1Games[i][j][1];
                }
            }
            player1TotalSum += sum1;

            int sum2 = 0;
            for (int j = 0; j < allPlayer2Games[i].length; j++) {
                if (allPlayer2Games[i][j].length > 1) {
                    sum2 += allPlayer2Games[i][j][1];
                }
            }
            player2TotalSum += sum2;
        }

        System.out.println("Player 1 total sum of all games: " + player1TotalSum);
        System.out.println("Player 2 total sum of all games: " + player2TotalSum);


    }
}





    // increment rounds by 1 for both players simultaneously
        //
//        public void gameTracker () {
//        }
//        public static int sumRound () {
//            int dartScores = 0;
//            return Main.roundTotal;
//        }



    // I NEED TO MAKE A METHOD TO DO THE MATH ON THE DATA THAT IS PROVIDED AT THE END OF THE GAME










// if (p1CurrentScore == 0) {
//                p1GameWins++;
//                System.out.println(P1NAME + " Updated game wins: " + p1GameWins);
//            } else if (p2CurrentScore == 0) {
//                p2GameWins++;
//                System.out.println(P2NAME + " Updated game wins: " + p2GameWins);
//            }

//private static boolean isStringNumeric(String inputString) {
//    boolean isValid = true;
//
//    try {
//        int testNumber = Integer.parseInt(inputString);
//    } catch (NumberFormatException e) {
//        isValid = false;
//    }
//
//    return isValid;
//}
//
//private static boolean isStringNumeric(String inputString, int lowerBound, int upperBound) {
//    int testNumber;
//
//    // is the number numeric
//    try {
//        testNumber = Integer.parseInt(inputString);
//    } catch (NumberFormatException e) {
//        return false;
//    }
//
//    // is the number within the correct range?
//    return testNumber <= upperBound && testNumber >= lowerBound;
//}