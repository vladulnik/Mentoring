package problemSolvingClasses.workWithEnum;

public enum Currency {
    USD(1.0),
    EUR(1.8),
    GBP(1.27),
    JPY(0.007);

    private final double rateToUSD;

    Currency(double rateToUSD) {
        this.rateToUSD = rateToUSD;
    }

    public double getRateToUSD() {
        return rateToUSD;
    }

    public double convert(double amount, Currency target) {
        double inUSD = amount * this.rateToUSD;
        return inUSD / target.rateToUSD;
    }
}
