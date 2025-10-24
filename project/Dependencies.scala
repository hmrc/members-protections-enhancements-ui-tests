import sbt.*

object Dependencies {

  // format: off
  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"         %% "ui-test-runner"     % "0.50.0",
    "junit"                % "junit"              % "4.13.2",
  ).map(_ % Test)
  // format: on

}
