
public class MediScoreCalculator {

    public static void main(String[] args) {

        System.out.println("MEDI Score Calculator - Automated Tests");

        // Example patient tests
        testScore("Patient 1", 0,
                calculateMediScore(0, 0, 15, 95, 37.1));

        testScore("Patient 2", 4,
                calculateMediScore(2, 0, 17, 95, 37.1));

        testScore("Patient 3", 8,
                calculateMediScore(2, 1, 23, 88, 38.5));

        // Respiration boundary tests
        System.out.println("\nRespiration Tests");

        testScore("Respiration 8", 3,
                calculateMediScore(0, 0, 8, 95, 37.1));

        testScore("Respiration 9", 1,
                calculateMediScore(0, 0, 9, 95, 37.1));

        testScore("Respiration 11", 1,
                calculateMediScore(0, 0, 11, 95, 37.1));

        testScore("Respiration 12", 0,
                calculateMediScore(0, 0, 12, 95, 37.1));

        testScore("Respiration 20", 0,
                calculateMediScore(0, 0, 20, 95, 37.1));

        testScore("Respiration 21", 2,
                calculateMediScore(0, 0, 21, 95, 37.1));

        testScore("Respiration 24", 2,
                calculateMediScore(0, 0, 24, 95, 37.1));

        testScore("Respiration 25", 3,
                calculateMediScore(0, 0, 25, 95, 37.1));

        // SpO2 tests using room air
        System.out.println("\nSpO2 Room Air Tests");

        testScore("SpO2 83 air", 3,
                calculateMediScore(0, 0, 15, 83, 37.1));

        testScore("SpO2 84 air", 2,
                calculateMediScore(0, 0, 15, 84, 37.1));

        testScore("SpO2 85 air", 2,
                calculateMediScore(0, 0, 15, 85, 37.1));

        testScore("SpO2 86 air", 1,
                calculateMediScore(0, 0, 15, 86, 37.1));

        testScore("SpO2 87 air", 1,
                calculateMediScore(0, 0, 15, 87, 37.1));

        testScore("SpO2 88 air", 0,
                calculateMediScore(0, 0, 15, 88, 37.1));

        testScore("SpO2 92 air", 0,
                calculateMediScore(0, 0, 15, 92, 37.1));

        testScore("SpO2 93 air", 0,
                calculateMediScore(0, 0, 15, 93, 37.1));

        testScore("SpO2 97 air", 0,
                calculateMediScore(0, 0, 15, 97, 37.1));

        // SpO2 tests using supplemental oxygen
        System.out.println("\nSpO2 Supplemental Oxygen Tests");

        // The expected totals include 2 points for oxygen
        testScore("SpO2 83 oxygen", 5,
                calculateMediScore(2, 0, 15, 83, 37.1));

        testScore("SpO2 84 oxygen", 4,
                calculateMediScore(2, 0, 15, 84, 37.1));

        testScore("SpO2 86 oxygen", 3,
                calculateMediScore(2, 0, 15, 86, 37.1));

        testScore("SpO2 88 oxygen", 2,
                calculateMediScore(2, 0, 15, 88, 37.1));

        testScore("SpO2 92 oxygen", 2,
                calculateMediScore(2, 0, 15, 92, 37.1));

        testScore("SpO2 93 oxygen", 3,
                calculateMediScore(2, 0, 15, 93, 37.1));

        testScore("SpO2 94 oxygen", 3,
                calculateMediScore(2, 0, 15, 94, 37.1));

        testScore("SpO2 95 oxygen", 4,
                calculateMediScore(2, 0, 15, 95, 37.1));

        testScore("SpO2 96 oxygen", 4,
                calculateMediScore(2, 0, 15, 96, 37.1));

        testScore("SpO2 97 oxygen", 5,
                calculateMediScore(2, 0, 15, 97, 37.1));

        // Temperature boundary tests
        System.out.println("\nTemperature Tests");

        testScore("Temperature 35.0", 3,
                calculateMediScore(0, 0, 15, 95, 35.0));

        testScore("Temperature 35.1", 1,
                calculateMediScore(0, 0, 15, 95, 35.1));

        testScore("Temperature 36.0", 1,
                calculateMediScore(0, 0, 15, 95, 36.0));

        testScore("Temperature 36.1", 0,
                calculateMediScore(0, 0, 15, 95, 36.1));

        testScore("Temperature 38.0", 0,
                calculateMediScore(0, 0, 15, 95, 38.0));

        testScore("Temperature 38.1", 1,
                calculateMediScore(0, 0, 15, 95, 38.1));

        testScore("Temperature 39.0", 1,
                calculateMediScore(0, 0, 15, 95, 39.0));

        testScore("Temperature 39.1", 2,
                calculateMediScore(0, 0, 15, 95, 39.1));

        testScore("Temperature rounding 38.14", 1,
                calculateMediScore(0, 0, 15, 95, 38.14));

        // Consciousness and oxygen tests
        System.out.println("\nConsciousness and Oxygen Tests");

        testScore("Alert patient", 0,
                calculateMediScore(0, 0, 15, 95, 37.1));

        testScore("Non-alert patient", 3,
                calculateMediScore(0, 1, 15, 95, 37.1));

        testScore("Room air", 0,
                calculateMediScore(0, 0, 15, 95, 37.1));

        testScore("Supplemental oxygen", 4,
                calculateMediScore(2, 0, 15, 95, 37.1));
    }

    // This checks whether the calculated score matches the expected score
    public static void testScore(String testName, int expected, int actual) {

        if (expected == actual) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName
                    + " | Expected: " + expected
                    + " | Actual: " + actual);
        }
    }

    // The reusable MEDI score calculation method
    public static int calculateMediScore(
            int oxygen,
            int consciousness,
            int respirationRate,
            int spo2,
            double temperature) {

        // This is the respiration scoring
        int respirationScore = 0;

        if (respirationRate <= 8) {
            respirationScore = 3;
        } else if (respirationRate <= 11) {
            respirationScore = 1;
        } else if (respirationRate <= 20) {
            respirationScore = 0;
        } else if (respirationRate <= 24) {
            respirationScore = 2;
        } else {
            respirationScore = 3;
        }

        // This is the consciousness scoring
        int consciousnessScore = 0;

        if (consciousness == 0) {
            consciousnessScore = 0;
        } else {
            consciousnessScore = 3;
        }

        // This is the oxygen scoring
        int oxygenScore = 0;

        if (oxygen == 2) {
            oxygenScore = 2;
        } else {
            oxygenScore = 0;
        }

        // this is the sp02 scoring
        int spo2Score = 0;

        if (spo2 <= 83) {
            spo2Score = 3;
        } else if (spo2 <= 85) {
            spo2Score = 2;
        } else if (spo2 <= 87) {
            spo2Score = 1;
        } else if (spo2 <= 92) {
            spo2Score = 0;
        } else if (oxygen == 0) {
            spo2Score = 0;
        } else if (spo2 <= 94) {
            spo2Score = 1;
        } else if (spo2 <= 96) {
            spo2Score = 2;
        } else {
            spo2Score = 3;
        }

        // this is the temp scoring
        int temperatureScore = 0;

        double roundedTemperature = Math.round(temperature * 10) / 10.0;

        if (roundedTemperature <= 35.0) {
            temperatureScore = 3;
        } else if (roundedTemperature <= 36.0) {
            temperatureScore = 1;
        } else if (roundedTemperature <= 38.0) {
            temperatureScore = 0;
        } else if (roundedTemperature <= 39.0) {
            temperatureScore = 1;
        } else {
            temperatureScore = 2;
        }

        // This adds all five scores
        int totalMediScore = respirationScore
                + consciousnessScore
                + oxygenScore
                + spo2Score
                + temperatureScore;

        return totalMediScore;
    }
}



