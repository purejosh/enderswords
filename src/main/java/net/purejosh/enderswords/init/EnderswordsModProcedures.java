
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.enderswords.init;

import net.purejosh.enderswords.procedures.WoodenEnderBladeRightClickProcedure;
import net.purejosh.enderswords.procedures.StoneEnderBladeRightClickProcedure;
import net.purejosh.enderswords.procedures.NetheriteEnderBladeRightClickProcedure;
import net.purejosh.enderswords.procedures.IronEnderBladeRightClickProcedure;
import net.purejosh.enderswords.procedures.GoldenEnderBladeRightClickProcedure;
import net.purejosh.enderswords.procedures.EnderBladeBaseProcedure;
import net.purejosh.enderswords.procedures.DiamondEnderBladeRightClickProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class EnderswordsModProcedures {
	public static void load() {
		new EnderBladeBaseProcedure();
		new DiamondEnderBladeRightClickProcedure();
		new GoldenEnderBladeRightClickProcedure();
		new WoodenEnderBladeRightClickProcedure();
		new StoneEnderBladeRightClickProcedure();
		new NetheriteEnderBladeRightClickProcedure();
		new IronEnderBladeRightClickProcedure();
	}
}
