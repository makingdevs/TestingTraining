import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver

waiting {
  timeout = 2
}

environments {

  chrome {
    driver = { new ChromeDriver() }
  }

  chromeHeadless {
    driver = {
      ChromeOptions o = new ChromeOptions()
      o.addArguments('headless')
      new ChromeDriver(o)
    }
  }

  firefox {
    atCheckWaiting = 1

    driver = { new FirefoxDriver() }
  }

}

reportOnTestFailureOnly = false
baseUrl = "http://gebish.org"

