package com.lumi.dcg;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeepslateCobbleGen implements ModInitializer {
	public static final String MOD_ID = "deepslate-cobble-gen";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello from Deepslate Cobble Gen!");
	}
}