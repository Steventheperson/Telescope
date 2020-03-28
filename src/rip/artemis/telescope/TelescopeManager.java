package rip.artemis.telescope;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TelescopeManager implements Listener {
	private static Telescope plugin;

	public TelescopeManager(Telescope instance) {
		plugin = instance;
	}
	
	public static void giveTelescope(Player p) {
		ItemStack telescope = new ItemStack(Material.getMaterial(plugin.getConfig().getString("telescope-item")));
		ItemMeta telescopeMeta = telescope.getItemMeta();
		telescopeMeta.setDisplayName(Color.chat(plugin.getConfig().getString("telescope-name")));
		telescopeMeta.setLore(Color.list(plugin.getConfig().getStringList("telescope-description")));
		telescope.setItemMeta(telescopeMeta);
		p.getInventory().addItem(telescope);
		
	}

	@EventHandler
	public void onTelescope(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			ItemStack itemInHand = p.getItemInHand();
	        ItemMeta iteMeta = itemInHand.getItemMeta();
			if (itemInHand.getType().equals(Material.getMaterial(plugin.getConfig().getString("telescope-item"))) && iteMeta.getDisplayName().equals(Color.chat(plugin.getConfig().getString("telescope-name")))) {
				boolean inzoom = p.hasPotionEffect(PotionEffectType.SLOW);
				if (inzoom == false) {
					 p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 8888, 5));
					 if (plugin.getConfig().getBoolean("offset-slowness") == true) {
					 p.setWalkSpeed(1.0F);
					 } else {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 8888, 255));
					 }
				} else {
					p.removePotionEffect(PotionEffectType.SLOW);
					p.setWalkSpeed(0.2F);
				}
			}
		}
	}
}
