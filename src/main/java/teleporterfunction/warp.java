package teleporterfunction;

import de.kaitokid1513.lobby.main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;

public class warp implements CommandExecutor {
    private final main plugin;

    public warp(main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player p = (Player) commandSender;
        Inventory tpinv = Bukkit.createInventory(null, 27,"§bWarpmenü");


        if(args.length == 0) {
            File tpfile = new File(plugin.getDataFolder(), "tp.yml");
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(tpfile);

            if(cfg.contains("Warps")) {
                int i;
                for(i=0; i<27; i++) {
                    ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS);
                    ItemMeta meta = glass.getItemMeta();
                    ArrayList<String> empty = new ArrayList<String>();
                    empty.add(" ");
                    meta.setLore(empty);
                    meta.setDisplayName(" ");
                    glass.setItemMeta(meta);

                    tpinv.setItem(i,glass);
                }
                for(String warp : cfg.getConfigurationSection("Warps").getKeys(false)) {
                    ItemStack item = new ItemStack(Material.valueOf(cfg.getString("Warps." + warp + ".Material")));
                    ItemMeta meta = item.getItemMeta();
                    ArrayList<String> lore = new ArrayList<String>();
                    lore.add(warp);
                    meta.setLore(lore);
                    meta.setDisplayName("§" + cfg.getString("Warps."+warp+".color")+warp);
                    item.setItemMeta(meta);

                    tpinv.setItem(cfg.getInt("Warps." + warp + ".Platziminv"),item);

                }
                ItemStack jump = new ItemStack(Material.GOLD_BLOCK);
                ItemMeta jumpItemMeta = jump.getItemMeta();
                ArrayList<String> jlore = new ArrayList<String>();
                jlore.add("JumpAndRun");
                jumpItemMeta.setLore(jlore);
                jumpItemMeta.setDisplayName("§eJumpAndRun");
                jump.setItemMeta(jumpItemMeta);
                tpinv.setItem(26,jump);

                p.openInventory(tpinv);



            } else {
                p.sendMessage(main.prefix + "§bEs wurde bisher kein Warp gesetzt!");
            }



        } else {
            p.sendMessage(main.prefix +"/warp");
        }


        return true;
    }
}
