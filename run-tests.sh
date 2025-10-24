#!/bin/bash -e

sbt clean -Dbrowser="chrome" -Denvironment="local" -Dbrowser.option.headless=false -Daccessibility.timeout="1000" "testOnly uk.gov.hmrc.ui.specs.*" testReport
