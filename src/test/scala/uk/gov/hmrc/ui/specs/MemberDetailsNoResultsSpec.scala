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

class MemberDetailsNoResultsSpec extends BaseSpec {

  private val auth          = Auth
  private val memberDetails = MemberDetails

  Feature("As a PSA/PSP User I want to login and navigate to No Results Page") {

    Scenario(
      "Happy Path Journey - Navigate to No Results page when details entered within the Lifetime Protections and Enhancements service do not match an existing protection certificate."
    ) {

      Given("I fill in the auth details for enrolmentID with value enrolmentValue")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard("PSP")

      When("I click the Start now link")
      memberDetails.checkJourneyUrl("start")
      memberDetails.startNow()

      And("I fill in the First Name and Last Name")
      memberDetails.checkJourneyUrl("members-name")
      memberDetails.enterName("Mile", "Slatcher")

      And("I fill in the Date Of Birth")
      memberDetails.checkJourneyUrl("members-date-of-birth")
      memberDetails.enterDateOfBirth("15", "7", "1942")

      And("I fill in the National Insurance Page")
      memberDetails.checkJourneyUrl("members-national-insurance-number")
      memberDetails.enterNINO("EC1")

      And("I fill in the PSA Check Reference Number")
      memberDetails.checkJourneyUrl("members-pension-scheme-administrator-check-reference")
      memberDetails.enterPSACheckRef("PSA567")

      And("I click the Submit button")
      memberDetails.checkJourneyUrl("check-your-answers")
      memberDetails.submit()

      Then("I should be on No Results page")
      memberDetails.checkJourneyUrl("no-results")

    }
  }
}
