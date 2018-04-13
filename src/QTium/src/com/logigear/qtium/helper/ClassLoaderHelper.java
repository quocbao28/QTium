package com.logigear.qtium.helper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.logigear.qtium.driver.QTiumLocalDriver;
import com.logigear.qtium.driver.QTiumRemoteDriver;
import com.logigear.qtium.driver.QTiumWebDriver;

public class ClassLoaderHelper {
	public static final String LOCAL_DRIVER_SUFFIX = "LocalDriver";
	public static final String REMOTE_DRIVER_SUFFIX = "RemoteDriver";

	public static Class<?> getDriverClass(String device, String provider,
			String appType, boolean isGrid) throws URISyntaxException {
		String packagePath = String.format("com.logigear.qtium.driver.%s.%s",
				provider, device);

		try {
			// TODO: Catch exception. This can throw exception, if the package
			// name is not available
			Class<?>[] classes = getClasses(packagePath);
			if (classes == null)
				return null;

			// this string variable hold simple class name of driver class
			String currentClassDriverSimpleName = "";
			// this string variable hold simple class name of parent driver
			// class
			String parentClass = "";
			// this string contains driver class suffix that depends on using
			// grid mode or not
			String driverClassSuffifx = "";

			if (isGrid) {
				driverClassSuffifx = String.format("%s%s", appType,
						ClassLoaderHelper.REMOTE_DRIVER_SUFFIX);
			} else {
				driverClassSuffifx = String.format("%s%s", appType,
						ClassLoaderHelper.LOCAL_DRIVER_SUFFIX);
			}

			for (Class<?> cls : classes) {
				currentClassDriverSimpleName = cls.getSimpleName();
				Class<?> clsParentClass = cls.getSuperclass();
				if (parentClass != null) {
					parentClass = clsParentClass.getSimpleName();
					// check current class name of driver class with
					if (currentClassDriverSimpleName.toLowerCase().endsWith(
							driverClassSuffifx.toLowerCase())) {
						if (isGrid) {
							if (QTiumRemoteDriver.class.getSimpleName()
									.compareToIgnoreCase(parentClass) == 0)
								return cls;
						} else {
							if (QTiumLocalDriver.class.getSimpleName()
									.compareToIgnoreCase(parentClass) == 0)
								return cls;
						}
					}
				}

				// System.out.println("class: " + cls.getSimpleName() +
				// " - super class: " + cls.getSuperclass().getName());
			} // end for

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException - " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException - " + e.getMessage());
		}

		return null;
	}

	/**
	 * Scans all classes accessible from the context class loader which belong
	 * to the given package and subpackages.
	 *
	 * @param packageName
	 *            The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	private static Class<?>[] getClasses(String packageName)
			throws ClassNotFoundException, IOException, URISyntaxException {
		ClassLoader classLoader = QTiumWebDriver.class.getClassLoader();
//		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			//dirs.add(new File(resource.getFile()));
			dirs.add(new File(resource.toURI().getSchemeSpecificPart()));
		}
		ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[classes.size()]);
	}

	private static List<Class<?>> findClasses(File directory, String packageName)
			throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
//				assert !file.getName().contains(".");
				classes.addAll(findClasses(file,
						packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName
						+ '.'
						+ file.getName().substring(0,
								file.getName().length() - 6)));
			}
		}
		return classes;
	}
}
