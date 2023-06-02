package de.exxcellent.challenge.models;

public class WeatherData {
    private final int day;
    private final int mxT;
    private final int mnT;
    private final int avT;
    private final double avDP;
    private final int oneHrPTPcpn;
    private final int pDir;
    private final double avSp;
    private final int dir;
    private final int mxS;
    private final double skyC;
    private final int mxR;
    private final int mn;
    private final double rAvSLP;

    public int getDay() {
        return this.day;
    }

    public int getTemperatureSpread() {
        return Math.abs(this.mxT - this.mnT);
    }

    public WeatherData(int day, int mxT, int mnT, int avT, double avDP, int oneHrPTPcpn, int pDir, double avSp, int dir, int mxS, double skyC, int mxR, int mn, double rAvSLP) {
        this.day = day;
        this.mxT = mxT;
        this.mnT = mnT;
        this.avT = avT;
        this.avDP = avDP;
        this.oneHrPTPcpn = oneHrPTPcpn;
        this.pDir = pDir;
        this.avSp = avSp;
        this.dir = dir;
        this.mxS = mxS;
        this.skyC = skyC;
        this.mxR = mxR;
        this.mn = mn;
        this.rAvSLP = rAvSLP;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "day=" + day +
                ", mxT=" + mxT +
                ", mnT=" + mnT +
                ", avT=" + avT +
                ", avDP=" + avDP +
                ", oneHrPTPcpn=" + oneHrPTPcpn +
                ", pDir=" + pDir +
                ", avSp=" + avSp +
                ", dir=" + dir +
                ", mxS=" + mxS +
                ", skyC=" + skyC +
                ", mxR=" + mxR +
                ", mn=" + mn +
                ", rAvSLP=" + rAvSLP +
                '}';
    }
}
