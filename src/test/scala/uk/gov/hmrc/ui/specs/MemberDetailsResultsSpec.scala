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

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.{Auth, MemberDetails}

class MemberDetailsResultsSpec extends BaseSpec {

  private val auth          = Auth
  private val memberDetails = MemberDetails

  Feature("As a PSA/PSP User I want to login and navigate to Results Page") {

    Scenario(
      "Happy Path Journey - Navigate to Results page and verify if the members details are matched successfully for the Protections with valid NINO"
    ) {

      Given("I fill in the auth details for enrolmentID with value enrolmentValue")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("PSA")

      When("I click the Start now link")
      memberDetails.checkJourneyUrl("start")
      memberDetails.startNow()

      And("I fill in the First Name and Last Name")
      memberDetails.checkJourneyUrl("members-name")
      memberDetails.enterName("John", "Smith")

      And("I fill in the Date Of Birth")
      memberDetails.checkJourneyUrl("members-date-of-birth")
      memberDetails.enterDateOfBirth("10", "09", "1954")

      And("I fill in the National Insurance Page")
      memberDetails.checkJourneyUrl("members-national-insurance-number")
      memberDetails.enterNINO("JX9")

      And("I fill in the PSA Check Reference Number")
      memberDetails.checkJourneyUrl("members-pension-scheme-administrator-check-reference")
      memberDetails.enterPSACheckRef("PSA123")

      And("I click the Submit button")
      memberDetails.checkJourneyUrl("check-your-answers")
      memberDetails.submit()

      Then("I should be on Results page")
      memberDetails.checkJourneyUrl("results")

    }

    Scenario(
      "Happy Path Journey - Navigate to Results page and verify if the members details are matched successfully for the Protection and Enhancements with valid TRN number"
    ) {

      Given("I fill in the auth details for enrolmentID with value enrolmentValue")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("PSP")

      When("I click the Start now link")
      memberDetails.checkJourneyUrl("start")
      memberDetails.startNow()

      And("I fill in the First Name and Last Name")
      memberDetails.checkJourneyUrl("members-name")
      memberDetails.enterName("Alan", "Williams")

      And("I fill in the Date Of Birth")
      memberDetails.checkJourneyUrl("members-date-of-birth")
      memberDetails.enterDateOfBirth("27", "02", "1949")

      And("I fill in the TRN number")
      memberDetails.checkJourneyUrl("members-national-insurance-number")
      memberDetails.enterTRN("66Q")

      And("I fill in the PSA Check Reference Number")
      memberDetails.checkJourneyUrl("members-pension-scheme-administrator-check-reference")
      memberDetails.enterPSACheckRef("PSA234")

      And("I click the Submit button")
      memberDetails.checkJourneyUrl("check-your-answers")
      memberDetails.submit()

      Then("I should be on Results page")
      memberDetails.checkJourneyUrl("results")

    }

    Scenario(
      "Happy Path Journey - Navigate to Results page and verify if the members details are matched successfully for multiple Protections and Enhancements"
    ) {

      Given("I fill in the auth details for enrolmentID with value enrolmentValue")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("PSA")

      When("I click the Start now link")
      memberDetails.checkJourneyUrl("start")
      memberDetails.startNow()

      And("I fill in the First Name and Last Name")
      memberDetails.checkJourneyUrl("members-name")
      memberDetails.enterName("Pearl", "Brown")

      And("I fill in the Date Of Birth")
      memberDetails.checkJourneyUrl("members-date-of-birth")
      memberDetails.enterDateOfBirth("02", "12", "1939")

      And("I fill in the National Insurance Page")
      memberDetails.checkJourneyUrl("members-national-insurance-number")
      memberDetails.enterNINO("NW9")

      And("I fill in the PSA Check Reference Number")
      memberDetails.checkJourneyUrl("members-pension-scheme-administrator-check-reference")
      memberDetails.enterPSACheckRef("PSA678")

      And("I click the Submit button")
      memberDetails.checkJourneyUrl("check-your-answers")
      memberDetails.submit()

      Then("I should be on Results page")
      memberDetails.checkJourneyUrl("results")
    }
  }
}
