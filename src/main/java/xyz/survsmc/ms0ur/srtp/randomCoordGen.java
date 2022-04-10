package xyz.survsmc.ms0ur.srtp;

public class randomCoordGen {
    static double genX(){
        double x;
        x = (Math.random() * ((Main.Coord_lim.x1 - Main.Coord_lim.x2) + 1)) + Main.Coord_lim.x2;
        return x;
    }
    static double genZ(){
        double z;
        z = (Math.random() * ((Main.Coord_lim.z1 - Main.Coord_lim.z2) + 1)) + Main.Coord_lim.z2;
        return z;
    }
}
