package eki.ekilex.manual;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import eki.ekilex.runner.TermekiRunner;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import eki.ekilex.runner.CollocLoaderRunner;
import eki.ekilex.runner.DbReInitialiserRunner;
import eki.ekilex.runner.EstermLoaderRunner;
import eki.ekilex.runner.EstermSourceLoaderRunner;
import eki.ekilex.runner.PsvLoaderRunner;
import eki.ekilex.runner.Qq2LoaderRunner;
import eki.ekilex.runner.Ss1LoaderRunner;
import eki.ekilex.service.MabService;
import eki.ekilex.service.WordMatcherService;

public class UltimaLoader extends AbstractLoader {

	private static Logger logger = LoggerFactory.getLogger(UltimaLoader.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = null;

		applicationContext = new ClassPathXmlApplicationContext("service-config.xml", "db-config.xml", "db-termeki-config.xml");
		Resource loaderConfResource = applicationContext.getResource("ultima-loader.properties");

		DbReInitialiserRunner initRunner = applicationContext.getBean(DbReInitialiserRunner.class);
		MabService mabService = applicationContext.getBean(MabService.class);
		Qq2LoaderRunner qq2Runner = applicationContext.getBean(Qq2LoaderRunner.class);
		EstermSourceLoaderRunner estSrcRunner = applicationContext.getBean(EstermSourceLoaderRunner.class);
		EstermLoaderRunner estRunner = applicationContext.getBean(EstermLoaderRunner.class);
		TermekiRunner termekiRunner = applicationContext.getBean(TermekiRunner.class);
		PsvLoaderRunner psvRunner = applicationContext.getBean(PsvLoaderRunner.class);
		Ss1LoaderRunner ss1Runner = applicationContext.getBean(Ss1LoaderRunner.class);
		CollocLoaderRunner kolRunner = applicationContext.getBean(CollocLoaderRunner.class);
		WordMatcherService wordMatcherService = applicationContext.getBean(WordMatcherService.class);
		List<String> successfullyLoadedDatasets = new ArrayList<>();

		try {
			applicationContext.registerShutdownHook();

			Properties loaderConf = new Properties();
			loaderConf.load(loaderConfResource.getInputStream());

			String dataFilePath, mapFilePath;
			String doReportsStr = loaderConf.getProperty("doreports");
			final boolean doReports = Boolean.valueOf(doReportsStr);

			logger.info("Starting to clear database and load all datasets specified in ultima-loader.properties file");

			// db init
			initRunner.execute();

			// mab
			dataFilePath = loaderConf.getProperty("mab.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				mabService.loadParadigms(dataFilePath, doReports);
				successfullyLoadedDatasets.add("mab");
			}

			// qq2
			/*
			dataFilePath = loaderConf.getProperty("qq2.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				qq2Runner.execute(dataFilePath, doReports);
				successfullyLoadedDatasets.add("qq2");
			}
			*/

			// est src + est
			dataFilePath = loaderConf.getProperty("est.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				estSrcRunner.execute(dataFilePath, doReports);
				successfullyLoadedDatasets.add("est src");
				estRunner.execute(dataFilePath, doReports);
				successfullyLoadedDatasets.add("est");
			}

			// psv guid matcher
			mapFilePath = loaderConf.getProperty("psv.map.file");
			if (StringUtils.isNotBlank(mapFilePath)) {
				wordMatcherService.load(mapFilePath);
				successfullyLoadedDatasets.add("psv guid");
			}

			// psv
			dataFilePath = loaderConf.getProperty("psv.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				psvRunner.execute(dataFilePath, doReports);
				successfullyLoadedDatasets.add("psv");
			}

			// ss1
			dataFilePath = loaderConf.getProperty("ss1.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				ss1Runner.execute(dataFilePath, doReports);
				successfullyLoadedDatasets.add("ss1");
			}

			// kol
			dataFilePath = loaderConf.getProperty("kol.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				kolRunner.execute(dataFilePath, doReports);
				successfullyLoadedDatasets.add("kol");
			}

			// termeki
			dataFilePath = loaderConf.getProperty("termeki.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				termekiRunner.batchLoad(dataFilePath);
				successfullyLoadedDatasets.add("termeki");
			}

			logger.info("----DONE LOADING DATASETS!!----");
		} catch (Exception e) {
			logger.error("Unexpected behaviour of the system", e);
			logger.info("Successfully loaded datasets: {}", successfullyLoadedDatasets);
		} finally {
			applicationContext.close();
		}
	}

	@Override
	void execute() {
		
	}
	
}
