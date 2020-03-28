package rip.artemis.telescope;
import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

public class Color {
	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}

	public static List<String> list(List<String> s) {
		List<String> a = new ArrayList<String>();
		for (String ls : s)
			a.add(ChatColor.translateAlternateColorCodes('&', ls));
		return a;
	}
	// removed my other translation types for these plugins
}
