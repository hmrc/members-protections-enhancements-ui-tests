/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait}
import org.openqa.selenium.By
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.webdriver.Driver

import scala.language.postfixOps
import scala.util.Random

object MemberDetails extends BasePage {

  private val dashboardUrl: String =
    TestEnvironment.url("members-protections-and-enhancements-frontend") + "/members-protections-and-enhancements"

  def waitForElement(by: By): Unit =
    new FluentWait(Driver.instance).until(ExpectedConditions.presenceOfElementLocated(by))

  def startNow(): Unit =
    click(startNowButton)

  def continue(): Unit =
    click(continueButton)

  def submit(): Unit =
    click(submitButton)

  def enterName(firstName: String, lastName: String): Unit = {
    sendKeys(By.id("firstName"), firstName)
    sendKeys(By.id("lastName"), lastName)
    click(continueButton)
  }

  def enterDateOfBirth(day: String, month: String, year: String): Unit = {
    sendKeys(By.id("dateOfBirth.day"), day)
    sendKeys(By.id("dateOfBirth.month"), month)
    sendKeys(By.id("dateOfBirth.year"), year)
    click(continueButton)
  }

  def generateNino(prefix: String = "AA"): String = {
    val num         = Random.nextInt(1000000)
    val suffix      = "A"
    val str: String = Random.alphanumeric.filter(_.isLetter).take(2).map(_.toUpper).mkString

    prefix + f"$str$num%06d$suffix".drop(prefix.length)
  }

  def enterNINO(name: String): Unit = {
    val randomNINO = generateNino(name)
    sendKeys(By.id("nino"), randomNINO)
    click(continueButton)
  }

  def generateTrn(prefix: String = "11"): String = {
    val num            = Random.nextInt(100000)
    val str: Char      = Random.alphanumeric.filter(_.isLetter).head.toUpper
    val prefixNum: Int = Random.nextInt(100)

    prefix + f"$prefixNum%02d$str$num%05d".drop(prefix.length)
  }

  def enterTRN(name: String): Unit = {
    val randomTRN = generateTrn(name)
    sendKeys(By.id("nino"), randomTRN)
    click(continueButton)
  }

  def generateCheckRef(prefix: String = ""): String = {
    val num       = Random.nextInt(100000000)
    val str: Char = Random.alphanumeric.filter(_.isLetter).head.toUpper
    prefix + f"PSA$num%08d$str".drop(prefix.length)
  }

  def enterPSACheckRef(name: String): Unit = {
    val randomPSACheckRef: String = generateCheckRef(name)
    sendKeys(By.id("psaCheckRef"), randomPSACheckRef)
    click(continueButton)
  }

  def clickLink(link: String): Unit =
    click(By.id(link))

  def checkJourneyUrl(page: String): Unit =
    val url = s"$dashboardUrl/$page"
    fluentWait.until(ExpectedConditions.urlContains(url))
    getCurrentUrl.startsWith(url)

}
