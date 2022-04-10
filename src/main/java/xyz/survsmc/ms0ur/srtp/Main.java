package xyz.survsmc.ms0ur.srtp;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin implements Listener {

    public static class  SettingsPlugin{
        public static boolean enable;
        public static World world;
    }

    public static class Lang_str{
        public static String searchCoords;
        public static String teleportNow;
    }

    public static class Coord_lim{
        public static int x1;
        public static int z1;
        public static int x2;
        public static int z2;
    }

    private void cfgCreate(){
         FileConfiguration config = this.getConfig();

        if(!config.isBoolean("enable"))//enabled?
            config.set("enable", true);

        //coord limits
        if(!config.isBoolean("X1_LIM"))//x1 limit
            config.set("X1_LIM", 5000);

        if(!config.isInt("X2_LIM"))//x2 limit
            config.set("X2_LIM", -5000);

        if(!config.isInt("Z1_LIM"))//z1 limit
            config.set("Z1_LIM", 5000);

        if(!config.isInt("Z2_LIM"))//z2 limit
            config.set("Z2_LIM", -5000);
        //lang config
        if(!config.isString("coords_search"))//поиск координат
            config.set("coords_search", "Поиск безопасной позиции для телепорта...");
        if(!config.isString("teleport_now"))//позиция найдена, телепортация
            config.set("teleport_now", "Телепортация...");

        //init
        SettingsPlugin.enable = config.getBoolean("enable");
        Coord_lim.x1 = config.getInt("X1_LIM");
        Coord_lim.x2 = config.getInt("X2_LIM");
        Coord_lim.z1 = config.getInt("Z1_LIM");
        Coord_lim.z2 = config.getInt("Z2_LIM");
        Lang_str.searchCoords=config.getString("coords_search");
        Lang_str.teleportNow=config.getString("teleport_now");
        this.saveConfig();
    }


    @Override
    public void onEnable() {
        // Plugin startup logic
        cfgCreate();
        if(!SettingsPlugin.enable)
        {  getServer().getPluginManager().disablePlugin(this);}
        Objects.requireNonNull(getCommand("rtp")).setExecutor(new commandRtp());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
