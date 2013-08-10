package org.testium.plugins;

import java.io.File;

import net.sf.testium.Testium;
import net.sf.testium.configuration.ConfigurationException;
import net.sf.testium.configuration.KeywordDefinitionsConfiguration;
import net.sf.testium.plugins.KeywordDefinitionsWriter;
import net.sf.testium.plugins.Plugin;
import net.sf.testium.plugins.PluginCollection;

import org.testtoolinterfaces.utils.RunTimeData;

/**
 * @author Arjan Kranenburg
 * 
 */
public class KdwPlugin implements Plugin {
	public static final String BASEURL = "BaseUrl";

	public KdwPlugin() {
		// nop
	}

	public void loadPlugIn(PluginCollection aPluginCollection,
			RunTimeData rtData) throws ConfigurationException {
		File configDir = rtData.getValueAsFile(Testium.CONFIGDIR);
		File kdwConfigFile = new File(configDir, "KeywordDefinitionsWriter.xml");
		KeywordDefinitionsConfiguration kdwConfig = KeywordDefinitionsWriterImpl
				.readGlobalInterfaceConfiguration(kdwConfigFile, rtData);

		KeywordDefinitionsWriter kdWriter = new KeywordDefinitionsWriterImpl(
				kdwConfig);
		aPluginCollection.addKdWriters(kdWriter);
//		kdWriter.saveKeywordDefs(aPluginCollection);
	}
}
