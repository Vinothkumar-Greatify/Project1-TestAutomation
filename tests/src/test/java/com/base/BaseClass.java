package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public void enterUrl(String url) {
		driver.get(url);
	}

	public static void getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public void minWindow() {
		driver.manage().window().minimize();
	}

	public static void EnterInTextbox(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void eleClick(WebElement element) {
		element.click();
	}

	public void eleSubmit(WebElement element) {
		element.submit();
	}

	public void eleClear(WebElement element) {
		element.clear();
	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getInsertValue(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}

	public static void closeAllWind() {
		driver.quit();
	}

	public void closeCurrentwind() {
		driver.close();
	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getEnterUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public void selectDdnByText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void selectDdnByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void selectDdnByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void sendkeysInJS(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public void clkBtnByJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public String getAttributeByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String value = (String) executor.executeScript("return arguments[0].getAttribute('attributeName');", element);
		return value;
	}

	public String getTextContentByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String textContent = (String) executor.executeScript("return arguments[0].textContent;", element);
		return textContent;
	}

	public String getInnerHTMLByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String innerHTML = (String) executor.executeScript("return arguments[0].innerHTML;", element);
		return innerHTML;
	}

	public void scrollUpJs(WebElement element) throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}

	public void scrollDownJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public WebElement locatorByID(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public WebElement locatorByName(String data) {
		WebElement element = driver.findElement(By.name(data));
		return element;
	}

	public WebElement locatorByClassname(String data) {
		WebElement element = driver.findElement(By.className(data));
		return element;
	}

	public WebElement locatorByXpath(String data) {
		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}

	public List<WebElement> locatorByTagName(String data) {
		List<WebElement> findElements = driver.findElements(By.tagName(data));
		return findElements;
	}

	public WebElement locatorByLinktext(String data) {
		WebElement element = driver.findElement(By.linkText(data));
		return element;
	}

	public WebElement locatorByPartialLinktext(String data) {
		WebElement element = driver.findElement(By.partialLinkText(data));
		return element;
	}

	public List<WebElement> getAllOptionAsText(WebElement element) {
		Select s = new Select(element);
		List<WebElement> list = s.getOptions();
		return list;
	}

	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	public WebElement getFirstSelectOption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public boolean verifyIsMultiSelect(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public String getParentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public Set<String> getAllWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public File takeScreenshot(TakesScreenshot ts) {
		ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		return file;
	}

	public Actions mouseOverActionMoveToElement(WebElement element) {
		Actions a = new Actions(driver);
		Actions moveToElement = a.moveToElement(element);
		a.perform();
		return moveToElement;
	}

	public Actions dragandDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		Actions dragAndDrop = a.dragAndDrop(source, target);
		return dragAndDrop;
	}

	public void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	public void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	public void doubleClick1(WebDriverWait wait) {
		Actions a = new Actions(driver);
		a.doubleClick((WebElement) wait).perform();

	}

	public void Command_T() {
		Actions a = new Actions(driver);

		a.keyDown(Keys.COMMAND).sendKeys("t").keyUp(Keys.COMMAND).build().perform();

	}

	public static void switchToNewTab(WebDriver driver) {
		// Get the handles of all open tabs/windows
		String firstTab = driver.getWindowHandle();
		for (String tab : driver.getWindowHandles()) {
			if (!tab.equals(firstTab)) {
				// Switch to the new tab
				driver.switchTo().window(tab);
				break;
			}
		}
	}

	public void switchToNewTab1(WebDriver driver) {
		// Get all window handles
		Set<String> handles = driver.getWindowHandles();

		// Switch to the new tab (assuming it's the last one in the set)
		for (String handle : handles) {
			driver.switchTo().window(handle);
		}
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void forwordPage() {
		driver.navigate().forward();
	}

	public void backwordPage() {
		driver.navigate().back();
	}

	public void launchUrl(String data) {
		driver.navigate().to(data);
	}

	public Timeouts implicitwait(long time) {
		Timeouts wait = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		return wait;
	}

	public void explicitWaitClickable(long time, WebElement name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		WebElement Click = wait.until(ExpectedConditions.elementToBeClickable(name));
		// Click.click();
	}

	public void explicitWaitAlert(long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileInputStream(getProjectPath() + "/config/config.properties"));
		Object object = p.get(key);
		String value = (String) object;
		return value;
	}

	public void getDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			// 1. Without opening the browser
			//options.addArguments("--headless");
			// 2. Maximize Window
			// options.addArguments("--start-maximized");
			// 3. Open in incognito
//			options.addArguments("--incognito");
			// 4. Disable Notification
			// options.addArguments("--disable-notifications");
			// (If we use this chrome options it will block the country code dropdown in the
			// Teacher Dashboard)
			// 5. Disable Popup
			options.addArguments("--disable-popup-blocking");
			// 6. To Remove Info-bars
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			// options.addArguments("--kiosk");
			// options.addArguments("disable-infobars");
			// options.addArguments("--disable-extensions");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-infobars");

//			options.AddUserProfilePreference("credentials_enable_service", false);
//			options.AddUserProfilePreference("profile.password_manager_enabled", false);
//
//			 options.AddArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized");
//			 options.AddUserProfilePreference("credentials_enable_service", false);
//			 options.AddUserProfilePreference("profile.password_manager_enabled", false);

			// 7. To remove Auto Save Password popup

			options.addArguments("--disable-extensions");
			options.addArguments("test-type");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}
	}

	public static byte[] Screenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] b = ts.getScreenshotAs(OutputType.BYTES);
		return b;

	}

	public void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void Command_T1() throws AWTException {

		// Create Robot object
		Robot robot = new Robot();

		// Press and hold the Command key (⌘)
		robot.keyPress(KeyEvent.VK_META);

		// Press the 'T' key
		robot.keyPress(KeyEvent.VK_T);

		// Release the 'T' key
		robot.keyRelease(KeyEvent.VK_T);

		// Release the Command key (⌘)
		robot.keyRelease(KeyEvent.VK_META);

	}

	public static JsonNode convertTextToJson(String text) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> keyValueMap = new TreeMap<>();

		String[] keyValuePairs = text.split("\\n");
		for (int i = 0; i < keyValuePairs.length - 1; i = +2) {
			String key = keyValuePairs[i];
			String value = keyValuePairs[i + 1];
			keyValueMap.put(key, value);
		}

		// Convert the LinkedHashMap to a JSON object
		return objectMapper.valueToTree(keyValueMap);
	}

	public void clickWithMultipleRetry(WebElement element, int maxRetries, long retryIntervalMillis) {
		int attempt = 1;
		while (attempt <= maxRetries) {
			try {
				element.click();
				break;
			} catch (ElementClickInterceptedException e) {
				System.out.println("Handling ElementClickInterceptedException - Attempt " + attempt);
				try {
					Thread.sleep(retryIntervalMillis);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
			attempt++;
		}
	}

	public void clickWithRetry(WebElement element) {
		try {
			element.click();
		} catch (ElementClickInterceptedException e) {
			// If Exception occurs, wait for a moment and retry
			sleep(500); // You might need to adjust the sleep duration
			element.click();
		}
	}

	public void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void HighlightOutput(String text) {
		String greenColor = "\u001B[38;5;118;1m";
		String resetColor = "\u001B[0m";
		String textToHighlight = text;
		System.out.println(greenColor + textToHighlight + resetColor);

	}

	public void HighlightOutput1(String text) {
		String yellowColor = "\u001B[38;5;118;1m";
		String resetColor = "\u001B[0m";
		String textToHighlight = text;
		System.out.print(yellowColor + textToHighlight + resetColor);

	}

	public void HighlightOutput2(String text) {
		String redColor = "\u001B[38;5;203;1m";
		String resetColor = "\u001B[0m";
		String textToHighlight = text;
		System.out.print(redColor + textToHighlight + resetColor);

	}

	public static boolean partialValidation(String[] actualValues, String[] expectedValues) {
		for (String expected : expectedValues) {
			boolean found = false;

			for (String actual : actualValues) {
				if (actual.contains(expected)) {
					found = true;

					break;
				}
			}

			if (!found) {
				return false;
			}
		}

		return true;
	}

	protected static boolean compareJsonNodes(JSONObject obj1, JSONObject obj2) {
		for (String key : obj1.keySet()) {
			// Check if the key exists in both objects
			if (obj2.has(key)) {
				// Get values associated with the keys
				Object value1 = obj1.get(key);
				Object value2 = obj2.get(key);

				// Recursively compare nested objects
				if (value1 instanceof JSONObject && value2 instanceof JSONObject) {
					if (!compareJsonNodes((JSONObject) value1, (JSONObject) value2)) {
						return false;
					}
				} else {
					// Compare non-object values
					if (!value1.equals(value2)) {
						return false;
					}
				}
			} else {
				// Key is missing in obj2
				return false;
			}
		}

		return true;
	}

	public static boolean compareMaps(Map<String, String> map1, Map<String, String> map2) {
		if (map1.size() != map2.size()) {
			return false;
		}

		for (Map.Entry<String, String> entry : map1.entrySet()) {
			String key = entry.getKey();
			Object value1 = entry.getValue();
			Object value2 = map2.get(key);

			if (!Objects.equal(value1, value2)) {
				return false;
			}
		}

		return true;
	}

	/*
	 * Window Handling
	 */

	public void switchToNewTabByIndex(WebDriver driver, int tabIndex) {
		// Get all window handles
		Set<String> handles = driver.getWindowHandles();

		// Convert set to list for easy indexing
		List<String> windowHandlesList = new ArrayList<>(handles);

		// Switch to the tab using the specified index
		if (tabIndex >= 0 && tabIndex < windowHandlesList.size()) {
			driver.switchTo().window(windowHandlesList.get(tabIndex));
		} else {
			System.out.println("Invalid tab index");
		}
	}

	/*
	 * Read the data from CSV using CSV Reader
	 */

	public static String readSpecificCell(String filePath, int targetRow, int targetColumn)
			throws IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader(filePath));

		String[] nextRecord;
		int rowNumber = 0;
		String targetCell = null;

		// Iterate through each line
		while ((nextRecord = reader.readNext()) != null) {
			// Check if it's the target row
			if (rowNumber == targetRow) {
				// Check if the target column exists
				if (targetColumn < nextRecord.length) {
					// Read the specific cell in the target row and column
					targetCell = nextRecord[targetColumn];
					// System.out.println("Cell value: " + targetCell);
				} else {
					System.out.println("Target column doesn't exist in the row.");
				}
				break; // Stop iterating after the target row
			}

			rowNumber++;
		}

		reader.close(); // Close the CSVReader when done
		return targetCell;
	}

	public static void pasteTextRobot(Robot robot) {
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);

		robot.delay(500);
	}

	public static void openSearchTabRobot(Robot robot) {
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);

		robot.delay(500);
	}

	public static void EnterRobot(Robot robot) {
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.delay(500);
	}

	public static void command_TabRobot(Robot robot) {
		robot.delay(500);

		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);

	}

	public static void tabRobot(Robot robot) {
		robot.delay(500);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

	}

	public static void pasteFilePath(String filePath) throws AWTException {
		Robot robot = new Robot();

		robot.delay(500);

		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.delay(500);

		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);

		robot.delay(500);

		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);

		robot.delay(500);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.delay(500);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public boolean selectDdnByTextWithCondition1(WebElement dropdown, String conditionText) {
		// Click the dropdown to open the options
		explicitWaitClickable(20, dropdown);
		clickWithRetry(dropdown);

		// Check if the condition text is present in the dropdown options
		if (dropdown.getText().contains(conditionText)) {
			// Select the desired option by text
			selectDdnByText(dropdown, conditionText);
			return true; // Return true if the selection was successful
		} else {
			System.out.println("Condition not met. Selection aborted.");
			return false; // Return false if the condition was not met
		}
	}

	public String selectDdnByTextWithCondition(WebElement dropdown, String conditionText) {
		// Click the dropdown to open the options
		explicitWaitClickable(20, dropdown);
		// clickWithRetry(dropdown);

		// Get all options from the dropdown
		List<WebElement> options = dropdown.findElements(By.tagName("option"));

		System.out.println(options);

		// Check if the condition text is present in any of the dropdown options
		for (WebElement option : options) {
			if (option.getText().contains(conditionText)) {
				// Select the desired option by text
				selectDdnByText(dropdown, option.getText());
				return option.getText(); // Return the text of the selected option
			}
		}

		// If the condition was not met, print a message and return null
		System.out.println("Condition not met. Selection aborted.");
		return null;
	}

	public static void selectOptionByPartialText(WebDriver driver, WebElement dropdown, String partialText) {
		// Click the dropdown to open the options
		// dropdown.click();

		// Locate all options in the dropdown
		Select select = new Select(dropdown);

		// Iterate through each option to find the one with partial text
		for (WebElement option : select.getOptions()) {
			String text = option.getText();
			String splitAndMergeString = SplitAndMergeString(text);
			if (splitAndMergeString.contains(partialText)) {
				// Select the option if partial text is found
				select.selectByVisibleText(option.getText());
				System.out.println("Selected option: " + option.getText());
				return; // Exit the method after selecting the option
			}
		}

	}

	/*
	 * 
	 * public static void selectOptionByPartialText(WebDriver driver, WebElement
	 * dropdown, String partialText) { // Click the dropdown to open the options //
	 * dropdown.click();
	 * 
	 * // Locate all options in the dropdown Select select = new Select(dropdown);
	 * 
	 * // Iterate through each option to find the one with partial text for
	 * (WebElement option : select.getOptions()) { if
	 * (option.getText().contains(partialText)) { // Select the option if partial
	 * text is found select.selectByVisibleText(option.getText());
	 * System.out.println("Selected option: " + option.getText()); return; // Exit
	 * the method after selecting the option } }
	 * 
	 * }
	 */

	public static Map<String, String> convertCsvToMap(String filePath, int rowNum) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
//		String line;
		Map<String, String> map = new HashMap<>();

		// Read the first line to get the keys
		String[] keys = br.readLine().split(",");

		for (int i = 0; i < keys.length; i++) {
			String value = getCellValue(filePath, rowNum, i);
			map.put(keys[i], value);
		}

		br.close();
		return map;
	}

	private static String getCellValue(String filePath, int rowNum, int colNum) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line;
		int currentRow = 0;

		// Skip rows until reaching the desired row
		while (currentRow < rowNum) {
			br.readLine();
			currentRow++;
		}

		// Read the desired row
		line = br.readLine();

		br.close();

		if (line != null) {
			String[] values = line.split(",");
			if (colNum >= 0 && colNum < values.length) {
				return values[colNum];
			} else {
				throw new IllegalArgumentException("Invalid column number");
			}
		} else {
			throw new IllegalArgumentException("Invalid row number");
		}
	}

	public static String SplitAndMergeString(String string) {

		String[] words = string.split("\\s+");

		// Merge the words
		String mergedString = String.join("", words);

		// Display the result
		System.out.println("Merged String: " + mergedString);
		return mergedString;
	}

	public static Map<String, String> createMapFromKeyValuePairs(String[] keyValuePairs) {
		Map<String, String> resultMap = new TreeMap<>();

		for (int i = 0; i < keyValuePairs.length - 1; i += 2) {
			String key = keyValuePairs[i];
			String value = keyValuePairs[i + 1];
			resultMap.put(key, value);
		}

		return resultMap;
	}

	/*
	 * Delete a row from csv
	 */

	public void DeleteRowFromCSV(String filePath, int rowNumber) throws IOException, CsvException {

		CSVReader reader2 = new CSVReader(new FileReader(filePath));
		List<String[]> allElements = reader2.readAll();
		allElements.remove(rowNumber);

		FileWriter sw = new FileWriter(filePath);
		CSVWriter writer = new CSVWriter(sw);
		writer.writeAll(allElements);
		writer.close();

		System.out.println("Row " + rowNumber + " deleted successfully.");

	}

	public void ExplicityWaitStaleness(WebElement webelement) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.stalenessOf(webelement));

	}

	public void datePcikerByJS(WebDriver driver, String time, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + time + "')", element);
	}

	/*
	 * scroll Using Coordinates
	 */

	public static void scrollUsingCoordinates(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(" + x + ", " + y + ");");

	}

	/*
	 * Click Element With JavaScript
	 */
	public static void clickElementWithJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);
	}
	
	public List<WebElement> getAllOption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> list = s.getOptions();
		return list;
	}

}
